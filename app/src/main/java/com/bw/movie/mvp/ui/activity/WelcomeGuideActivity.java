package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bw.movie.R;
import com.bw.movie.mvp.ui.adapter.GuideViewPagerAdapter;
import com.bw.movie.mvp.ui.fragment.SlideFragment;
import com.github.paolorotolo.appintro.AppIntro;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

public class WelcomeGuideActivity extends AppIntro {

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        addSlide(SlideFragment.newInstance(R.layout.guide_view1));
        addSlide(SlideFragment.newInstance(R.layout.guide_view2));
        addSlide(SlideFragment.newInstance(R.layout.guide_view3));
        showStatusBar(true);
        setNavBarColor(R.color.colorwhite);
        setSkipText("跳过");
        setColorSkipButton(Color.RED);
        setColorDoneText(Color.RED);
        setDoneText("完成");
    }
    @Override
    public void onSkipPressed() {
        //当执行跳过动作时触发
        Intent intent = new Intent(WelcomeGuideActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onDonePressed() {
        //当执行完成动作时触发
        Intent intent = new Intent(WelcomeGuideActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSlideChanged() {
        //当执行变化动作时触发
    }


}
