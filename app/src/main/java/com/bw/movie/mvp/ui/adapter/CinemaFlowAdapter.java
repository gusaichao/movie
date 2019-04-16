package com.bw.movie.mvp.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.AllBean;
import com.bw.movie.bean.ComingBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.NowshowBean;
import com.bw.movie.mvp.ui.activity.XiangActivity;
import com.bw.movie.mvp.ui.adapter.homeitem.BannerAdapter;
import com.bw.movie.mvp.ui.adapter.homeitem.ComingAdapter;
import com.bw.movie.mvp.ui.adapter.homeitem.HotAdapter;
import com.bw.movie.mvp.ui.adapter.homeitem.NowshowAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

public class CinemaFlowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>implements HotAdapter.HotClicklinsenter,NowshowAdapter.NowClicklinsenter,ComingAdapter.ComClicklinsenter {
    private Context context;
    private final int BANNER = 0;
    private final int HOT = 1;
    private final int STYLE = 2;
    private final int LIVE = 3;
    private List<HotmovieBean.ResultBean> list;
    private List<NowshowBean.ResultBean> list2;
    private List<ComingBean.ResultBean> list3;
//    private Handler handler;
    private AllBean allBean;
//    private int current;
    public CinemaFlowAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
    }

    public void setAllBean(AllBean allBean) {
        this.allBean = allBean;
        notifyDataSetChanged();
    }

    public void setList(List<HotmovieBean.ResultBean> list) {
        this.list = list;
    }

    public void setList2(List<NowshowBean.ResultBean> list2) {
        this.list2 = list2;
    }

    public void setList3(List<ComingBean.ResultBean> list3) {
        this.list3 = list3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (getItemViewType(viewType)==BANNER){
            view = LayoutInflater.from(context).inflate(R.layout.banner_layout,parent,false);
            return new ViewHoder_banner(view);
        }else if (getItemViewType(viewType)==HOT){
            view = LayoutInflater.from(context).inflate(R.layout.hotmovie_layout,parent,false);
            return new ViewHoder_hot(view);
        }else if (getItemViewType(viewType)==STYLE){
            view = LayoutInflater.from(context).inflate(R.layout.nowshow_layout,parent,false);
            return new ViewHoder_style(view);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.coming_layout,parent,false);
            return new ViewHoder_live(view);
        }

    }

    @SuppressLint({"HandlerLeak", "ClickableViewAccessibility"})
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position)==BANNER){
            BannerAdapter bannerAdapter = new BannerAdapter(context,list);
            ((ViewHoder_banner)holder).recyclerCoverFlow.setAdapter(bannerAdapter);
//            //轮播图自动轮播
//            handler = new Handler(){
//                @Override
//                public void handleMessage(Message msg) {
//                    super.handleMessage(msg);
//                    int selse = ((ViewHoder_banner)holder).recyclerCoverFlow.getSelectedPos();
//                    ((ViewHoder_banner)holder).recyclerCoverFlow.smoothScrollToPosition(++selse);
//                    ((ViewHoder_banner) holder).recyclerCoverFlow.clearFocus();
//                    handler.sendEmptyMessageDelayed(0,3000);
//                }
//            };
//            handler.sendEmptyMessage(0);
        }else if (getItemViewType(position)==HOT){
            HotAdapter hotAdapter = new HotAdapter(context,list);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((ViewHoder_hot)holder).rxsp_rcve.setLayoutManager(layoutManager);
            hotAdapter.setHotClicklinsenter(this);
            ((ViewHoder_hot)holder).rxsp_rcve.setAdapter(hotAdapter);
        }else if (getItemViewType(position)==STYLE){
            NowshowAdapter nowshowAdapter = new NowshowAdapter(context,list2);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((ViewHoder_style)holder).mlss_rcve.setLayoutManager(layoutManager);
            nowshowAdapter.setNowClicklinsenter(this);
            ((ViewHoder_style)holder).mlss_rcve.setAdapter(nowshowAdapter);
        }else{
            ComingAdapter comingAdapter = new ComingAdapter(context,list3);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            ((ViewHoder_live)holder).pzsh_rcve.setLayoutManager(layoutManager);
            comingAdapter.setComClicklinsenter(this);
            ((ViewHoder_live)holder).pzsh_rcve.setAdapter(comingAdapter);
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return BANNER;
        }else if (position==1){
            return HOT;
        }else if (position==2){
            return STYLE;
        }else {
            return LIVE;
        }
    }

    @Override
    public int getItemCount() {
        return allBean==null?0:4;
    }

    @Override
    public void hotclick(String hotid) {

    }

    @Override
    public void comclick(String hotid) {

    }

    @Override
    public void nowclick(String hotid) {

    }

    class ViewHoder_banner extends RecyclerView.ViewHolder{

        private final RecyclerCoverFlow recyclerCoverFlow;

        public ViewHoder_banner(View itemView) {
            super(itemView);
            recyclerCoverFlow = itemView.findViewById(R.id.dianyingbanner);
        }
    }

    class ViewHoder_hot extends RecyclerView.ViewHolder{
        private final RecyclerView rxsp_rcve;

        public ViewHoder_hot(View itemView) {
            super(itemView);
            rxsp_rcve = itemView.findViewById(R.id.hotmovie_recy);
        }
    }

    class ViewHoder_style extends RecyclerView.ViewHolder{
        private final RecyclerView mlss_rcve;

        public ViewHoder_style(View itemView) {
            super(itemView);
            mlss_rcve = itemView.findViewById(R.id.nowshow_recy);
        }
    }

    class ViewHoder_live extends RecyclerView.ViewHolder{
        private final RecyclerView pzsh_rcve;

        public ViewHoder_live(View itemView) {
            super(itemView);
            pzsh_rcve = itemView.findViewById(R.id.coming_recy);
        }
    }



}
