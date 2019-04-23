package com.bw.movie.mvp.contart;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.XiangBean;

import io.reactivex.Observable;

public interface MovieScheduleListContart {

    interface IMovieScheduleListpresenter{
        void getXiangPresenter(Observable<XiangBean> Xiangbean);
        void getMovieScheduleListPresenter(Observable<MovieScheduleListBean> movieScheduleListBean);
    }

    interface IMovieScheduleListmodel{
        void getXiangModel(String commodityId);
        void getMovieScheduleListModel(String movieId,String cinemasId);
    }

    interface IMovieScheduleListView extends IBaseView {
        void success(XiangBean resultBean);
        void faild(Throwable t);
        void MovieScheduleListsuccess(MovieScheduleListBean result);
        void MovieScheduleListfaild(Throwable t);
    }

}
