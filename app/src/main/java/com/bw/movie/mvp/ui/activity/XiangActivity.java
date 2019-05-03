package com.bw.movie.mvp.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.presneter.XiangPresenter;
import com.bw.movie.mvp.ui.adapter.ShortVideoAdapter;
import com.bw.movie.mvp.ui.adapter.popadapter.PingAdapter;
import com.bw.movie.mvp.ui.adapter.popadapter.Pop_xiangqing_adapter;
import com.bw.movie.mvp.ui.adapter.popadapter.PricterAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jaeger.library.StatusBarUtil;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;

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
    @BindView(R.id.com_icon_movie_default)
    ImageView comIconMovieDefault;
    @BindView(R.id.xiang_lin)
    LinearLayout xiangLin;
    private StatusBarUtil statusBarUtil;
    private XiangBean.ResultBean result;
    private int x;
    private int y;
    private View mView;
    private PopupWindow popupWindow;
    private String movieid;
    private List<PingBean.ResultBean> result1;


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
        movieid = intent.getStringExtra("movieid");
        presenter.getKeyorNum(movieid);
        presenter.getpingKeyorNum("1", "10", movieid);
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
        final int followCinema = result.getFollowMovie();
        if (followCinema==1){
            xiangCheckbox.setChecked(true);
        }else{
            xiangCheckbox.setChecked(false);
        }
        xiangCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    xiangCheckbox.setChecked(true);
                    presenter.getguanzhuKeyorNum(result.getId()+"");
                }else {
                    xiangCheckbox.setChecked(false);
                    presenter.getquxiaocidKeyorNum(result.getId()+"");
                }
            }
        });
    }

    @Override
    public void faild(Throwable t) {

    }

    @Override
    public void pingsuccess(PingBean resultBean) {
        result1 = resultBean.getResult();
    }

    @Override
    public void pingfaild(Throwable t) {

    }

    @Override
    public void CinemasListByMovieIdsuccess(CinemasListByMovieIdBean result) {

    }

    @Override
    public void CinemasListByMovieIdfaild(Throwable t) {

    }

    @Override
    public void addpingsuccess(String result) {
        Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
        if (result.equals("评论成功")){
            popupWindow.dismiss();
        }
    }

    @Override
    public void addpingfailure(String msg) {

    }

    @Override
    public void guanzhusuccess(BaseBean result) {
        Toast.makeText(this, result.getMessage()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void guanzhufaild(Throwable t) {

    }

    @Override
    public void quxiaosuccess(BaseBean result) {
        Toast.makeText(this, result.getMessage()+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void quxiaofaild(Throwable t) {

    }


    @OnClick({R.id.xiang_text_xiangqing, R.id.xiang_text_yugao, R.id.xiang_text_juzhao, R.id.xiang_text_yingping, R.id.xiang_image_back, R.id.xiang_text_goupiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiang_text_xiangqing:
                showpopupwindow();
                break;
            case R.id.xiang_text_yugao:
                showyugaopopupwindow();
                break;
            case R.id.xiang_text_juzhao:
                showjuzhaopopupwindow();
                break;
            case R.id.xiang_text_yingping:
                showyingpingpopupwindow();
                break;
            case R.id.xiang_image_back:
                finish();
                break;
            case R.id.xiang_text_goupiao:
                goupiao();
                break;
        }
    }

    private void goupiao() {
        Intent intent = new Intent(XiangActivity.this,CinemasListByMovieIdActivity.class);
        intent.putExtra("movieid",movieid);
        intent.putExtra("moviename",result.getName());
        startActivity(intent);
    }

    private void showyingpingpopupwindow() {

        mView = LinearLayout.inflate(this, R.layout.pop_film_ping, null);
        mView.findViewById(R.id.pop_detail_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        RecyclerView frag_recommend_3 = mView.findViewById(R.id.frag_recommend_4);
        ImageView white_pinglun = mView.findViewById(R.id.white_pinglun);
        ImageView pinglun_back = mView.findViewById(R.id.pinglun_back);

        popupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        popupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        popupWindow.getContentView().setFocusableInTouchMode(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(xiangMovieName);
        frag_recommend_3.setLayoutManager(new LinearLayoutManager(this));
        PingAdapter pingAdapter = new PingAdapter(this);
        pingAdapter.setList(result1);
        frag_recommend_3.setAdapter(pingAdapter);
        white_pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder customizeDialog =
                        new AlertDialog.Builder(XiangActivity.this);
                final View dialogView = LayoutInflater.from(XiangActivity.this).inflate(R.layout.dialog_input_text_msg,null);
                final EditText pub_ed_txt = dialogView.findViewById(R.id.et_input_message);
                customizeDialog.setTitle("发布评论");
                customizeDialog.setView(dialogView);
                customizeDialog.setPositiveButton("确定发送",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String trim = pub_ed_txt.getText().toString().trim();
                                if (!trim.isEmpty()) {
                                    HashMap<String,String> map = new HashMap<String,String>();
                                    map.put("movieId",movieid);
                                    map.put("commentContent",trim);
                                    presenter.gettext(map);
                                } else {
                                    Toast.makeText(XiangActivity.this, "输入框不能为空", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                customizeDialog.setNegativeButton("取消发送",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                customizeDialog.show();

            }
        });
        pinglun_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void showjuzhaopopupwindow() {
        //剧照
        mView = LinearLayout.inflate(this, R.layout.pop_film_stale, null);
        RecyclerView rev = mView.findViewById(R.id.rev);
        mView.findViewById(R.id.pop_detail_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        popupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        popupWindow.getContentView().setFocusableInTouchMode(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(xiangMovieName);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rev.setLayoutManager(staggeredGridLayoutManager);
        PricterAdapter pricterAdapter = new PricterAdapter(this, result);
        rev.setAdapter(pricterAdapter);
    }

    private void showyugaopopupwindow() {
        mView = LinearLayout.inflate(this, R.layout.pop_film_short, null);
        ImageView vies = mView.findViewById(R.id.pop_detail_three);
        RecyclerView frag_recommend_3 = mView.findViewById(R.id.frag_recommend_2);
        popupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
//        popupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        popupWindow.getContentView().setFocusableInTouchMode(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(xiangMovieName);
        vies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                JZVideoPlayer.releaseAllVideos();
            }
        });
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(this);
        linearLayoutManagers.setOrientation(OrientationHelper.VERTICAL);
        frag_recommend_3.setLayoutManager(linearLayoutManagers);
        ShortVideoAdapter shortVideoAdapter = new ShortVideoAdapter(this, result);
        frag_recommend_3.setAdapter(shortVideoAdapter);

    }

    private void showpopupwindow() {
        mView = LinearLayout.inflate(this, R.layout.pop_xiangqing1, null);
        popupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
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
        popupWindow.showAsDropDown(comIconMovieDefault);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        pop_detail_typetext.setText(getString(R.string.app_leixing) + result.getMovieTypes());
        pop_detail_minute.setText(getString(R.string.app_daoyan) + result.getDirector());
        pop_detail_place.setText(getString(R.string.app_shichang) + result.getDuration());
        pop_detail_director.setText(getString(R.string.app_chandi) + result.getPlaceOrigin());
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
        Pop_xiangqing_adapter pop_xiangqing_adapter = new Pop_xiangqing_adapter(this, result);
        revs.setAdapter(pop_xiangqing_adapter);
    }


}
