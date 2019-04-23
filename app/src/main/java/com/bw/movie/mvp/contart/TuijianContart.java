package com.bw.movie.mvp.contart;



import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.TuijianBean;

import java.util.HashMap;

import io.reactivex.Observable;

public interface TuijianContart {

    interface ICirclepresenter{
        void getCirclePresenter(Observable<TuijianBean> Circlebean);
        void getguanzhuPresenter(Observable<BaseBean> guanzhubean);
        void getquxiaoPresenter(Observable<BaseBean> quxiaobean);
    }

    interface ICirclemodel{
        void getCircleModel(HashMap<String,String> map,String page, String count);
        void getguanzhuModel(HashMap<String,String> map, String cinemaId);
        void getquxiaoModel(HashMap<String,String> map,String cinemaId);
    }

    interface ICircleView extends IBaseView {
        void success(TuijianBean result);
        void faild(Throwable t);
        void guanzhusuccess(BaseBean result);
        void guanzhufaild(Throwable t);
        void quxiaosuccess(BaseBean result);
        void quxiaofaild(Throwable t);
    }

}
