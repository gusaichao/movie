package com.bw.movie.mvp.model;

import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.MovieScheduleListContart;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.presneter.MovieScheduleListPresenter;
import com.bw.movie.mvp.presneter.XiangPresenter;
import com.bw.movie.utils.RetrofitUtils;

import io.reactivex.Observable;

public class MovieScheduleListModel implements MovieScheduleListContart.IMovieScheduleListmodel {

    private MovieScheduleListPresenter xiangPresenter;

    public MovieScheduleListModel(MovieScheduleListPresenter xiangPresenter) {
        this.xiangPresenter = xiangPresenter;
    }

    @Override
    public void getXiangModel(String commodityId) {
        Observable<XiangBean> xiangData = RetrofitUtils.getInstance().getservice().xiangData(commodityId);
        xiangPresenter.getXiangPresenter(xiangData);
    }
    @Override
    public void getMovieScheduleListModel(String movieId,String cinemasId) {
        Observable<MovieScheduleListBean> cinemasListByMovieIdData = RetrofitUtils.getInstance().getservice().MovieScheduleListData(movieId,cinemasId);
        xiangPresenter.getMovieScheduleListPresenter(cinemasListByMovieIdData);
    }

}
