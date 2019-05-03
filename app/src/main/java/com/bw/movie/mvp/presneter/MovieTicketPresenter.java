package com.bw.movie.mvp.presneter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.BuyTicketRecordListBean;
import com.bw.movie.bean.MovieTicket;
import com.bw.movie.bean.PayBean;
import com.bw.movie.mvp.contart.MovieTicketContart;
import com.bw.movie.mvp.model.MovieTicketModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MovieTicketPresenter extends BasePresenter<MovieTicketContart.MovieTicketView> implements MovieTicketContart.MovieTicketpresenter {

    private MovieTicketModel addpingModel;
    public MovieTicketPresenter(MovieTicketContart.MovieTicketView view) {
        super(view);
    }

    public void gettext(HashMap<String,String> map){
        addpingModel.MovieTicketlist(map);
    }

    public void getpaytext(HashMap<String,String>map){
        addpingModel.paylist(map);
    }

    public void getlisttext(HashMap<String,String>map){
        addpingModel.BuyTicketRecordListlist(map);
    }

    @Override
    protected void initModel() {
        addpingModel = new MovieTicketModel(this);
    }

    @Override
    public void MovieTicketlist(Observable<MovieTicket> movieTicket) {
        movieTicket.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieTicket>() {
                    @Override
                    public void accept(MovieTicket movieTicket) throws Exception {
                        view.success(movieTicket);
                    }
                });
    }

    @Override
    public void Paylist(Observable<PayBean> payBean) {
        payBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PayBean>() {
                    @Override
                    public void accept(PayBean payBean) throws Exception {
                        view.paysuccess(payBean);
                    }
                });
    }

    @Override
    public void BuyTicketRecordListlist(Observable<BuyTicketRecordListBean> buyTicketRecordListBean) {
        buyTicketRecordListBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BuyTicketRecordListBean>() {
                    @Override
                    public void accept(BuyTicketRecordListBean buyTicketRecordListBean) throws Exception {
                        view.BuyTicketRecordListsuccess(buyTicketRecordListBean);
                    }
                });
    }
}
