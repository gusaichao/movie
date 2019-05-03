package com.bw.movie.mvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.BuyTicketRecordListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuyTicketRecordListAdapter extends RecyclerView.Adapter<BuyTicketRecordListAdapter.Myvh> {

    private Context context;
    private List<BuyTicketRecordListBean.ResultBean> list;

    public BuyTicketRecordListAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();

    }

    public void setList(List<BuyTicketRecordListBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Myvh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pay_jilu_list, viewGroup, false);
        return new Myvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Myvh myVh, final int i) {
        int status = list.get(i).getStatus();
        if (status==2){
            //已经支付
            myVh.PaidFlimName.setText(list.get(i).getMovieName());
            String beginTime =  list.get(i).getBeginTime();
            String endTime =  list.get(i).getEndTime();
            myVh.Topay.setVisibility(View.GONE);
            myVh.PaidFlimTime.setText(beginTime+"-"+endTime+"");
            myVh.PaidFlimOrder.setText("订单号: "+list.get(i).getOrderId()+"");
            long createTime = list.get(i).getCreateTime();
//            String create = TimerUnitls.statmed(createTime);
//            myVh.PaidStartTime.setText(create+"");
            myVh.PaidCinema.setText("影院: "+list.get(i).getCinemaName()+"");
            myVh.PaidCinemahall.setText("影厅: "+list.get(i).getScreeningHall()+"");
            myVh.PaidNum.setText("数量: "+list.get(i).getAmount()+"");
            myVh.PaidMoney.setText("金额: "+list.get(i).getPrice()+"");
        }else {
            //待付款
            myVh.PaidFlimName.setText(list.get(i).getMovieName());
            String beginTime =  list.get(i).getBeginTime();
            String endTime =  list.get(i).getEndTime();
            myVh.PaidFlimTime.setText("时间:"+beginTime+"-"+endTime+"");
            myVh.Topay.setVisibility(View.VISIBLE);
            myVh.FlimTimeText.setVisibility(View.GONE);
            myVh.PaidFlimTime.setVisibility(View.GONE);
            myVh.PaidFlimOrder.setText("订单号: "+list.get(i).getOrderId()+"");
            myVh.PaidStartTime.setVisibility(View.GONE);
            myVh.PaidCinema.setText("影院: "+list.get(i).getCinemaName()+"");
            myVh.PaidCinemahall.setText("影厅: "+list.get(i).getScreeningHall()+"");
            myVh.PaidNum.setText("数量: "+list.get(i).getAmount()+"");
            myVh.PaidMoney.setText("金额: "+list.get(i).getPrice()+"");
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myvh extends RecyclerView.ViewHolder {
        TextView PaidFlimName;
        TextView Topay;
        TextView PaidFlimTime;
        TextView FlimTimeText;
        TextView PaidFlimOrder;
        TextView PaidStartTime;
        TextView PaidCinema;
        TextView PaidCinemahall;
        TextView PaidTime;
        TextView PaidNum;
        TextView PaidMoney;

        public Myvh(@NonNull View itemView) {
            super(itemView);
            PaidFlimName = (TextView) itemView.findViewById(R.id.paid_flim_name);
            Topay = (TextView) itemView.findViewById(R.id.gopay);
            PaidFlimTime = (TextView) itemView.findViewById(R.id.paid_flim_time);
            FlimTimeText = (TextView) itemView.findViewById(R.id.flim_time_text);
            PaidFlimOrder = (TextView) itemView.findViewById(R.id.paid_flim_order);
            PaidStartTime = (TextView) itemView.findViewById(R.id.paid_start_time);
            PaidCinema = (TextView) itemView.findViewById(R.id.paid_cinema);
            PaidCinemahall = (TextView) itemView.findViewById(R.id.paid_cinemahall);
            PaidTime = (TextView) itemView.findViewById(R.id.paid_time);
            PaidNum = (TextView) itemView.findViewById(R.id.paid_num);
            PaidMoney = (TextView) itemView.findViewById(R.id.paid_money);

        }
    }
}
