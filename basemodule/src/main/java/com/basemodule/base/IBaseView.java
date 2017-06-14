package com.basemodule.base;

/**
 * Created by long on 2016/8/23.
 * 基础 BaseView 接口
 */
public interface IBaseView {

    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 带有文字的加载动画
     *
     * @param notice
     */
    void showLoading(String notice);

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 展示错误提示
     *
     * @param msg
     */
    void showErrorTip(String msg);
}
