package com.bw.movie.mvp.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BuyTicketRecordListBean;
import com.bw.movie.bean.MovieTicket;
import com.bw.movie.bean.PayBean;
import com.bw.movie.mvp.contart.MovieTicketContart;
import com.bw.movie.mvp.presneter.MovieTicketPresenter;
import com.bw.movie.mvp.ui.adapter.BuyTicketRecordListAdapter;
import com.jaeger.library.StatusBarUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuyTicketRecordListActivity extends BaseActivity<MovieTicketPresenter> implements MovieTicketContart.MovieTicketView {


    @BindView(R.id.btn1)
    RadioButton btn1;
    @BindView(R.id.btn2)
    RadioButton btn2;
    @BindView(R.id.navigation_btn)
    RadioGroup navigationBtn;
    @BindView(R.id.my_fragment_recy)
    RecyclerView myFragmentRecy;
    @BindView(R.id.back)
    ImageView back;
    private BuyTicketRecordListAdapter buyTicketRecordListAdapter;
    private int type = 1;

    @Override
    protected void initData() {

    }

    @Override
    protected MovieTicketPresenter providerPresenter() {
        return new MovieTicketPresenter(this);
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        myFragmentRecy.setLayoutManager(new LinearLayoutManager(this));
        buyTicketRecordListAdapter = new BuyTicketRecordListAdapter(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("page", "1");
        map.put("count", "10");
        map.put("status", type + "");
        presenter.getlisttext(map);
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                btn1.setTextColor(Color.WHITE);
                btn2.setTextColor(Color.BLACK);
                HashMap<String, String> map = new HashMap<>();
                map.put("page", "1");
                map.put("count", "10");
                map.put("status", type + "");
                presenter.getlisttext(map);
                break;
            case R.id.btn2:
                btn1.setTextColor(Color.BLACK);
                btn2.setTextColor(Color.WHITE);
                HashMap<String, String> map1 = new HashMap<>();
                map1.put("page", "1");
                map1.put("count", "10");
                map1.put("status", type + 1 + "");
                presenter.getlisttext(map1);
                break;
        }
    }


    @Override
    protected int providerLayoutId() {
        StatusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_buy_ticket_record_list;
    }

    @Override
    public void success(MovieTicket result) {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void paysuccess(PayBean result) {

    }

    @Override
    public void payfailure(String msg) {

    }

    @Override
    public void BuyTicketRecordListsuccess(BuyTicketRecordListBean result) {
        buyTicketRecordListAdapter.setList(result.getResult());
        myFragmentRecy.setAdapter(buyTicketRecordListAdapter);
    }

    @Override
    public void BuyTicketRecordListfailure(String msg) {

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
