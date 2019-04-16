package com.bw.movie.mvp.model;

import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.presneter.XiangPresenter;
import com.bw.movie.utils.RetrofitUtils;

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
}
