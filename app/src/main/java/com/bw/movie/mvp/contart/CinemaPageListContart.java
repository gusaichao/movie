package com.bw.movie.mvp.contart;



import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemaPageListBean;
import com.bw.movie.bean.MoviePageListBean;

import java.util.HashMap;

import io.reactivex.Observable;

public interface CinemaPageListContart {

    interface CinemaPageListprasenter{
        void CinemaPageListlist(Observable<CinemaPageListBean> CinemaPageList);
        void MoviePageListlist(Observable<MoviePageListBean> MoviePageList);
    }


    interface CinemaPageListmodel{
        void CinemaPageListlist(String page,String count);
        void MoviePageListlist(String page,String count);
    }

    interface CinemaPageListView extends IBaseView {
        void success(CinemaPageListBean result);
        void failure(String msg);
        void MoviePageListsuccess(MoviePageListBean result);
        void MoviePageListfailure(String msg);
    }

}
