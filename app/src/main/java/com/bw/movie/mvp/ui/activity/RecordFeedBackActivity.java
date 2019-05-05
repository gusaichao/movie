package com.bw.movie.mvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.jaeger.library.StatusBarUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordFeedBackActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContart.IUserInfoView {


    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.dui)
    ImageView dui;
    @BindView(R.id.fankui)
    RelativeLayout fankui;
    @BindView(R.id.user_advice)
    EditText userAdvice;
    @BindView(R.id.user_submission)
    TextView userSubmission;
    @BindView(R.id.advice_return)
    ImageView adviceReturn;

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
        return R.layout.activity_record_feed_back;
    }

    @Override
    public void UserInfoByUserIdsuccess(UserInfoByUserIdBean result) {

    }

    @Override
    public void modifyUserInfosuccess(ModifyUserInfoBean result) {

    }

    @Override
    public void modifyUserPwdsuccess(BaseBean result) {

    }

    @Override
    public void recordFeedBacksuccess(BaseBean result) {
        Toast.makeText(this, ""+result.getMessage(), Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.user_submission, R.id.advice_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_submission:
                String s = userAdvice.getText().toString();
                if (s.equals("")){
                    Toast.makeText(this, "请留下自己的意见", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String,String> map = new HashMap<>();
                map.put("content",s);
                presenter.getrecordFeedBack(map);

                break;
            case R.id.advice_return:
                finish();
                break;
        }
    }
}
