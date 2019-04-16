package com.bw.movie.mvp.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bw.movie.R;
import com.jaeger.library.StatusBarUtil;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView mYidaoyeImage;
    private StatusBarUtil statusBarUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarUtil.setTranslucentForImageView(this,mYidaoyeImage);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mYidaoyeImage = findViewById(R.id.yidaoye_image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,WelcomeGuideActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }


}
