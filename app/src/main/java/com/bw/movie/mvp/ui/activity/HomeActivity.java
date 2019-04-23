package com.bw.movie.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.mvp.ui.fragment.homefragment.myFragment;
import com.bw.movie.mvp.ui.fragment.homefragment.yingpianFragment;
import com.bw.movie.mvp.ui.fragment.homefragment.yingyuanFragment;
import com.bw.movie.mvp.ui.view.CustomViewPager;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
    private StatusBarUtil statusBarUtil;
    private CustomViewPager mHomeViewpager;
    private RadioGroup mNavigationBtn;
    private RadioButton mBtn2;
    private RadioButton mBtn3;
    private RadioButton mBtn1;
    private ArrayList<Fragment> list_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarUtil.setTranslucentForImageViewInFragment(this, null);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        initView();
        initData();

    }

    private void initData() {
        mHomeViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list_fragment.get(i);
            }

            @Override
            public int getCount() {
                return list_fragment.size();
            }
        });
        mNavigationBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn1:
                        mHomeViewpager.setCurrentItem(0);
                        break;
                    case R.id.btn2:
                        mHomeViewpager.setCurrentItem(1);
                        break;
                    case R.id.btn3:
                        mHomeViewpager.setCurrentItem(2);
                        break;
                }
            }
        });


    }

    private void initView() {
        mHomeViewpager = findViewById(R.id.home_viewpager);
        mNavigationBtn = findViewById(R.id.navigation_btn);
        mBtn2 = findViewById(R.id.btn2);
        mBtn3 = findViewById(R.id.btn3);
        mBtn1 = findViewById(R.id.btn1);
        list_fragment = new ArrayList<>();
        list_fragment.add(new yingpianFragment());
        list_fragment.add(new yingyuanFragment());
        list_fragment.add(new myFragment());
        mHomeViewpager.setScanScroll(false);
    }
}
