package com.bw.movie.mvp.model;



import com.bw.movie.bean.TuijianBean;
import com.bw.movie.mvp.contart.TuijianContart;
import com.bw.movie.mvp.presneter.TuijianPresenter;
import com.bw.movie.utils.RetrofitUtils;

import io.reactivex.Observable;

public class TuijianModel implements TuijianContart.ICirclemodel {

    private TuijianPresenter circlePresenter;

    public TuijianModel(TuijianPresenter circlePresenter) {
        this.circlePresenter = circlePresenter;
    }

    @Override
    public void getCircleModel(String page, String count) {
        Observable<TuijianBean> CircleData = RetrofitUtils.getInstance().getservice().circleData(page, count);
        circlePresenter.getCirclePresenter(CircleData);
    }

    @Override
    public void getguanzhuModel(String cinemaId) {
        Observable<TuijianBean> CircleData = RetrofitUtils.getInstance().getservice().guanzhuData(cinemaId);
        circlePresenter.getguanzhuPresenter(CircleData);
    }

    @Override
    public void getquxiaoModel(String cinemaId) {
        Observable<TuijianBean> CircleData = RetrofitUtils.getInstance().getservice().cancelFollowData(cinemaId);
        circlePresenter.getquxiaoPresenter(CircleData);
    }
}
