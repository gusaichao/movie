package com.bw.movie.mvp.contart;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.FujinBean;

import io.reactivex.Observable;

public interface FujinContart {


    interface IFujinpresenter{
        void getfujinPresenter(Observable<FujinBean> Circlebean);
    }

    interface IFujinmodel{
        void getfujinModel(String page, String count,String longitude,String latitude);

    }

    interface IfujinView extends IBaseView {
        void success(FujinBean result);
        void faild(Throwable t);
    }

}
