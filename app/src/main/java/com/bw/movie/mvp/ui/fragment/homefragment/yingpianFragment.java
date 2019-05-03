package com.bw.movie.mvp.ui.fragment.homefragment;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.MapView;
import com.bw.movie.R;
import com.bw.movie.base.BaseLazyLoadFragment;
import com.bw.movie.bean.AllBean;
import com.bw.movie.bean.ComingBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.NowshowBean;
import com.bw.movie.mvp.contart.HotmovieContart;
import com.bw.movie.mvp.presneter.HotmoviePresenter;
import com.bw.movie.mvp.ui.adapter.CinemaFlowAdapter;
import com.bw.movie.utils.SPFUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class yingpianFragment extends BaseLazyLoadFragment implements HotmovieContart.IHotmovieView,
        View.OnClickListener {

    Unbinder unbinder;
    private ImageView mDianyingbg;
    private RecyclerView mRecy;
    private CinemaFlowAdapter cinemaFlowAdapter;
    private AllBean allBean;
    private ImageView search_image;
    private EditText search_edname;
    private TextView search_textName;
    private RelativeLayout search_linear;
    private AutoTransition transition;

    private MapView mMapView = null;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();
    private TextView home_text;
    private ImageView home_dingwei;
    private double latitude;
    private double longitude;
    private String locationDescribe;

    @Override
    protected boolean setIsRealTimeRefresh() {
        return false;
    }

    @Override
    protected void initData() {
        allBean = new AllBean();
        HotmoviePresenter hotmoviePresenter = new HotmoviePresenter(this);
        hotmoviePresenter.getKeyorNum(1 + "", 10 + "");
        hotmoviePresenter.getKeyorNum2(1 + "", 10 + "");
        hotmoviePresenter.getKeyorNum3(1 + "", 10 + "");
        search_image.setOnClickListener(this);
        search_textName.setOnClickListener(this);
        mLocationClient = new LocationClient(getActivity().getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
        //可选，是否需要位置描述信息，默认为不需要，即参数为false
        //如果开发者需要获得当前点的位置信息，此处必须为true
        option.setIsNeedLocationDescribe(true);
        //可选，设置是否需要地址信息，默认不需要
        option.setIsNeedAddress(true);
        //可选，默认false,设置是否使用gps
        option.setOpenGps(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setLocationNotify(true);
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        mDianyingbg = view.findViewById(R.id.dianyingbg);
        mRecy = view.findViewById(R.id.recy);
        search_textName = view.findViewById(R.id.search_textName);
        search_linear = view.findViewById(R.id.search_linear);
        search_image = view.findViewById(R.id.search_image);
        search_edname = view.findViewById(R.id.search_edname);
        home_text = view.findViewById(R.id.home_text);
        home_dingwei = view.findViewById(R.id.home_dingwei);
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        cinemaFlowAdapter = new CinemaFlowAdapter(getActivity());
        home_dingwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_text.setText(locationDescribe);
                SPFUtil.getInstance().saveData("latitude",latitude+"");
                SPFUtil.getInstance().saveData("longitude",longitude+"");
            }
        });


    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_yingpian;
    }


    public class MyLocationListener implements BDLocationListener {

        private String addr;

        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取地址相关的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
            //获取位置描述信息
            locationDescribe = location.getLocationDescribe();
            //纬度
            latitude = location.getLatitude();
            //经度
            longitude = location.getLongitude();
            //获取详细地址信息
            addr = location.getAddrStr();
            if (addr ==null){
                return;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_image:
                //点击搜索 伸展
                initExpand();
                break;
            case R.id.search_textName:
                //点击text收缩
                initReduce();
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(HotmovieBean result) {
        cinemaFlowAdapter.setAllBean(allBean);
        cinemaFlowAdapter.setList(result.getResult());
        mRecy.setAdapter(cinemaFlowAdapter);
    }

    @Override
    public void faild(Throwable t) {

    }

    @Override
    public void success2(NowshowBean result) {
        cinemaFlowAdapter.setList2(result.getResult());
        mRecy.setAdapter(cinemaFlowAdapter);
    }

    @Override
    public void faild2(Throwable t) {

    }

    @Override
    public void success3(ComingBean result) {
        cinemaFlowAdapter.setList3(result.getResult());
        mRecy.setAdapter(cinemaFlowAdapter);
    }

    @Override
    public void faild3(Throwable t) {

    }


    /*设置伸展状态时的布局*/
    public void initExpand() {
        search_edname.setHint("CGV影城");
        search_edname.requestFocus();
        search_edname.setHintTextColor(Color.WHITE);
        search_textName.setText("搜索");
        search_textName.setVisibility(View.VISIBLE);
        search_edname.setVisibility(View.VISIBLE);
        ConstraintLayout.LayoutParams LayoutParams = (ConstraintLayout.LayoutParams) search_linear.getLayoutParams();
        LayoutParams.width = dip2px(170);
        LayoutParams.setMargins(dip2px(0), dip2px(30), dip2px(0), dip2px(0));
        search_linear.setLayoutParams(LayoutParams);
        search_edname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                search_edname.setFocusable(true);
                search_edname.setFocusableInTouchMode(true);
                return false;
            }
        });
        //开始动画
        beginDelayedTransition(search_linear);

    }

    /*设置收缩状态时的布局*/
    private void initReduce() {
        search_edname.setCursorVisible(false);
        search_edname.setVisibility(View.GONE);
        search_textName.setVisibility(View.GONE);
        ConstraintLayout.LayoutParams LayoutParams = (ConstraintLayout.LayoutParams) search_linear.getLayoutParams();
        LayoutParams.width = dip2px(50);
        LayoutParams.setMargins(dip2px(0), dip2px(30), dip2px(0), dip2px(0));
        search_linear.setLayoutParams(LayoutParams);

        //隐藏键盘
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        search_edname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_edname.setCursorVisible(true);
            }
        });
        //开始动画
        beginDelayedTransition(search_linear);
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void beginDelayedTransition(ViewGroup view) {
        transition = new AutoTransition();
        transition.setDuration(500);
        TransitionManager.beginDelayedTransition(view, transition);
    }

    private int dip2px(float dpVale) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpVale * scale + 0.5f);
    }



}
