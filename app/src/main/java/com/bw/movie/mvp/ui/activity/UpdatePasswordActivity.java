package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.FindAllSysMsgListBean;
import com.bw.movie.bean.ModifyUserInfoBean;
import com.bw.movie.bean.NewVersionBean;
import com.bw.movie.bean.UserInfoByUserIdBean;
import com.bw.movie.mvp.contart.UserInfoContart;
import com.bw.movie.mvp.presneter.UserInfoPresenter;
import com.bw.movie.utils.EncryptUtil;
import com.jaeger.library.StatusBarUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdatePasswordActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContart.IUserInfoView {


    @BindView(R.id.oldpassword)
    EditText oldpassword;
    @BindView(R.id.newpassword)
    EditText newpassword;
    @BindView(R.id.newpassword2)
    EditText newpassword2;
    @BindView(R.id.myupdatepassword)
    TextView myupdatepassword;

    @Override
    protected void initData() {

    }

    @Override
    protected UserInfoPresenter providerPresenter() {
        return new UserInfoPresenter(this);
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        ButterKnife.bind(this);
    }

    @Override
    protected int providerLayoutId() {
        StatusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_update_password;
    }

    @OnClick(R.id.myupdatepassword)
    public void onViewClicked() {
        String oldpwd = EncryptUtil.encrypt(oldpassword.getText().toString());
        String newpwd = EncryptUtil.encrypt(newpassword.getText().toString());
        String newpwd2 = EncryptUtil.encrypt(newpassword2.getText().toString());
        if (oldpwd.equals("")&&newpwd.equals("")&&newpwd2.equals("")){
            Toast.makeText(this, "密码不能为空哦!", Toast.LENGTH_SHORT).show();
            return;
        }else if (newpwd.equals(newpwd2)){
        HashMap<String,String> map = new HashMap<>();
        map.put("oldPwd",oldpwd);
        map.put("newPwd",newpwd);
        map.put("newPwd2",newpwd2);
        presenter.getmodifyUserPwd(map);
        }else {
            Toast.makeText(this, "两次新密码要相同哦!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public void UserInfoByUserIdsuccess(UserInfoByUserIdBean result) {

    }

    @Override
    public void modifyUserInfosuccess(ModifyUserInfoBean result) {

    }

    @Override
    public void modifyUserPwdsuccess(BaseBean result) {
        Toast.makeText(this, ""+result.getMessage(), Toast.LENGTH_SHORT).show();
        if (result.getStatus().equals("0000")){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(UpdatePasswordActivity.this,LoginActivity.class);
                    intent.putExtra("message","请重新登陆");
                    startActivity(intent);
                }
            }, 2000);


        }
    }

    @Override
    public void recordFeedBacksuccess(BaseBean result) {

    }

    @Override
    public void findAllSysMsgListsuccess(FindAllSysMsgListBean result) {

    }

    @Override
    public void NewVersionsuccess(NewVersionBean result) {

    }

    @Override
    public void UserInfoByUserIdfaild(Throwable t) {

    }



}
