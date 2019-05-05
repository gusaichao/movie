package com.bw.movie.mvp.contart;



import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.MovieListByCinemaIdBean;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.TuijianBean;

import java.util.HashMap;

import io.reactivex.Observable;

public interface TuijianContart {

    interface ICirclepresenter{
        void getCirclePresenter(Observable<TuijianBean> Circlebean);
        void getguanzhuPresenter(Observable<BaseBean> guanzhubean);
        void getquxiaoPresenter(Observable<BaseBean> quxiaobean);
        void getCinemaInfoPresenter(Observable<CinemaInfoBean> cinemaInfoBean);
        void getHotmoviePresenter(Observable<MovieListByCinemaIdBean> movieListByCinemaIdBean);
        void getMovieScheduleListPresenter(Observable<MovieScheduleListBean> movieScheduleListBean);
    }

    interface ICirclemodel{
        void getCircleModel(HashMap<String,String> map,String page, String count);
        void getguanzhuModel(HashMap<String,String> map, String cinemaId);
        void getquxiaoModel(HashMap<String,String> map,String cinemaId);
        void geCinemaInfoModel(String cinemaId);
        void getHotmovieModel(String cinemaId);
        void getMovieScheduleListModel(String movieId,String cinemasId);
    }

    interface ICircleView extends IBaseView {
        void success(TuijianBean result);
        void faild(Throwable t);
        void guanzhusuccess(BaseBean result);
        void guanzhufaild(Throwable t);
        void quxiaosuccess(BaseBean result);
        void quxiaofaild(Throwable t);
        void CinemaInfosuccess(CinemaInfoBean result);
        void CinemaInfofaild(Throwable t);
        void bannsuccess(MovieListByCinemaIdBean result);
        void bannfaild(Throwable t);
        void MovieScheduleListsuccess(MovieScheduleListBean result);
        void MovieScheduleListfaild(Throwable t);
    }

}
