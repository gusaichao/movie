package com.bw.movie.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.FindAllSysMsgListBean;
import com.bw.movie.bean.ModifyUserInfoBean;
import com.bw.movie.bean.NewVersionBean;
import com.bw.movie.bean.UserInfoByUserIdBean;
import com.bw.movie.mvp.contart.UserInfoContart;
import com.bw.movie.mvp.presneter.UserInfoPresenter;
import com.bw.movie.utils.TimeUtils;
import com.jaeger.library.StatusBarUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInfoByUserIdActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContart.IUserInfoView {
    @BindView(R.id.message)
    TextView mMessage;
    @BindView(R.id.my_edit)
    TextView mMyEdit;
    @BindView(R.id.user_head)
    ImageView mUserHead;
    @BindView(R.id.user_nickName)
    TextView mUserNickName;
    @BindView(R.id.user_edit_nickName)
    EditText mUserEditNickName;
    @BindView(R.id.user_sex)
    TextView mUserSex;
    @BindView(R.id.user_edit_sex)
    EditText mUserEditSex;
    @BindView(R.id.user_birthday)
    TextView mUserBirthday;
    @BindView(R.id.user_phone)
    TextView mUserPhone;
    @BindView(R.id.user_mail)
    TextView mUserMail;
    @BindView(R.id.user_edit_mail)
    EditText mUserEditMail;
    @BindView(R.id.update_password)
    LinearLayout mUpdatePassword;
    @BindView(R.id.keepUpdate)
    TextView mKeepUpdate;
    @BindView(R.id.user_return)
    ImageView mUserReturn;
    String mysex;

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
        presenter.getUserInfoByUserId();
    }

    @Override
    protected int providerLayoutId() {
        StatusBarUtil.setTranslucentForImageView(this,null);
        return R.layout.activity_user_info_by_user_id;
    }

    @Override
    public void UserInfoByUserIdsuccess(UserInfoByUserIdBean result1) {
        UserInfoByUserIdBean.ResultBean result = result1.getResult();
        Glide.with(this).load(result.getHeadPic()).into(mUserHead);
        mUserNickName.setText(result.getNickName());
        mUserEditNickName.setText(result.getNickName());
        mUserEditMail.setText(result.getEmail());
        mUserMail.setText(result.getEmail());
        mUserPhone.setText(result.getPhone());
        long birthday = result.getBirthday();
        String s = TimeUtils.stampToDate(birthday);
        mUserBirthday.setText(s);
        int sex = result.getSex();
        if (sex == 1) {
            mysex = "男";
        } else {
            mysex = "女";
        }
        mUserSex.setText(mysex);
        mUserEditSex.setText(mysex + "");
    }

    @Override
    public void modifyUserInfosuccess(ModifyUserInfoBean result) {
        Toast.makeText(this, ""+result.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void modifyUserPwdsuccess(BaseBean result) {

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

    @OnClick({R.id.my_edit, R.id.update_password, R.id.keepUpdate, R.id.user_return})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.my_edit:
                mUserEditMail.setVisibility(View.VISIBLE);
                mUserEditNickName.setVisibility(View.VISIBLE);
                mUserEditSex.setVisibility(View.VISIBLE);
                mKeepUpdate.setVisibility(View.VISIBLE);
                mUserMail.setVisibility(View.GONE);
                mUserNickName.setVisibility(View.GONE);
                mUserSex.setVisibility(View.GONE);
                break;
            case R.id.update_password:
                Intent intent = new Intent(this,UpdatePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.keepUpdate:
                String mail = mUserEditMail.getText().toString();
                String xiugainame = mUserEditNickName.getText().toString();
                String asex = mUserEditSex.getText().toString();
                if (mail.equals("")||xiugainame.equals("")||asex.equals("")){
                    Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (asex.equals("1")||asex.equals("男")){
                    asex="1";
                }else if(asex.equals("2")||asex.equals("女")){
                    asex="2";
                }
                HashMap<String, String> map = new HashMap<>();
                map.put("nickName",xiugainame);
                map.put("sex",asex);
                map.put("email",mail);
                presenter.getmodifyUserInfo(map);
                mUserMail.setText(mail);
                if (asex.equals("1")||asex.equals("男")){
                    asex="男";
                }else if(asex.equals("2")||asex.equals("女")){
                    asex="女";
                }
                mUserSex.setText(asex);
                mUserNickName.setText(xiugainame);
                mUserEditMail.setVisibility(View.GONE);
                mUserEditNickName.setVisibility(View.GONE);
                mUserEditSex.setVisibility(View.GONE);
                mKeepUpdate.setVisibility(View.GONE);
                mUserMail.setVisibility(View.VISIBLE);
                mUserNickName.setVisibility(View.VISIBLE);
                mUserSex.setVisibility(View.VISIBLE);
                break;
            case R.id.user_return:
                finish();
                break;
        }
    }

}
