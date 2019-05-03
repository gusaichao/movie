package com.bw.movie.mvp.model;

import com.bw.movie.bean.BuyTicketRecordListBean;
import com.bw.movie.bean.MovieTicket;
import com.bw.movie.bean.PayBean;
import com.bw.movie.mvp.contart.MovieTicketContart;
import com.bw.movie.mvp.presneter.MovieTicketPresenter;
import com.bw.movie.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;

public class MovieTicketModel implements MovieTicketContart.MovieTicketModel {


    public MovieTicketModel(MovieTicketPresenter addpingPresenter) {
        this.addpingPresenter = addpingPresenter;
    }
    private MovieTicketPresenter addpingPresenter;

    @Override
    public void MovieTicketlist(HashMap<String, String> map) {
        Observable<MovieTicket> movieTicketObservable = RetrofitUtils.getInstance().getservice().MovieTicketData(map);
        addpingPresenter.MovieTicketlist(movieTicketObservable);
    }

    @Override
    public void paylist(HashMap<String, String> map) {
        Observable<PayBean> payBeanObservable = RetrofitUtils.getInstance().getservice().payData(map);
        addpingPresenter.Paylist(payBeanObservable);
    }

    @Override
    public void BuyTicketRecordListlist(HashMap<String, String> map) {
        Observable<BuyTicketRecordListBean> buyTicketRecordListBeanObservable = RetrofitUtils.getInstance().getservice().BuyTicketRecordListData(map);
        addpingPresenter.BuyTicketRecordListlist(buyTicketRecordListBeanObservable);
    }
}
