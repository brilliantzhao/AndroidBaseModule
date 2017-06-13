package com.brilliant.module;

import android.os.Bundle;

import com.basemodule.base.IBaseActivity;

public class MainActivity extends IBaseActivity {

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
