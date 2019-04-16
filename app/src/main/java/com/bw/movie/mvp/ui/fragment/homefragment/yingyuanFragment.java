package com.bw.movie.mvp.ui.fragment.homefragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.ui.fragment.yingyuanfragmeng.FujinFragment;
import com.bw.movie.mvp.ui.fragment.yingyuanfragmeng.TuijianFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class yingyuanFragment extends Fragment {

    @BindView(R.id.main_fragment)
    FrameLayout mainFragment;
    @BindView(R.id.btn1)
    RadioButton btn1;
    @BindView(R.id.btn2)
    RadioButton btn2;
    @BindView(R.id.navigation_btn)
    RadioGroup navigationBtn;
    Unbinder unbinder;
    private Fragment[] fragments;
    private int mIndex;
    private FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_yingyuan, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TuijianFragment tuijianFragment = new TuijianFragment();
        FujinFragment fujinFragment = new FujinFragment();
        fragments = new Fragment[]{tuijianFragment,fujinFragment};
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_fragment,tuijianFragment).commit();
        //默认设置为第0个
        setIndexSelected(0);
    }

    private void setIndexSelected(int i) {
        if (mIndex==i){
            return;
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
        //隐藏
        ft.hide(fragments[mIndex]);
        //判断是否添加
        if (!fragments[i].isAdded()){
            ft.add(R.id.main_fragment,fragments[i]).show(fragments[i]);
        }else {
            ft.show(fragments[i]);
        }
        ft.commit();
        //再次赋值
        mIndex=i;
    }
    @OnClick({R.id.btn1,R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                setIndexSelected(0);
                btn1.setTextColor(Color.WHITE);
                btn2.setTextColor(Color.BLACK);
                break;
            case R.id.btn2:
                setIndexSelected(1);
                btn1.setTextColor(Color.BLACK);
                btn2.setTextColor(Color.WHITE);
                break;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
