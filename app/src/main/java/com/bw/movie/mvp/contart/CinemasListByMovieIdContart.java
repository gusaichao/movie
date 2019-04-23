package com.bw.movie.mvp.contart;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.FujinBean;

import io.reactivex.Observable;

public interface CinemasListByMovieIdContart {


    interface ICinemasListByMovieIdpresenter{
        void getCinemasListByMovieIdPresenter(Observable<CinemasListByMovieIdBean> cinemasListByMovieIdbean);
    }

    interface ICinemasListByMovieIdmodel{
        void getCinemasListByMovieIdModel(String movieId);

    }

    interface ICinemasListByMovieIdView extends IBaseView {
        void success(CinemasListByMovieIdBean result);
        void faild(Throwable t);
    }

}
