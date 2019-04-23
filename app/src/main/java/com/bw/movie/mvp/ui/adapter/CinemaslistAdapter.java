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
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.FujinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class CinemaslistAdapter extends RecyclerView.Adapter<CinemaslistAdapter.Myvh> {
    private Context context;
    private List<CinemasListByMovieIdBean.ResultBean> list;

    public CinemaslistAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();

    }

    public void setList(List<CinemasListByMovieIdBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Myvh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cinemaslist_recy_item_layout, viewGroup, false);
        return new Myvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myvh myvh, final int i) {
        myvh.mNameModel.setText(list.get(i).getAddress());
        myvh.mTitleModel.setText(list.get(i).getName());
        Uri uri = Uri.parse(list.get(i).getLogo());
        myvh.mImageModel.setImageURI(uri);
        final int followCinema = list.get(i).getFollowCinema();
        if (followCinema==1){
            myvh.mXiangCheckbox.setChecked(true);
        }else{
            myvh.mXiangCheckbox.setChecked(false);
        }
        myvh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclicklisnter.clickitem(list.get(i).getId()+"",list.get(i).getName(),list.get(i).getAddress());
            }
        });



        myvh.mXiangCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    myvh.mXiangCheckbox.setChecked(true);
                    onclicklisnter.click(list.get(i).getId()+"",1);
                }else {
                    myvh.mXiangCheckbox.setChecked(false);
                    onclicklisnter.click(list.get(i).getId()+"",2);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myvh extends RecyclerView.ViewHolder {

        private TextView mTitleModel;
        private TextView mNameModel;
        private SimpleDraweeView mImageModel;
        private CheckBox mXiangCheckbox;
        private TextView mPriceModel;
        public Myvh(@NonNull View itemView) {
            super(itemView);
            mTitleModel = itemView.findViewById(R.id.title_model);
            mNameModel = itemView.findViewById(R.id.name_model);
            mImageModel = itemView.findViewById(R.id.image_model);
            mXiangCheckbox = itemView.findViewById(R.id.tuijian_checkbox);
            mPriceModel = itemView.findViewById(R.id.price_model);
        }
    }


    private onclicklisnter onclicklisnter;
    public void setOnclicklisnter(CinemaslistAdapter.onclicklisnter onclicklisnter) {
        this.onclicklisnter = onclicklisnter;
    }

    public interface onclicklisnter{
        void click(String cid, int bb);
        void clickitem(String cid,String name,String address);
    }

}
