package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.mvp.ui.view.SeatTable;
import com.jaeger.library.StatusBarUtil;

import java.text.DecimalFormat;

public class XuanzuoActivity extends AppCompatActivity {

    private SeatTable seat;
    private TextView mAddress;
    private TextView mPrice;
    private TextView mYingcheng;
    private TextView mTing;
    private ImageView mBack;
    private ImageView mXiadan;
    private TextView mShijian;
    private TextView mMoviename;
    private double zongprice;
    private int mount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucentForImageView(this, null);
        setContentView(R.layout.activity_xuanzuo);
        getSupportActionBar().hide();
        mAddress = findViewById(R.id.address);
        mPrice = findViewById(R.id.price);
        mYingcheng = findViewById(R.id.yingcheng);
        mTing = findViewById(R.id.ting);
        mBack = findViewById(R.id.back);
        mXiadan = findViewById(R.id.xiadan);
        mShijian = findViewById(R.id.shijian);
        mMoviename = findViewById(R.id.moviename);
        seat = findViewById(R.id.seat);

        Intent intent = getIntent();
        String time = intent.getStringExtra("time");
        String screeningHall = intent.getStringExtra("ScreeningHall");
        String cinemasname = intent.getStringExtra("cinemasname");
        String cinemasaddress = intent.getStringExtra("cinemasaddress");
        String name = intent.getStringExtra("name");
        final double price = intent.getDoubleExtra("price", 0.0);
        mAddress.setText(cinemasaddress);
        mYingcheng.setText(cinemasname);
        mMoviename.setText(name);
        mShijian.setText(time);
        mTing.setText(screeningHall);
        seat.setData(10, 15);
        seat.setScreenName("8号厅荧幕");//设置屏幕名称
        seat.setMaxSelected(5);//设置最多选中
        seat.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                if (column == 2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if (row == 6 && column == 6) {
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {
                zongprice += price;
                mount++;
                DecimalFormat df2 = new DecimalFormat("#0.00");
                String format = df2.format(zongprice);
                mPrice.setText(format + "");
            }

            @Override
            public void unCheck(int row, int column) {
                zongprice -= price;
                mount--;
                DecimalFormat df2 = new DecimalFormat("#0.00");
                String format = df2.format(zongprice);
                if (mount==0){
                    mPrice.setText("#0.00");
                }
                mPrice.setText(format + "");
            }


        });

    }
}
