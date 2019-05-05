package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.MovieListByCinemaIdBean;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.mvp.contart.TuijianContart;
import com.bw.movie.mvp.presneter.TuijianPresenter;
import com.bw.movie.mvp.ui.adapter.MovieListByCinemaIdAdapter;
import com.bw.movie.mvp.ui.adapter.SchedulelistAdapter;
import com.bw.movie.mvp.ui.adapter.homeitem.BannerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

public class CinemainfoActivity extends BaseActivity<TuijianPresenter>
        implements TuijianContart.ICircleView,SchedulelistAdapter.setScheduleOnclicklisenter {


    @BindView(R.id.cinema_logo)
    SimpleDraweeView cinemaLogo;
    @BindView(R.id.cinema_name)
    TextView cinemaName;
    @BindView(R.id.cinema_title)
    TextView cinemaTitle;
    @BindView(R.id.cinema_navigation)
    ImageView cinemaNavigation;
    @BindView(R.id.cinema_coverflow)
    RecyclerCoverFlow cinemaCoverflow;
    @BindView(R.id.textlinear)
    TextView textlinear;
    @BindView(R.id.cinema_recy)
    RecyclerView cinemaRecy;
    private List<MovieListByCinemaIdBean.ResultBean> bannerslist;
    private String cinemasId;
    private SchedulelistAdapter schedulelistAdapter;
    private String imageurl;
    private String cinemaname;
    private String cinemaaddress;
    private String name;

    @Override
    protected void initData() {
        presenter.getbannKeyorNum(cinemasId);
        presenter.getCinemaInfocidKeyorNum(cinemasId);
        schedulelistAdapter = new SchedulelistAdapter(this);
        schedulelistAdapter.setSetScheduleOnclicklisenter(this);
        cinemaCoverflow.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                int movieId = bannerslist.get(position).getId();
                name = bannerslist.get(position).getName();
                presenter.getMovieScheduleList(movieId+"",cinemasId);
            }
        });
    }


    @Override
    protected TuijianPresenter providerPresenter() {
        return new TuijianPresenter(this);
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        Intent intent = getIntent();
        cinemasId = intent.getStringExtra("cinemaId");
        imageurl = intent.getStringExtra("imageurl");
        cinemaname = intent.getStringExtra("cinemaname");
        cinemaaddress = intent.getStringExtra("cinemaaddress");
        cinemaName.setText(cinemaname);
        cinemaTitle.setText(cinemaaddress);
        Uri uri = Uri.parse(imageurl);
        cinemaLogo.setImageURI(uri);
        cinemaRecy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int providerLayoutId() {
        StatusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_cinemainfo;
    }

    @Override
    public void CinemaInfosuccess(CinemaInfoBean result) {
    }

    @Override
    public void CinemaInfofaild(Throwable t) {

    }

    @Override
    public void bannsuccess(MovieListByCinemaIdBean result) {
        bannerslist = result.getResult();
        MovieListByCinemaIdAdapter bannerAdapter = new MovieListByCinemaIdAdapter(this, bannerslist);
        cinemaCoverflow.setAdapter(bannerAdapter);
        presenter.getMovieScheduleList(bannerslist.get(0).getId()+"",cinemasId+"");
    }

    @Override
    public void bannfaild(Throwable t) {

    }

    @Override
    public void MovieScheduleListsuccess(MovieScheduleListBean result) {
        if (result.getResult().size()>0) {
            schedulelistAdapter.setList(result.getResult());
            cinemaRecy.setAdapter(schedulelistAdapter);
        }else {
            Toast.makeText(this, "当前影院没有该电影的播放", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void MovieScheduleListfaild(Throwable t) {

    }

    @Override
    public void success(TuijianBean result) {

    }

    @Override
    public void faild(Throwable t) {

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

    @Override
    public void click(String time, String ScreeningHall, double price, String id) {
        Intent intent = new Intent(this, XuanzuoActivity.class);
        intent.putExtra("time", time);
        intent.putExtra("ScreeningHall", ScreeningHall);
        intent.putExtra("cinemasname", cinemaname);
        intent.putExtra("cinemasaddress", cinemaaddress);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
