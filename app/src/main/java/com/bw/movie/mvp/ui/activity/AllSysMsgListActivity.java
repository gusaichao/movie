package com.bw.movie.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.FindAllSysMsgListBean;
import com.bw.movie.bean.ModifyUserInfoBean;
import com.bw.movie.bean.NewVersionBean;
import com.bw.movie.bean.UserInfoByUserIdBean;
import com.bw.movie.mvp.contart.UserInfoContart;
import com.bw.movie.mvp.presneter.UserInfoPresenter;
import com.bw.movie.mvp.ui.adapter.SystemAdapter;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllSysMsgListActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContart.IUserInfoView {


    @BindView(R.id.sysmsg_recy)
    RecyclerView sysmsgRecy;
    @BindView(R.id.user_return)
    ImageView userReturn;

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
        sysmsgRecy.setLayoutManager(new LinearLayoutManager(this));
        presenter.getfindAllSysMsgList("1", "10");
    }

    @Override
    protected int providerLayoutId() {
        StatusBarUtil.setTranslucentForImageView(this, null);
        return R.layout.activity_all_sys_msg_list;
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

    }

    @Override
    public void findAllSysMsgListsuccess(FindAllSysMsgListBean result) {
        SystemAdapter systemAdapter = new SystemAdapter(this, result.getResult());
        sysmsgRecy.setAdapter(systemAdapter);
    }

    @Override
    public void NewVersionsuccess(NewVersionBean result) {

    }

    @Override
    public void UserInfoByUserIdfaild(Throwable t) {

    }

    @OnClick(R.id.user_return)
    public void onViewClicked() {
        finish();
    }
}
