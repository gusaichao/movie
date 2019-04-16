package com.bw.movie.mvp.ui.adapter.homeitem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.mvp.ui.activity.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.Myvh> {

    private Context context;
    private List<HotmovieBean.ResultBean> list;


    public BannerAdapter(Context context, List<HotmovieBean.ResultBean> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public Myvh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_item, parent, false);
        return new Myvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myvh holder, final int position) {
        Uri uri = Uri.parse(list.get(position).getImageUrl());
        holder.mSimpCinemaFlow.setImageURI(uri);
        holder.mSimpCinemaFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,XiangActivity.class);
                intent.putExtra("movieid",list.get(position).getId()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myvh extends RecyclerView.ViewHolder {
        private SimpleDraweeView mSimpCinemaFlow;
        public Myvh(View itemView) {
            super(itemView);
            mSimpCinemaFlow = itemView.findViewById(R.id.simp_cinema_flow);
        }
    }
}
