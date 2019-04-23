package com.bw.movie.mvp.contart;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.XiangBean;

import java.util.HashMap;

import io.reactivex.Observable;

public interface XiangContart {

    interface IXiangtoppresenter{
        void getXiangPresenter(Observable<XiangBean> Xiangbean);
        void getpingPresenter(Observable<PingBean> piangbean);
        void getCinemasListByMovieIdPresenter(Observable<CinemasListByMovieIdBean> cinemasListByMovieIdbean);
        void addpinglist(Observable<BaseBean> addping);
        void getguanzhuPresenter(Observable<BaseBean> guanzhubean);
        void getquxiaoPresenter(Observable<BaseBean> quxiaobean);

    }

    interface IXiangtopmodel{
        void getXiangModel(String commodityId);
        void getpingModel(String page,String count,String commodityId);
        void getCinemasListByMovieIdModel(String movieId);
        void addpinglist(HashMap<String, String> params);
        void getguanzhuModel( String cinemaId);
        void getquxiaoModel(String cinemaId);
    }

    interface IXiangtopView extends IBaseView {
        void success(XiangBean resultBean);
        void faild(Throwable t);
        void pingsuccess(PingBean resultBean);
        void pingfaild(Throwable t);
        void CinemasListByMovieIdsuccess(CinemasListByMovieIdBean result);
        void CinemasListByMovieIdfaild(Throwable t);
        void addpingsuccess(String result);
        void addpingfailure(String msg);
        void guanzhusuccess(BaseBean result);
        void guanzhufaild(Throwable t);
        void quxiaosuccess(BaseBean result);
        void quxiaofaild(Throwable t);
    }

}
