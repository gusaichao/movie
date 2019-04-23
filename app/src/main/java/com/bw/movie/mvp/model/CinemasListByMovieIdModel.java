package com.bw.movie.mvp.model;



import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.FujinBean;
import com.bw.movie.mvp.contart.CinemasListByMovieIdContart;
import com.bw.movie.mvp.contart.FujinContart;
import com.bw.movie.mvp.presneter.CinemasListByMovieIdPresenter;
import com.bw.movie.mvp.presneter.FujinPresenter;
import com.bw.movie.utils.RetrofitUtils;

import io.reactivex.Observable;

public class CinemasListByMovieIdModel implements CinemasListByMovieIdContart.ICinemasListByMovieIdmodel {

    private CinemasListByMovieIdPresenter cinemasListByMovieIdPresenter;
    public CinemasListByMovieIdModel(CinemasListByMovieIdPresenter cinemasListByMovieIdPresenter) {
        this.cinemasListByMovieIdPresenter = cinemasListByMovieIdPresenter;
    }

    @Override
    public void getCinemasListByMovieIdModel(String movieId) {
        Observable<CinemasListByMovieIdBean> cinemasListByMovieIdData = RetrofitUtils.getInstance().getservice().CinemasListByMovieIdData(movieId);
        cinemasListByMovieIdPresenter.getCinemasListByMovieIdPresenter(cinemasListByMovieIdData);
    }
}
