package com.bw.movie.mvp.model;



import com.bw.movie.bean.FujinBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.mvp.contart.FujinContart;
import com.bw.movie.mvp.contart.TuijianContart;
import com.bw.movie.mvp.presneter.FujinPresenter;
import com.bw.movie.mvp.presneter.TuijianPresenter;
import com.bw.movie.utils.RetrofitUtils;

import io.reactivex.Observable;

public class FujinModel implements FujinContart.IFujinmodel {

    private FujinPresenter circlePresenter;

    public FujinModel(FujinPresenter circlePresenter) {
        this.circlePresenter = circlePresenter;
    }

    @Override
    public void getfujinModel(String page, String count,String longitude,String latitude) {
        Observable<FujinBean> CircleData = RetrofitUtils.getInstance().getservice().fujinData(page, count, longitude, latitude);
        circlePresenter.getfujinPresenter(CircleData);
    }


}
