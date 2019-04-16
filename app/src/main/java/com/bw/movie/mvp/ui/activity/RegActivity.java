package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.mvp.contart.IRegisterContart;
import com.bw.movie.mvp.presneter.RegisterPresenter;
import com.bw.movie.utils.EncryptUtil;
import com.google.gson.Gson;
import com.jaeger.library.StatusBarUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegActivity extends AppCompatActivity implements IRegisterContart.IRegisterView {
    @BindView(R.id.reg_imagebg)
    ImageView regImagebg;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.sex)
    EditText sex;
    @BindView(R.id.data)
    EditText data;
    @BindView(R.id.mobile)
    EditText mobile;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.Regg)
    Button Regg;
    private StatusBarUtil statusBarUtil;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarUtil.setTranslucentForImageView(this, regImagebg);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        registerPresenter = new RegisterPresenter(this);
    }

    @OnClick(R.id.Regg)
    public void onViewClicked() {

        String name = this.name.getText().toString();
        String sex = this.sex.getText().toString();
        String data = this.data.getText().toString();
        String mobile = this.mobile.getText().toString();
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        String encrypt = EncryptUtil.encrypt(password);
        HashMap<String,String> params = new HashMap<>();
        params.put("nickName",name);
        params.put("sex",sex);
        params.put("birthday",data);
        params.put("phone",mobile+"");
        params.put("email",email);
        params.put("pwd",encrypt);
        params.put("pwd2",encrypt);

        Log.e("phone",mobile);
        Log.e("nickName",name);
        Log.e("sex",sex);
        Log.e("birthday",data);
        Log.e("pwd",encrypt);
        Log.e("pwd2",encrypt);
        registerPresenter.Registerlist(params);
    }


    @Override
    public void success(String result) {
//        Toast.makeText(this, ""+name+sex+data+mobile+email, Toast.LENGTH_SHORT).show();
        RegisterBean registerBean = new Gson().fromJson(result, RegisterBean.class);

        if (registerBean.getMessage().equals("注册成功")){
            Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, registerBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void failure(String msg) {

    }

}
