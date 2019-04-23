package com.bw.movie.mvp.model;

import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.presneter.XiangPresenter;
import com.bw.movie.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;

public class XiangModel implements XiangContart.IXiangtopmodel {

    private XiangPresenter xiangPresenter;

    public XiangModel(XiangPresenter xiangPresenter) {
        this.xiangPresenter = xiangPresenter;
    }

    @Override
    public void getXiangModel(String commodityId) {
        Observable<XiangBean> xiangData = RetrofitUtils.getInstance().getservice().xiangData(commodityId);
        xiangPresenter.getXiangPresenter(xiangData);
    }

    @Override
    public void getpingModel(String page, String count, String commodityId) {
        Observable<PingBean> pingData = RetrofitUtils.getInstance().getservice().pingData(page, count, commodityId);
        xiangPresenter.getpingPresenter(pingData);
    }

    @Override
    public void getCinemasListByMovieIdModel(String movieId) {
        Observable<CinemasListByMovieIdBean> cinemasListByMovieIdData = RetrofitUtils.getInstance().getservice().CinemasListByMovieIdData(movieId);
        xiangPresenter.getCinemasListByMovieIdPresenter(cinemasListByMovieIdData);
    }

    @Override
    public void addpinglist(HashMap<String, String> params) {
        Observable<BaseBean> addpingData = RetrofitUtils.getInstance().getservice().addpingData(params);
        xiangPresenter.addpinglist(addpingData);
    }
    @Override
    public void getguanzhuModel(String cinemaId) {
        Observable<BaseBean> CircleData = RetrofitUtils.getInstance().getservice().followMovieData(cinemaId);
        xiangPresenter.getguanzhuPresenter(CircleData);
    }

    @Override
    public void getquxiaoModel(String cinemaId) {
        Observable<BaseBean> CircleData = RetrofitUtils.getInstance().getservice().cancelFollowMovieData(cinemaId);
        xiangPresenter.getquxiaoPresenter(CircleData);
    }
}
