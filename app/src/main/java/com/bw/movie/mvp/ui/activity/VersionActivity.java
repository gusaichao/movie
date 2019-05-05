package com.bw.movie.mvp.ui.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.bw.movie.utils.VersionUtil;

public class VersionActivity extends BaseActivity<UserInfoPresenter> implements UserInfoContart.IUserInfoView {

    private int versionCode;


    @Override
    protected void initData() {

    }

    @Override
    protected UserInfoPresenter providerPresenter() {
        return new UserInfoPresenter(this);
    }

    @Override
    protected void initView() {

        PackageManager manager = getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
            versionCode = info.versionCode;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        presenter.getNewVersion(versionCode+"");
    }

    @Override
    protected int providerLayoutId() {
        return R.layout.activity_version;
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

    }

    @Override
    public void NewVersionsuccess(NewVersionBean result) {
        if (result.getStatus().equals("0000")){
            if (result==null){
                Toast.makeText(this, ""+result.getMessage(), Toast.LENGTH_SHORT).show();
            }else {
                int flag=result.getFlag();
                if (flag==1){
                    VersionUtil.openBrowser(this,result.getDownloadUrl());
                }else {
                    Toast.makeText(this, "已是最新版本", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void UserInfoByUserIdfaild(Throwable t) {

    }
}
