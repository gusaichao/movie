package com.bw.movie.mvp.ui.fragment.yingyuanfragmeng;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.mvp.contart.TuijianContart;
import com.bw.movie.mvp.presneter.TuijianPresenter;
import com.bw.movie.mvp.ui.adapter.TuijianAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TuijianFragment extends Fragment implements TuijianContart.ICircleView,TuijianAdapter.onclicklisnter {

    @BindView(R.id.tuijian_recy)
    RecyclerView tuijianRecy;
    Unbinder unbinder;
    private TuijianAdapter tuijianAdapter;
    private TuijianPresenter tuijianPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tuijian, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tuijianRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        tuijianAdapter = new TuijianAdapter(getActivity());
        tuijianAdapter.setOnclicklisnter(this);
        tuijianPresenter = new TuijianPresenter(this);
        tuijianPresenter.getKeyorNum(1+"",10+"");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(TuijianBean result) {
        tuijianAdapter.setList(result.getResult());
        tuijianRecy.setAdapter(tuijianAdapter);
    }

    @Override
    public void faild(Throwable t) {

    }

    @Override
    public void guanzhusuccess(TuijianBean result) {
//        关注成功返回0000
        if (result.getStatus().equals("0000")){
            Toast.makeText(getActivity(), ""+result.getMessage(), Toast.LENGTH_SHORT).show();
//            tuijianPresenter.getKeyorNum(1+"",10+"");
//            不能重复关注返回1001
        }else if (result.getStatus().equals("1001")){
            Toast.makeText(getActivity(), ""+result.getMessage(), Toast.LENGTH_SHORT).show();
//            tuijianPresenter.getKeyorNum(1+"",10+"");
        }
    }

    @Override
    public void guanzhufaild(Throwable t) {

    }

    @Override
    public void quxiaosuccess(TuijianBean result) {
//        取消关注成功返回0000
        if (result.getStatus().equals("0000")){
            Toast.makeText(getActivity(), ""+result.getMessage(), Toast.LENGTH_SHORT).show();
//            tuijianPresenter.getKeyorNum(1+"",10+"");
//            不能重复取消返回1001
        }else if (result.getStatus().equals("1001")){
            Toast.makeText(getActivity(), ""+result.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void quxiaofaild(Throwable t) {

    }

    @Override
    public void click(String cid,int bb) {
        if (bb==1) {
            tuijianPresenter.getcidKeyorNum(cid);
        }else {
            tuijianPresenter.getquxiaocidKeyorNum(cid);
        }
    }
}
