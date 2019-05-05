package com.bw.movie.mvp.model;



import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.MovieListByCinemaIdBean;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.mvp.contart.TuijianContart;
import com.bw.movie.mvp.presneter.TuijianPresenter;
import com.bw.movie.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;

public class TuijianModel implements TuijianContart.ICirclemodel {

    private TuijianPresenter circlePresenter;

    public TuijianModel(TuijianPresenter circlePresenter) {
        this.circlePresenter = circlePresenter;
    }

    @Override
    public void getCircleModel(HashMap<String, String> map,String page, String count) {
        Observable<TuijianBean> CircleData = RetrofitUtils.getInstance().getservice().circleData(map,page, count);
        circlePresenter.getCirclePresenter(CircleData);
    }

    @Override
    public void getguanzhuModel(HashMap<String,String> map, String cinemaId) {
        Observable<BaseBean> CircleData = RetrofitUtils.getInstance().getservice().guanzhuData(map,cinemaId);
        circlePresenter.getguanzhuPresenter(CircleData);
    }

    @Override
    public void getquxiaoModel(HashMap<String,String> map,String cinemaId) {
        Observable<BaseBean> CircleData = RetrofitUtils.getInstance().getservice().cancelFollowData(map,cinemaId);
        circlePresenter.getquxiaoPresenter(CircleData);
    }

    @Override
    public void geCinemaInfoModel(String cinemaId) {
        Observable<CinemaInfoBean> cinemainfoData = RetrofitUtils.getInstance().getservice().cinemainfoData(cinemaId);
        circlePresenter.getCinemaInfoPresenter(cinemainfoData);
    }
    @Override
    public void getHotmovieModel(String cinemaId) {
        Observable<MovieListByCinemaIdBean> HotmovieData = RetrofitUtils.getInstance().getservice().MovieListByCinemaIdData(cinemaId);
        circlePresenter.getHotmoviePresenter(HotmovieData);
    }
    @Override
    public void getMovieScheduleListModel(String movieId,String cinemasId) {
        Observable<MovieScheduleListBean> cinemasListByMovieIdData = RetrofitUtils.getInstance().getservice().MovieScheduleListData(movieId,cinemasId);
        circlePresenter.getMovieScheduleListPresenter(cinemasListByMovieIdData);
    }
}
