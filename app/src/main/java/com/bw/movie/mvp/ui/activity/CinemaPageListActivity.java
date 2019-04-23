package com.bw.movie.mvp.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.CinemaPageListBean;
import com.bw.movie.bean.MoviePageListBean;
import com.bw.movie.mvp.contart.CinemaPageListContart;
import com.bw.movie.mvp.presneter.CinemaPageListPresenter;
import com.bw.movie.mvp.ui.adapter.CinemapageListAdapter;
import com.bw.movie.mvp.ui.adapter.MoviePageListAdapter;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CinemaPageListActivity extends BaseActivity<CinemaPageListPresenter> implements CinemaPageListContart.CinemaPageListView {


    @BindView(R.id.btn1)
    RadioButton btn1;
    @BindView(R.id.btn2)
    RadioButton btn2;
    @BindView(R.id.navigation_btn)
    RadioGroup navigationBtn;
    @BindView(R.id.my_fragment_recy)
    RecyclerView myFragmentRecy;
    private CinemapageListAdapter cinemapageListAdapter;
    private MoviePageListAdapter moviePageListAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected CinemaPageListPresenter providerPresenter() {
        return new CinemaPageListPresenter(this);
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        myFragmentRecy.setLayoutManager(new LinearLayoutManager(this));
        presenter.getMoviePageList("1", "10");
        cinemapageListAdapter = new CinemapageListAdapter(this);
        moviePageListAdapter = new MoviePageListAdapter(this);
    }

    @Override
    protected int providerLayoutId() {
        StatusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_cinema_page_list;
    }

    @Override
    public void success(CinemaPageListBean result) {
        Toast.makeText(this, "" + result.getResult().size(), Toast.LENGTH_SHORT).show();
        cinemapageListAdapter.setList(result.getResult());
        myFragmentRecy.setAdapter(cinemapageListAdapter);
    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void MoviePageListsuccess(MoviePageListBean result) {
        Toast.makeText(this, "" + result.getResult().size(), Toast.LENGTH_SHORT).show();
        moviePageListAdapter.setList(result.getResult());
        myFragmentRecy.setAdapter(moviePageListAdapter);
    }

    @Override
    public void MoviePageListfailure(String msg) {

    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                btn1.setTextColor(Color.WHITE);
                btn2.setTextColor(Color.BLACK);
                presenter.getMoviePageList("1", "10");
                myFragmentRecy.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.btn2:
                btn1.setTextColor(Color.BLACK);
                btn2.setTextColor(Color.WHITE);
                presenter.gettext("1","10");
                break;
        }
    }
}
