package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.MovieScheduleListContart;
import com.bw.movie.mvp.presneter.MovieScheduleListPresenter;
import com.bw.movie.mvp.ui.adapter.SchedulelistAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieScheduleListActivity extends BaseActivity<MovieScheduleListPresenter>
        implements MovieScheduleListContart.IMovieScheduleListView,SchedulelistAdapter.setScheduleOnclicklisenter {


    @BindView(R.id.schedule_yingyuan_name)
    TextView scheduleYingyuanName;
    @BindView(R.id.schedule_yingyuan_address)
    TextView scheduleYingyuanAddress;
    @BindView(R.id.schedule_dianying_image)
    SimpleDraweeView scheduleDianyingImage;
    @BindView(R.id.schedule_dianying_name)
    TextView scheduleDianyingName;
    @BindView(R.id.schedule_dianying_typetext)
    TextView scheduleDianyingTypetext;
    @BindView(R.id.schedule_dianying_director)
    TextView scheduleDianyingDirector;
    @BindView(R.id.schedule_dianying_minute)
    TextView scheduleDianyingMinute;
    @BindView(R.id.schedule_dianying_place)
    TextView scheduleDianyingPlace;
    @BindView(R.id.schedule_recy)
    RecyclerView scheduleRecy;
    private SchedulelistAdapter schedulelistAdapter;
    private String cinemasname;
    private String cinemasaddress;
    private String name;

    @Override
    protected void initData() {

    }

    @Override
    protected MovieScheduleListPresenter providerPresenter() {
        return new MovieScheduleListPresenter(this);
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String movieid = intent.getStringExtra("movieid");
        String cinemasId = intent.getStringExtra("cinemasId");
        cinemasname = intent.getStringExtra("cinemasname");
        cinemasaddress = intent.getStringExtra("cinemasaddress");
        scheduleYingyuanName.setText(cinemasname);
        scheduleYingyuanAddress.setText(cinemasaddress);
        scheduleRecy.setLayoutManager(new LinearLayoutManager(this));
        presenter.getKeyorNum(movieid);
        presenter.getMovieScheduleList(movieid, cinemasId);
        schedulelistAdapter = new SchedulelistAdapter(this);
        schedulelistAdapter.setSetScheduleOnclicklisenter(this);
    }

    @Override
    protected int providerLayoutId() {
        StatusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_movie_schedule_list;
    }

    @Override
    public void success(XiangBean resultBean) {
        name = resultBean.getResult().getName();
        scheduleDianyingName.setText(resultBean.getResult().getName());
        scheduleDianyingTypetext.setText(getString(R.string.app_leixing)+resultBean.getResult().getMovieTypes());
        scheduleDianyingDirector.setText(getString(R.string.app_daoyan)+resultBean.getResult().getDirector());
        scheduleDianyingMinute.setText(getString(R.string.app_shichang)+resultBean.getResult().getDuration());
        scheduleDianyingPlace.setText(getString(R.string.app_chandi)+resultBean.getResult().getPlaceOrigin());
        Uri uri = Uri.parse(resultBean.getResult().getImageUrl());
        scheduleDianyingImage.setImageURI(uri);

    }

    @Override
    public void faild(Throwable t) {

    }

    @Override
    public void MovieScheduleListsuccess(MovieScheduleListBean result) {
        schedulelistAdapter.setList(result.getResult());
        scheduleRecy.setAdapter(schedulelistAdapter);
    }

    @Override
    public void MovieScheduleListfaild(Throwable t) {

    }

    @Override
    public void click(String time, String ScreeningHall,double price) {
        Intent intent = new Intent(this,XuanzuoActivity.class);
        intent.putExtra("time",time);
        intent.putExtra("ScreeningHall",ScreeningHall);
        intent.putExtra("cinemasname",cinemasname);
        intent.putExtra("cinemasaddress",cinemasaddress);
        intent.putExtra("name",name);
        intent.putExtra("price",price);
        startActivity(intent);
    }
}
