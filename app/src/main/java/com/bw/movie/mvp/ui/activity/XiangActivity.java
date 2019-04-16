package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.presneter.XiangPresenter;
import com.bw.movie.mvp.ui.adapter.popadapter.Pop_xiangqing_adapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangActivity extends BaseActivity<XiangPresenter> implements XiangContart.IXiangtopView {
    @BindView(R.id.xiang_checkbox)
    CheckBox xiangCheckbox;
    @BindView(R.id.xiang_movie_name)
    TextView xiangMovieName;
    @BindView(R.id.xiang_movie_image)
    SimpleDraweeView xiangMovieImage;
    @BindView(R.id.xiang_text_xiangqing)
    TextView xiangTextXiangqing;
    @BindView(R.id.xiang_text_yugao)
    TextView xiangTextYugao;
    @BindView(R.id.xiang_text_juzhao)
    TextView xiangTextJuzhao;
    @BindView(R.id.xiang_text_yingping)
    TextView xiangTextYingping;
    @BindView(R.id.xiang_image_back)
    ImageView xiangImageBack;
    @BindView(R.id.xiang_text_goupiao)
    TextView xiangTextGoupiao;
    private StatusBarUtil statusBarUtil;
    private XiangBean.ResultBean result;
    private int x;
    private int y;


    @Override
    protected void initData() {

    }

    @Override
    protected XiangPresenter providerPresenter() {
        return new XiangPresenter(this);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        Display display = this.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        x = point.x;
        y = point.y;
        Intent intent = getIntent();
        String movieid = intent.getStringExtra("movieid");
        Toast.makeText(this, "" + movieid, Toast.LENGTH_SHORT).show();
        presenter.getKeyorNum(movieid);
    }

    @Override
    protected int providerLayoutId() {
        statusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_xiang;
    }

    @Override
    public void success(XiangBean resultBean) {
        result = resultBean.getResult();
        String replaceAll = result.getImageUrl().replaceAll("http://172.17.8.100/", "http://mobile.bwstudent.com/");
        Uri uri = Uri.parse(replaceAll);
        xiangMovieImage.setImageURI(uri);
        xiangMovieName.setText(result.getName());
    }

    @Override
    public void faild(Throwable t) {

    }



    @OnClick({R.id.xiang_checkbox, R.id.xiang_text_xiangqing, R.id.xiang_text_yugao, R.id.xiang_text_juzhao, R.id.xiang_text_yingping, R.id.xiang_image_back, R.id.xiang_text_goupiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiang_checkbox:
                break;
            case R.id.xiang_text_xiangqing:
                showpopupwindow();
                break;
            case R.id.xiang_text_yugao:
                break;
            case R.id.xiang_text_juzhao:
                break;
            case R.id.xiang_text_yingping:
                break;
            case R.id.xiang_image_back:
                finish();
                break;
            case R.id.xiang_text_goupiao:
                break;
        }
    }

    private void showpopupwindow() {
        View mView = LinearLayout.inflate(this, R.layout.pop_xiangqing1, null);
        final PopupWindow popupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        SimpleDraweeView imageView = mView.findViewById(R.id.image);
        TextView pop_detail_typetext = mView.findViewById(R.id.pop_detail_typetext);
        TextView pop_detail_director = mView.findViewById(R.id.pop_detail_director);
        TextView pop_detail_minute = mView.findViewById(R.id.pop_detail_minute);
        TextView pop_detail_place = mView.findViewById(R.id.pop_detail_place);
        TextView pop_detail_content = mView.findViewById(R.id.title);
        ImageView pop_detail_finish = mView.findViewById(R.id.pop_detail_finish);
        RecyclerView revs = mView.findViewById(R.id.revs);
        popupWindow.setWidth(x);
        popupWindow.setHeight(y);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(mView,Gravity.BOTTOM,0,0);
        pop_detail_typetext.setText(getString(R.string.app_leixing)+result.getMovieTypes());
        pop_detail_minute.setText(getString(R.string.app_daoyan)+result.getDirector());
        pop_detail_place.setText(getString(R.string.app_shichang)+result.getDuration());
        pop_detail_director.setText(getString(R.string.app_chandi)+result.getPlaceOrigin());
        pop_detail_content.setText(result.getSummary());
        String replaceAll = result.getImageUrl().replaceAll("http://172.17.8.100/", "http://mobile.bwstudent.com/");
        Uri uri = Uri.parse(replaceAll);
        imageView.setImageURI(uri);
        pop_detail_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(this);
        linearLayoutManagers.setOrientation(OrientationHelper.VERTICAL);
        revs.setLayoutManager(linearLayoutManagers);
        Pop_xiangqing_adapter pop_xiangqing_adapter = new Pop_xiangqing_adapter(this,result);
        revs.setAdapter(pop_xiangqing_adapter);
    }
}
