package com.basemodule.base;

import android.content.Context;

import com.basemodule.baserx.RxManager;

/**
 * Created by long on 2016/8/23.
 * 基础 Presenter
 */
public abstract class IBasePresenter<T extends IBaseView, E extends IBaseModel> {

    public Context mContext;

    public E mModel;

    public T mView;

    public RxManager mRxManage = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        mModel.setTag(mContext);
        this.onStart();
    }

    /**
     * 获取网络数据，更新界面
     */
    /**
     * 获取网络数据，更新界面
     * @param isRefresh 新增参数，用来判断是否为下拉刷新调用，下拉刷新的时候不应该再显示加载界面和异常界面
     */
    public void getData(boolean isRefresh){
    }

    /**
     * 加载更多数据
     */
    public  void getMoreData(){
    }

    public void onStart() {
    }

    public void onDestroy() {
        mRxManage.clear();
    }
}
