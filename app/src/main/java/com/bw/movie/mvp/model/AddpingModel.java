package com.bw.movie.mvp.model;

import com.bw.movie.bean.BaseBean;
import com.bw.movie.mvp.contart.AddpingContart;
import com.bw.movie.mvp.presneter.AddpingPresenter;
import com.bw.movie.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;

public class AddpingModel implements AddpingContart.Addpingmodel {


    public AddpingModel(AddpingPresenter addpingPresenter) {
        this.addpingPresenter = addpingPresenter;
    }

    private AddpingPresenter addpingPresenter;


    @Override
    public void addpinglist(HashMap<String, String> params) {
        Observable<BaseBean> addpingData = RetrofitUtils.getInstance().getservice().addpingData(params);
        addpingPresenter.addpinglist(addpingData);
    }
}
