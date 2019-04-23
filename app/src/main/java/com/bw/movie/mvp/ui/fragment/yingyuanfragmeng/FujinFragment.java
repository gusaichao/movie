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

import com.bw.movie.R;
import com.bw.movie.bean.FujinBean;
import com.bw.movie.mvp.contart.FujinContart;
import com.bw.movie.mvp.presneter.FujinPresenter;
import com.bw.movie.mvp.ui.adapter.FujinAdapter;
import com.bw.movie.utils.SPFUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FujinFragment extends Fragment implements FujinContart.IfujinView,FujinAdapter.onclicklisnter {

    @BindView(R.id.fujin_recy)
    RecyclerView fujinRecy;
    Unbinder unbinder;
    private FujinAdapter tuijianAdapter;
    private FujinPresenter tuijianPresenter;
    private String latitude;
    private String longitude;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fujin, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        latitude = (String) SPFUtil.getInstance().getData("latitude", "");
        longitude = (String) SPFUtil.getInstance().getData("longitude", "");
        fujinRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        tuijianAdapter = new FujinAdapter(getActivity());
        tuijianAdapter.setOnclicklisnter(this);
        tuijianPresenter = new FujinPresenter(this);
        tuijianPresenter.getKeyorNum(1+"",10+"",longitude,latitude);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(FujinBean result) {
        tuijianAdapter.setList(result.getResult());
        fujinRecy.setAdapter(tuijianAdapter);
    }

    @Override
    public void faild(Throwable t) {

    }

    @Override
    public void click(String cid, int bb) {

    }
}
