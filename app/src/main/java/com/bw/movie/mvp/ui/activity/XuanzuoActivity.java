package com.bw.movie.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BuyTicketRecordListBean;
import com.bw.movie.bean.MovieTicket;
import com.bw.movie.bean.PayBean;
import com.bw.movie.mvp.contart.MovieTicketContart;
import com.bw.movie.mvp.presneter.MovieTicketPresenter;
import com.bw.movie.mvp.ui.view.SeatTable;
import com.bw.movie.utils.MD5Utils;
import com.bw.movie.utils.SPFUtil;
import com.jaeger.library.StatusBarUtil;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.text.DecimalFormat;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bw.movie.utils.WeiXinUtil.APP_ID;

public class XuanzuoActivity extends BaseActivity<MovieTicketPresenter> implements MovieTicketContart.MovieTicketView {

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
    private RadioButton mWeixinPay;
    private RadioButton mZhifubaoPay;
    private RadioGroup mRadio;
    /**
     * 购票
     */
    private Button mBtnPay;
    private String format;
    private String id;
    private boolean paytype;
    private IWXAPI wxapi;
    private String orderId;


    @Override
    protected void initData() {

    }

    @Override
    protected MovieTicketPresenter providerPresenter() {
        return new MovieTicketPresenter(this);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        mAddress = findViewById(R.id.address);
        mPrice = findViewById(R.id.price);
        mYingcheng = findViewById(R.id.yingcheng);
        mTing = findViewById(R.id.ting);
        mBack = findViewById(R.id.quxiao);
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
        id = intent.getStringExtra("id");
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
                format = df2.format(zongprice);
                mPrice.setText(format + "");
            }

            @Override
            public void unCheck(int row, int column) {
                zongprice -= price;
                mount--;
                DecimalFormat df2 = new DecimalFormat("#0.00");
                format = df2.format(zongprice);
                if (mount == 0) {
                    mPrice.setText("#0.00");
                }
                mPrice.setText(format + "");
            }
        });
    }

    @Override
    protected int providerLayoutId() {
        StatusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_xuanzuo;
    }

    @OnClick({R.id.xiadan, R.id.quxiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiadan:
                showpopupwindow();
                break;
            case R.id.quxiao:
                break;
        }
    }

    private void showpopupwindow() {

        View mview = LinearLayout.inflate(this, R.layout.pop_pay, null);
        final PopupWindow popupWindow = new PopupWindow(mview, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mWeixinPay = (RadioButton) mview.findViewById(R.id.weixin_pay);
        ImageView img_down = mview.findViewById(R.id.img_down);
        mZhifubaoPay = (RadioButton) mview.findViewById(R.id.zhifubao_pay);
        mRadio = (RadioGroup) mview.findViewById(R.id.radio);
        mBtnPay = (Button) mview.findViewById(R.id.btn_pay);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(seat,0,-300);
        img_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        if (format==null){
            Toast.makeText(this, "请先选择座位", Toast.LENGTH_SHORT).show();
            popupWindow.dismiss();
        }
        mWeixinPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnPay.setText("微信支付"+format+"元");
                weixinpay();
            }
        });
        mZhifubaoPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnPay.setText("支付宝支付"+format+"元");
                zhifubaopay();
            }
        });



    }

    private void zhifubaopay() {
        String userid = (String) SPFUtil.getInstance().getData("userid","");
        String s = userid +""+ id+"" + mount + "movie";
        String md5 = MD5Utils.MD5(s);
        HashMap<String,String> map = new HashMap<>();
        map.put("scheduleId",id+"");
        map.put("amount",mount+"");
        map.put("sign",md5);
        presenter.gettext(map);
        paytype = true;
    }

    private void weixinpay() {
        String userid = (String) SPFUtil.getInstance().getData("userid","");
        String s = userid +""+ id+"" + mount + "movie";
        String md5 = MD5Utils.MD5(s);
        HashMap<String,String> map = new HashMap<>();
        map.put("scheduleId",id+"");
        map.put("amount",mount+"");
        map.put("sign",md5);
        presenter.gettext(map);
        paytype = false;
    }


    @Override
    public void success(MovieTicket payBean) {
        Toast.makeText(this, ""+payBean.getMessage(), Toast.LENGTH_SHORT).show();
        orderId = payBean.getOrderId();
        if (paytype){
            HashMap<String,String> map1 = new HashMap<>();
            map1.put("payType",2+"");
            map1.put("orderId",orderId);
            presenter.getpaytext(map1);
        }else {
            HashMap<String,String> map1 = new HashMap<>();
            map1.put("payType",1+"");
            map1.put("orderId",orderId);
            presenter.getpaytext(map1);
        }
    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void paysuccess(final PayBean payBean) {
        if (paytype){
            Runnable payRunnable = new Runnable() {
                @Override
                public void run() {
                    // 构造PayTask 对象
                    PayTask alipay = new PayTask(XuanzuoActivity.this);
                    // 调用支付接口，获取支付结果
                    String pay = alipay.pay(payBean.getResult() + "", true);
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = pay;
                    mHandler.sendMessage(msg);
                }
            };
            Thread payThread = new Thread(payRunnable);
            payThread.start();


        }else {

            wxapi = WXAPIFactory.createWXAPI(this, APP_ID, true);
            //将应用的appId注册到微信
            wxapi.registerApp(APP_ID);
            //支付参数的传递
            PayReq request = new PayReq();
            request.appId = payBean.getAppId();
            request.partnerId = payBean.getPartnerId();
            request.prepayId= payBean.getPrepayId();
            request.packageValue = payBean.getPackageValue();
            request.nonceStr= payBean.getNonceStr();
            request.timeStamp= payBean.getTimeStamp();
            request.sign= payBean.getSign();
            //支付请求发送
            wxapi.sendReq(request);
        }
    }

    @Override
    public void payfailure(String msg) {

    }

    @Override
    public void BuyTicketRecordListsuccess(BuyTicketRecordListBean result) {

    }

    @Override
    public void BuyTicketRecordListfailure(String msg) {

    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    Toast.makeText(XuanzuoActivity.this, msg.obj + "", Toast.LENGTH_SHORT).show();
                    break;
                }
                default:
                    break;
            }
        }

    };


}
