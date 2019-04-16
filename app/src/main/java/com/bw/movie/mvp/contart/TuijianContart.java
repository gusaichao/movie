package com.bw.movie.mvp.contart;



import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.TuijianBean;

import io.reactivex.Observable;

public interface TuijianContart {

    interface ICirclepresenter{
        void getCirclePresenter(Observable<TuijianBean> Circlebean);
        void getguanzhuPresenter(Observable<TuijianBean> guanzhubean);
        void getquxiaoPresenter(Observable<TuijianBean> quxiaobean);
    }

    interface ICirclemodel{
        void getCircleModel(String page, String count);
        void getguanzhuModel(String cinemaId);
        void getquxiaoModel(String cinemaId);
    }

    interface ICircleView extends IBaseView {
        void success(TuijianBean result);
        void faild(Throwable t);
        void guanzhusuccess(TuijianBean result);
        void guanzhufaild(Throwable t);
        void quxiaosuccess(TuijianBean result);
        void quxiaofaild(Throwable t);
    }

}
