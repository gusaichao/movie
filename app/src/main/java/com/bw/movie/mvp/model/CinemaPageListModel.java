package com.bw.movie.mvp.model;

import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemaPageListBean;
import com.bw.movie.bean.MoviePageListBean;
import com.bw.movie.mvp.contart.CinemaPageListContart;
import com.bw.movie.mvp.presneter.CinemaPageListPresenter;
import com.bw.movie.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;

public class CinemaPageListModel implements CinemaPageListContart.CinemaPageListmodel {


    public CinemaPageListModel(CinemaPageListPresenter cinemaPageListPresenter) {
        this.cinemaPageListPresenter = cinemaPageListPresenter;
    }

    private CinemaPageListPresenter cinemaPageListPresenter;


    @Override
    public void CinemaPageListlist(String page,String count) {
        Observable<CinemaPageListBean> CinemaPageListData = RetrofitUtils.getInstance().getservice().CinemaPageListData(page, count);
        cinemaPageListPresenter.CinemaPageListlist(CinemaPageListData);
    }

    @Override
    public void MoviePageListlist(String page, String count) {
        Observable<MoviePageListBean> MoviePageListData = RetrofitUtils.getInstance().getservice().MoviePageListData(page, count);
        cinemaPageListPresenter.MoviePageListlist(MoviePageListData);
    }
}
