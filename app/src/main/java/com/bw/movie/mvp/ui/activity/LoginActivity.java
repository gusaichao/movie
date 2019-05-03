package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.mvp.contart.IloginContart;
import com.bw.movie.mvp.presneter.LoginPresenter;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.utils.SPFUtil;
import com.bw.movie.utils.WeiXinUtil;
import com.google.gson.Gson;
import com.jaeger.library.StatusBarUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements IloginContart.ILoginView {

    @BindView(R.id.login_image_bg)
    ImageView loginImageBg;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.show_pwd)
    ImageView showPwd;
    @BindView(R.id.fly_reg)
    TextView flyReg;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.che_pwd)
    CheckBox chePwd;
    @BindView(R.id.weixinlogin)
    ImageView weixinlogin;

    private LoginPresenter loginPresenter;
    private Boolean isYeye;
    private StatusBarUtil statusBarUtil;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarUtil.setTranslucentForImageView(this, loginImageBg);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        initView();
    }

    private void initView() {
        loginPresenter = new LoginPresenter(this);
        sp = getSharedPreferences("Login", MODE_PRIVATE);
        if (sp.getBoolean("ischeck", false)) {
            chePwd.setChecked(true);
            String phone = sp.getString("phone", "");
            String pwd = sp.getString("pwd", "");
            edPhone.setText(phone);
            edPwd.setText(pwd);
        }
    }

    @Override
    public void success(String result) {
        LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
        if (loginBean.getMessage().equals("登陆成功")) {
            Toast.makeText(this, "" + loginBean.getMessage(), Toast.LENGTH_SHORT).show();

            int userid = loginBean.getResult().getUserId();
            String sessionid = loginBean.getResult().getSessionId();
            SPFUtil.getInstance().saveData("sessionid", sessionid);
            SPFUtil.getInstance().saveData("userid", userid + "");
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "" + loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void faild(String t) {

    }

    @Override
    public void weixinsuccess(String result) {

    }

    @Override
    public void weixinfaild(String t) {

    }

    @OnClick(R.id.show_pwd)
    public void showPwd() {
        isYeye = true;
        showPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isYeye) {
                    edPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    isYeye = false;
                } else {
                    edPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    isYeye = true;
                }
            }
        });
    }

    @OnClick({R.id.fly_reg, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fly_reg:
                kuaisuReg();
                break;
            case R.id.login:
                denglu();
                break;
        }
    }

    private void denglu() {
        String edphone = edPhone.getText().toString().trim();
        String edpwd = edPwd.getText().toString();
        String encrypt = EncryptUtil.encrypt(edpwd);
        HashMap<String, String> params = new HashMap<>();
        params.put("phone", edphone);
        params.put("pwd", encrypt);
        if (chePwd.isChecked()) {
            sp.edit().putString("phone", edphone).putString("pwd", edpwd).putBoolean("ischeck", true).commit();
        } else {
            sp.edit().putBoolean("ischeck", false).commit();
        }
        loginPresenter.getLoginPresenter(params);
    }

    private void kuaisuReg() {
        Intent intent = new Intent(LoginActivity.this, RegActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.weixinlogin)
    public void onViewClicked() {
        // 微信登录
        if (!WeiXinUtil.success(this)) {
            Toast.makeText(this, "请先安装应用", Toast.LENGTH_SHORT).show();
        } else {
            //  验证
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            req.state = "wechat_sdk_demo_test";
            WeiXinUtil.reg(LoginActivity.this).sendReq(req);
        }
    }
}
