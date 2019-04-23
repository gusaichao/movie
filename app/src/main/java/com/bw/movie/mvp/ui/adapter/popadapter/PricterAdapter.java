package com.bw.movie.mvp.ui.adapter.popadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangBean;
import com.facebook.drawee.view.SimpleDraweeView;


public class PricterAdapter extends RecyclerView.Adapter<PricterAdapter.MyVh> {
    private Context context;
    XiangBean.ResultBean list;

    public PricterAdapter(Context context, XiangBean.ResultBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pubuliu,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {

       Glide.with(context).load(list.getPosterList().get(i)).into(myVh.img);
       if (i%2!=0){
           LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(myVh.img.getLayoutParams());
           params.setMargins(0,40,0,0);
           myVh.img.setLayoutParams(params);
       }else{
           LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(myVh.img.getLayoutParams());
           params.setMargins(0,20,0,0);
           myVh.img.setLayoutParams(params);
       }
    }

    @Override
    public int getItemCount() {
        return list.getPosterList().size();
    }

    public class MyVh extends RecyclerView.ViewHolder {
        private final ImageView img;
        public MyVh(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
