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
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    @BindView(R.id.yy_dingwei)
    ImageView yyDingwei;
    @BindView(R.id.yy_text)
    TextView yyText;
    @BindView(R.id.yy_search_image)
    ImageView yySearchImage;
    @BindView(R.id.yy_search_edname)
    EditText yySearchEdname;
    @BindView(R.id.yy_search_textName)
    TextView yySearchTextName;
    @BindView(R.id.yy_search_linear)
    RelativeLayout yySearchLinear;
    private Fragment[] fragments;
    private int mIndex;
    private FragmentTransaction ft;
    private AutoTransition transition;

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
        fragments = new Fragment[]{tuijianFragment, fujinFragment};
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_fragment, tuijianFragment).commit();
        //默认设置为第0个
        setIndexSelected(0);
    }

    private void setIndexSelected(int i) {
        if (mIndex == i) {
            return;
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        ft = fragmentManager.beginTransaction();
        //隐藏
        ft.hide(fragments[mIndex]);
        //判断是否添加
        if (!fragments[i].isAdded()) {
            ft.add(R.id.main_fragment, fragments[i]).show(fragments[i]);
        } else {
            ft.show(fragments[i]);
        }
        ft.commit();
        //再次赋值
        mIndex = i;
    }

    @OnClick({R.id.btn1, R.id.btn2})
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


    /*设置伸展状态时的布局*/
    public void initExpand() {
        yySearchEdname.setHint("CGV影城");
        yySearchEdname.requestFocus();
        yySearchEdname.setHintTextColor(Color.WHITE);
        yySearchTextName.setText("搜索");
        yySearchTextName.setVisibility(View.VISIBLE);
        yySearchEdname.setVisibility(View.VISIBLE);
        ConstraintLayout.LayoutParams LayoutParams = (ConstraintLayout.LayoutParams) yySearchLinear.getLayoutParams();
        LayoutParams.width = dip2px(170);
        LayoutParams.setMargins(dip2px(0), dip2px(30), dip2px(0), dip2px(0));
        yySearchLinear.setLayoutParams(LayoutParams);
        yySearchEdname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                yySearchEdname.setFocusable(true);
                yySearchEdname.setFocusableInTouchMode(true);
                return false;
            }
        });
        //开始动画
        beginDelayedTransition(yySearchLinear);

    }

    /*设置收缩状态时的布局*/
    private void initReduce() {
        yySearchEdname.setCursorVisible(false);
        yySearchEdname.setVisibility(View.GONE);
        yySearchTextName.setVisibility(View.GONE);
        ConstraintLayout.LayoutParams LayoutParams = (ConstraintLayout.LayoutParams) yySearchLinear.getLayoutParams();
        LayoutParams.width = dip2px(50);
        LayoutParams.setMargins(dip2px(0), dip2px(30), dip2px(0), dip2px(0));
        yySearchLinear.setLayoutParams(LayoutParams);

        //隐藏键盘
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        yySearchEdname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yySearchEdname.setCursorVisible(true);
            }
        });
        //开始动画
        beginDelayedTransition(yySearchLinear);
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


    @OnClick({R.id.yy_dingwei, R.id.yy_search_image, R.id.yy_search_textName})
    public void onView1Clicked(View view) {
        switch (view.getId()) {
            case R.id.yy_dingwei:

                break;
            case R.id.yy_search_image:
                initExpand();
                break;
            case R.id.yy_search_textName:
                initReduce();
                break;
        }
    }
}
