package com.basemodule.baserx;

import android.content.Context;

import com.basemodule.R;
import com.basemodule.base.IBaseApplication;
import com.basemodule.utils.NetWorkUtils;
import com.orhanobut.logger.Logger;

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

    private String msg;

    public RxSubscriber(Context context, String msg) {
        this.mContext = context;
        this.msg = msg;
    }

    public RxSubscriber(Context context) {
        this(context, IBaseApplication.getAppInstance().getString(R.string.loading));
    }

    @Override
    public void onCompleted() {
        _onAfter();
    }

    @Override
    public void onStart() {
        super.onStart();
        _onStart();
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        _onAfter();

        Logger.d(TAG, "onError: " + e.getMessage());

        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(IBaseApplication.getAppInstance())) {
            _onError(IBaseApplication.getAppInstance().getString(R.string.no_net));
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
