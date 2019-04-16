package com.bw.movie.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    protected P presenter;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(providerLayoutId());
        ButterKnife.bind(this);
        presenter = providerPresenter();
        initView();
        initListener();
        initData();
    }

    protected abstract void initData();

    protected abstract P providerPresenter();

    protected void initListener(){};

    protected abstract void initView();

    protected abstract int providerLayoutId();

}
