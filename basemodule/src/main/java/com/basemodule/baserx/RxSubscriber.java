package com.basemodule.baserx;

import android.app.Dialog;
import android.content.Context;

import com.basemodule.R;
import com.basemodule.base.IBaseApplication;
import com.basemodule.utils.NetWorkUtils;
import com.basemodule.utils.log.MyLogUtil;

import rx.Subscriber;

/**
 * des:订阅封装
 * Created by xsf
 * on 2016.09.10:16
 */

/********************
 * 使用例子
 ********************/
/*_apiService.login(mobile, verifyCode)
        .//省略
        .subscribe(new RxSubscriber<User user>(mContext,false) {
@Override
public void _onNext(User user) {
        // 处理user
        }

@Override
public void _onError(String msg) {
        ToastUtil.showShort(mActivity, msg);
        });*/
public abstract class RxSubscriber<T> extends Subscriber<T> {

    private static final String TAG = "RxSubscriber_ONERROR";

    private Context mContext;

    private boolean showDialog = true;

    private Dialog dialog;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = true;
    }

    public RxSubscriber(Context context, boolean showDialog) {
        this.mContext = context;
        this.showDialog = showDialog;
    }

    @Override
    public void onCompleted() {
        if (showDialog) stopProgressDialog();
        _onAfter();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (showDialog) startProgressDialog();
        _onStart();
    }

    /**
     */
    private void startProgressDialog() {
        if (dialog == null) {
            dialog = IBaseApplication.getProgressDialog();
        }
        dialog.show();
    }

    /**
     *
     */
    private void stopProgressDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        _onAfter();

        MyLogUtil.d(TAG, "onError: " + e.getMessage());

        if (showDialog)
            stopProgressDialog();
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(IBaseApplication.getAppInstance())) {
            _onError(IBaseApplication.getAppInstance().getString(R.string.basemod_no_net));
        }
        //服务器
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        }
        //手动抛出
        else if (e instanceof IllegalStateException) {
            _onError(e.getMessage());
        }
//        //其它
//        else {
//            _onError(IBaseApplication.getAppContext().getString(R.string.net_error));
//        }
    }

    protected void _onStart() {
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

    protected void _onAfter() {
    }

}
