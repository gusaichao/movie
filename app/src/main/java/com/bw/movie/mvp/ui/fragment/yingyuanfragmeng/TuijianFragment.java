package com.bw.movie.mvp.ui.fragment.yingyuanfragmeng;


import android.content.Intent;
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
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.mvp.contart.TuijianContart;
import com.bw.movie.mvp.presneter.TuijianPresenter;
import com.bw.movie.mvp.ui.activity.CinemainfoActivity;
import com.bw.movie.mvp.ui.adapter.TuijianAdapter;
import com.bw.movie.utils.SPFUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TuijianFragment extends Fragment implements TuijianContart.ICircleView,TuijianAdapter.onclicklisnter {

    @BindView(R.id.tuijian_recy)
    RecyclerView tuijianRecy;
    Unbinder unbinder;
    private TuijianAdapter tuijianAdapter;
    private TuijianPresenter tuijianPresenter;
    private String userid;
    private String sessionid;
    private HashMap<String, String> map;

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
        userid = (String) SPFUtil.getInstance().getData("userid","");
        sessionid = (String) SPFUtil.getInstance().getData("sessionid","");
        map = new HashMap<>();
        map.put("userId",userid);
        map.put("sessionId",sessionid);
        tuijianPresenter = new TuijianPresenter(this);
        tuijianPresenter.getKeyorNum(map,1+"",10+"");
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
    public void guanzhusuccess(BaseBean result) {
//      关注成功返回0000
        if (result.getStatus().equals("0000")){
            Toast.makeText(getActivity(), ""+result.getMessage(), Toast.LENGTH_SHORT).show();
//      不能重复关注返回1001
        }else if (result.getStatus().equals("1001")){
            Toast.makeText(getActivity(), ""+result.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void guanzhufaild(Throwable t) {

    }

    @Override
    public void quxiaosuccess(BaseBean result) {
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
    public void CinemaInfosuccess(CinemaInfoBean result) {

    }

    @Override
    public void CinemaInfofaild(Throwable t) {

    }

    @Override
    public void bannsuccess(HotmovieBean result) {

    }

    @Override
    public void bannfaild(Throwable t) {

    }

    @Override
    public void MovieScheduleListsuccess(MovieScheduleListBean result) {

    }

    @Override
    public void MovieScheduleListfaild(Throwable t) {

    }

    @Override
    public void click(String cid,int bb) {
        if (bb==1) {
            //请求关注接口
            tuijianPresenter.getcidKeyorNum(map,cid);
        }else {
            //请求取消关注接口
            tuijianPresenter.getquxiaocidKeyorNum(map,cid);
        }
    }

    @Override
    public void itemclick(String itemid,String imageurl,String cinemaname,String cinemaaddress) {
        Intent intent = new Intent(getActivity(),CinemainfoActivity.class);
        intent.putExtra("cinemaId",itemid);
        intent.putExtra("imageurl",imageurl);
        intent.putExtra("cinemaname",cinemaname);
        intent.putExtra("cinemaaddress",cinemaaddress);
        getActivity().startActivity(intent);
    }
}
