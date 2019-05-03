package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.presneter.XiangPresenter;
import com.bw.movie.mvp.ui.adapter.CinemaslistAdapter;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CinemasListByMovieIdActivity extends BaseActivity<XiangPresenter>
        implements XiangContart.IXiangtopView, CinemaslistAdapter.onclicklisnter {


    @BindView(R.id.cinemaslistbymovieid_recy)
    RecyclerView cinemaslistbymovieidRecy;
    @BindView(R.id.cinemaslistbymovieid_name)
    TextView cinemaslistbymovieidName;
    @BindView(R.id.back)
    ImageView back;
    private CinemaslistAdapter cinemaslistAdapter;
    private StatusBarUtil statusBarUtil;
    private String movieid;

    @Override
    protected void initData() {

    }

    @Override
    protected XiangPresenter providerPresenter() {
        return new XiangPresenter(this);
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        Intent intent = getIntent();
        movieid = intent.getStringExtra("movieid");
        String moviename = intent.getStringExtra("moviename");
        cinemaslistbymovieidName.setText(moviename);
        cinemaslistAdapter = new CinemaslistAdapter(this);
        cinemaslistAdapter.setOnclicklisnter(this);
        cinemaslistbymovieidRecy.setLayoutManager(new LinearLayoutManager(this));
        presenter.getCinemasListByMovieId(movieid);
    }

    @Override
    public void click(String cid, int bb) {

    }

    @Override
    public void clickitem(String cid, String name, String address) {
        Intent intent = new Intent(this, MovieScheduleListActivity.class);
        intent.putExtra("movieid", movieid);
        intent.putExtra("cinemasId", cid);
        intent.putExtra("cinemasname", name);
        intent.putExtra("cinemasaddress", address);
        startActivity(intent);
    }


    @Override
    protected int providerLayoutId() {
        statusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_cinemas_list_by_movie_id;
    }

    @Override
    public void success(XiangBean resultBean) {

    }

    @Override
    public void faild(Throwable t) {

    }

    @Override
    public void pingsuccess(PingBean resultBean) {

    }

    @Override
    public void pingfaild(Throwable t) {

    }

    @Override
    public void CinemasListByMovieIdsuccess(CinemasListByMovieIdBean result) {
        cinemaslistAdapter.setList(result.getResult());
        cinemaslistbymovieidRecy.setAdapter(cinemaslistAdapter);
    }

    @Override
    public void CinemasListByMovieIdfaild(Throwable t) {

    }

    @Override
    public void addpingsuccess(String result) {

    }

    @Override
    public void addpingfailure(String msg) {

    }

    @Override
    public void guanzhusuccess(BaseBean result) {

    }

    @Override
    public void guanzhufaild(Throwable t) {

    }

    @Override
    public void quxiaosuccess(BaseBean result) {

    }

    @Override
    public void quxiaofaild(Throwable t) {

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
