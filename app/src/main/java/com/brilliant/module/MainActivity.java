package com.brilliant.module;

import android.os.Bundle;

import com.basemodule.base.IBaseActivity;

public class MainActivity extends IBaseActivity {

    // IBaseActivity中注掉了setContentView(getLayoutId());，为了方便使用dataBinding,所以这里需要添加onCreate
    // 方法
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData(Bundle savedInstanceState) {
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void showLoading(String notice) {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showErrorTip(String msg) {

    }
}
