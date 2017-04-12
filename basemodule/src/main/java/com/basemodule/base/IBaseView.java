package com.basemodule.base;

import com.trello.rxlifecycle.LifecycleTransformer;

import java.lang.reflect.ParameterizedType;

/**
 * Created by long on 2016/8/23.
 * 基础 BaseView 接口
 */
public interface IBaseView extends ParameterizedType {

    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 绑定生命周期
     *
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bindToLife();

    /**
     * 展示错误提示
     *
     * @param msg
     */
    void showErrorTip(String msg);
}
