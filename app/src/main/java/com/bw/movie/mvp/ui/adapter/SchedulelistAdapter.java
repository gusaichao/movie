package com.bw.movie.mvp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.mvp.ui.activity.XuanzuoActivity;

import java.util.ArrayList;
import java.util.List;

public class SchedulelistAdapter extends RecyclerView.Adapter<SchedulelistAdapter.MyVH> {
    private Context context;
    private List<MovieScheduleListBean.ResultBean> list;



    public SchedulelistAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();

    }

    public void setList(List<MovieScheduleListBean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.schedule_item_layout, parent, false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, final int position) {
        holder.mScheduleItemBeginTime.setText(list.get(position).getBeginTime());
        holder.mScheduleItemScreeningHall.setText(list.get(position).getScreeningHall());
        holder.mScheduleItemPrice.setText(list.get(position).getPrice() + "");
        holder.mScheduleItemEndtime.setText("----"+list.get(position).getEndTime()+"end");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setScheduleOnclicklisenter.click(list.get(position).getBeginTime()
                                +"--"+list.get(position).getEndTime(),
                                list.get(position).getScreeningHall(),
                                list.get(position).getPrice(),
                            list.get(position).getId()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {

        private TextView mScheduleItemBeginTime;
        private TextView mScheduleItemScreeningHall;
        private TextView mScheduleItemPrice;
        private TextView mScheduleItemEndtime;
        public MyVH(View itemView) {
            super(itemView);

            mScheduleItemBeginTime = itemView.findViewById(R.id.schedule_item_beginTime);
            mScheduleItemScreeningHall = itemView.findViewById(R.id.schedule_item_screeningHall);
            mScheduleItemPrice = itemView.findViewById(R.id.schedule_item_price);
            mScheduleItemEndtime = itemView.findViewById(R.id.schedule_item_endtime);
        }
    }
    private setScheduleOnclicklisenter setScheduleOnclicklisenter;
    public void setSetScheduleOnclicklisenter(SchedulelistAdapter.setScheduleOnclicklisenter setScheduleOnclicklisenter) {
        this.setScheduleOnclicklisenter = setScheduleOnclicklisenter;
    }

    public interface setScheduleOnclicklisenter{
        void click(String time,String ScreeningHall,double price,String id);
    }

}
