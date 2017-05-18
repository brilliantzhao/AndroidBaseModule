package com.brilliant.module;

import com.basemodule.base.IBaseActivity;

public class MainActivity extends IBaseActivity {

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
    public void initData() {
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
