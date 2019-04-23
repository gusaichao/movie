package com.bw.movie.mvp.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.CinemaPageListBean;
import com.bw.movie.bean.TuijianBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class CinemapageListAdapter extends RecyclerView.Adapter<CinemapageListAdapter.Myvh> {
    private Context context;
    private List<CinemaPageListBean.ResultBean> list;

    public CinemapageListAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();

    }

    public void setList(List<CinemaPageListBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Myvh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.wodeguanzhu_recy_item_layout, viewGroup, false);
        return new Myvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myvh myvh, final int i) {
        myvh.mNameModel.setText(list.get(i).getAddress());
        myvh.mTitleModel.setText(list.get(i).getName());
        Uri uri = Uri.parse(list.get(i).getLogo());
        myvh.mImageModel.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myvh extends RecyclerView.ViewHolder {

        private TextView mTitleModel;
        private TextView mNameModel;
        private SimpleDraweeView mImageModel;
        public Myvh(@NonNull View itemView) {
            super(itemView);
            mTitleModel = itemView.findViewById(R.id.title_model);
            mNameModel = itemView.findViewById(R.id.name_model);
            mImageModel = itemView.findViewById(R.id.image_model);
        }
    }

}
