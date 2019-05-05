package com.bw.movie.mvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.FindAllSysMsgListBean;

import java.util.List;

public class SystemAdapter extends RecyclerView.Adapter<SystemAdapter.MyVh> {
    Context context;
    List<FindAllSysMsgListBean.ResultBean> list;

    public SystemAdapter(Context context, List<FindAllSysMsgListBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.system_item,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {
        myVh.textView.setText(list.get(i).getTitle()+"");
        myVh.textView1.setText(list.get(i).getContent()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {
        private TextView textView,textView1;
        public MyVh(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.text);
            textView1= itemView.findViewById(R.id.text1);
        }
    }
}
