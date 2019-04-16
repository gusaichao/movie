package com.bw.movie.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.mvp.contart.IloginContart;
import com.bw.movie.mvp.presneter.LoginPresenter;
import com.bw.movie.mvp.ui.activity.HomeActivity;
import com.bw.movie.utils.SPFUtil;
import com.bw.movie.utils.WeiXinUtil;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import java.util.HashMap;

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler,IloginContart.ILoginView {
    private LoginPresenter loginPresenter;
    private String code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeiXinUtil.reg(WXEntryActivity.this).handleIntent(getIntent(),this);
    }
    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(final BaseResp baseResp) {
        switch (baseResp.errCode){
            case BaseResp.ErrCode.ERR_OK:
                code = ((SendAuth.Resp) baseResp).code;
                //p层请求加入参数code值
                loginPresenter = new LoginPresenter(this);
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("code",code);
                loginPresenter.getweixinLoginPresenter(hashMap);
                break;
            default:
                break;
        }
    }
    @Override
    public void success(String result) {

    }

    @Override
    public void faild(String t) {

    }

    @Override
    public void weixinsuccess(String result) {
        LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
        if (loginBean.getStatus().equals("0000")){
            int userid = loginBean.getResult().getUserId();
            String sessionid = loginBean.getResult().getSessionId();
            SPFUtil.getInstance().saveData("sessionid", sessionid);
            SPFUtil.getInstance().saveData("userid", userid + "");
            Intent intent = new Intent(WXEntryActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void weixinfaild(String t) {

    }
}
