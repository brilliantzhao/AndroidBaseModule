package com.basemodule.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.basemodule.R;
import com.basemodule.baseapp.AppManager;
import com.basemodule.baserx.RxManager;
import com.basemodule.utils.DisplayUtil;
import com.basemodule.utils.TUtil;
import com.basemodule.utils.log.MyLogUtil;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/***************使用例子*********************/
//1.mvp模式
//public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleActivity extends BaseActivity {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}
public abstract class IBaseActivity<T extends IBasePresenter, E extends IBaseModel> extends RxAppCompatActivity
        implements IBaseView {

    //##########################  custom variables start ##########################################

    public final String TAG = this.getClass().getSimpleName();

    public T mPresenter;

    public E mModel;

    public Context mContext;

    public RxManager mRxManager;

    //##########################   custom variables end  ##########################################

    //######################  override methods start ##############################################

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager = new RxManager();
        // 为了方便实用dataBinding,不再这里绑定布局
//         setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        this.initPresenter();
        this.initView();
        this.initData(savedInstanceState);
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        mRxManager.clear();
        // 结束Activity从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }

    //######################   override methods end  ##############################################

    //###################### override custom metohds start ########################################

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }

    //######################  override custom metohds end  ########################################

    //######################      custom metohds start     ########################################

    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    public abstract void initView();

    //初始化data数据
    public abstract void initData(Bundle savedInstanceState);

    /**
     * 适用于自定义状态栏颜色，同时不影响页面布局的页面(页面布局不会向上占据状态栏位置)
     * <p>
     * 设置状态栏颜色
     *
     * @param color
     */
    protected void initWindows(int color) {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(color);
            //设置导航栏颜色
            window.setNavigationBarColor(color);
            ViewGroup contentView = ((ViewGroup) findViewById(android.R.id.content));
            View childAt = contentView.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            //设置contentview为fitsSystemWindows
            ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
            View childAt = contentView.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
            //给statusbar着色
            View view = new View(this);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DisplayUtil.getStatusBarHeight(this)));
            view.setBackgroundColor(color);
            contentView.addView(view);
        }
    }

    /**
     * 适用于启动页和引导页等需要全屏展示的页面(页面布局会向上占据状态栏位置)
     * <p>
     * 状态栏浮在全屏的页面上面
     *
     * @param paramActivity
     */
    protected void setSystemBarTransparent(Activity paramActivity) {
        Window window = paramActivity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //api 21 解决方案
            View systemdecor = window.getDecorView();
            systemdecor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            layoutParams.flags |= WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;
            window.setStatusBarColor(0x00000000);
        } else {
            //api 19 解决方案
            layoutParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        }
        window.setAttributes(layoutParams);
    }

    /**
     * 适用于需要全屏展示,同时布局不会占据状态栏的页面(页面布局不会向上占据状态栏位置)
     * <p>
     * 方式1：使用系统的方法
     * 注意：需要在页面的根布局下面的第一个子布局加上下面两个属性，才能布局不会顶到最上面
     * android:fitsSystemWindows="true"
     * android:clipToPadding="true"
     */
    protected void initTitleBarWithSystem() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏 这种做法在虚拟键盘位于屏幕底部的手机上时，会导致虚拟键盘遮挡底部的布局，所以不建议使用
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 适用于需要全屏展示,同时布局不会占据状态栏的页面(页面布局不会向上占据状态栏位置)
     * <p>
     * 方式2：使用动态的设置状态栏高度的方式
     * 注意：需要在布局文件中include状态栏的布局文件，代码如下：
     * <include layout="@layout/basemod_layout_status_bar" />
     */
    protected void initTitleBarWithSyncHeight() {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //透明导航栏 这种做法在虚拟键盘位于屏幕底部的手机上时，会导致虚拟键盘遮挡底部的布局，所以不建议使用
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            // 自定义的状态栏
            LinearLayout linear_bar = (LinearLayout) findViewById(R.id.layout_status_bar);
            linear_bar.setVisibility(View.VISIBLE);
            //获取到状态栏的高度
            int statusHeight = DisplayUtil.getStatusBarHeight(this);
            MyLogUtil.d("statusHeight = " + statusHeight);
            //动态的设置隐藏布局的高度
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear_bar.getLayoutParams();
            params.height = statusHeight;
            linear_bar.setLayoutParams(params);
        }
    }

    //######################    custom metohds end   ##############################################

}
