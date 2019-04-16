package com.bw.movie.mvp.ui.adapter.popadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.XiangBean;

public class Pop_xiangqing_adapter extends RecyclerView.Adapter<Pop_xiangqing_adapter.ViewHodler> {
    Context context;
    XiangBean.ResultBean list;

    public Pop_xiangqing_adapter(Context context, XiangBean.ResultBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.pop_yanyuanlistitem_layout,null);
        ViewHodler hodler=new ViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        String[] split = list.getStarring().split(",");
        holder.textView1.setText(split[position]);
    }

    @Override
    public int getItemCount() {
        return list.getStarring().split(",").length;
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.yan);
            textView2=itemView.findViewById(R.id.shi);
        }
    }
}
