package com.brilliant.module;

import android.widget.TextView;

import com.basemodule.base.IBaseActivity;

import butterknife.BindView;

public class MainActivity extends IBaseActivity {

    @BindView(R.id.main_content)
    TextView main_content;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void initView() {
        main_content.setText("hello");
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
