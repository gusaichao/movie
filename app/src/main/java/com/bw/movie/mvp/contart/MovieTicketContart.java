package com.bw.movie.mvp.contart;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BuyTicketRecordListBean;
import com.bw.movie.bean.MovieTicket;
import com.bw.movie.bean.PayBean;

import java.util.HashMap;

import io.reactivex.Observable;

public interface MovieTicketContart {

    interface MovieTicketpresenter extends IBaseView {
        void MovieTicketlist(Observable<MovieTicket> movieTicket);
        void Paylist(Observable<PayBean> payBean);
        void BuyTicketRecordListlist(Observable<BuyTicketRecordListBean> buyTicketRecordListBean);
    }

    interface MovieTicketModel{
        void MovieTicketlist(HashMap<String,String> map);
        void paylist(HashMap<String,String> map);
        void BuyTicketRecordListlist(HashMap<String,String> map);
    }
    interface MovieTicketView extends IBaseView{
        void success(MovieTicket result);
        void failure(String msg);
        void paysuccess(PayBean result);
        void payfailure(String msg);
        void BuyTicketRecordListsuccess(BuyTicketRecordListBean result);
        void BuyTicketRecordListfailure(String msg);
    }

}
