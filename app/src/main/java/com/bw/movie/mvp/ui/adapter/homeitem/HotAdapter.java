package com.bw.movie.mvp.ui.adapter.homeitem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.mvp.ui.activity.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.Myvh> {

    private Context context;
    private List<HotmovieBean.ResultBean> list;

    public HotAdapter(Context context, List<HotmovieBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Myvh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotmovie_item_layout,parent,false);
        return new Myvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myvh holder, final int position) {
        Uri uri = Uri.parse(list.get(position).getImageUrl());
        holder.imageView.setImageURI(uri);
        holder.name.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hotClicklinsenter.hotclick(list.get(position).getId()+"");
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

        private final SimpleDraweeView imageView;
        private final TextView name;

        public Myvh(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            name = itemView.findViewById(R.id.name);


        }
    }

    private HotClicklinsenter hotClicklinsenter;
    public void setHotClicklinsenter(HotClicklinsenter hotClicklinsenter) {
        this.hotClicklinsenter = hotClicklinsenter;
    }

    public interface HotClicklinsenter{
        void hotclick(String hotid);
    }

}
