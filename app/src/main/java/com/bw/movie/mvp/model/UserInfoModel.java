package com.bw.movie.mvp.model;

import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.FindAllSysMsgListBean;
import com.bw.movie.bean.ModifyUserInfoBean;
import com.bw.movie.bean.NewVersionBean;
import com.bw.movie.bean.UserInfoByUserIdBean;
import com.bw.movie.mvp.contart.UserInfoContart;
import com.bw.movie.mvp.presneter.UserInfoPresenter;
import com.bw.movie.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;

public class UserInfoModel implements UserInfoContart.IUserInfomodel {

    private UserInfoPresenter userInfoPresenter;
    public UserInfoModel(UserInfoPresenter userInfoPresenter) {
        this.userInfoPresenter = userInfoPresenter;
    }

    @Override
    public void getUserInfoByUserIdModel() {
        Observable<UserInfoByUserIdBean> userInfoByUserIdBeanObservable = RetrofitUtils.getInstance().getservice().UserInfoByUserIdData();
        userInfoPresenter.getUserInfoByUserIdPresenter(userInfoByUserIdBeanObservable);
    }

    @Override
    public void getmodifyUserInfoModel(HashMap<String,String>map) {
        Observable<ModifyUserInfoBean> modifyUserInfoBeanObservable = RetrofitUtils.getInstance().getservice().modifyUserInfoData(map);
        userInfoPresenter.getmodifyUserInfoPresenter(modifyUserInfoBeanObservable);
    }

    @Override
    public void getmodifyUserPwdModel(HashMap<String, String> map) {
        Observable<BaseBean> baseBeanObservable = RetrofitUtils.getInstance().getservice().modifyUserPwdData(map);
        userInfoPresenter.getmodifyUserPwdPresenter(baseBeanObservable);
    }

    @Override
    public void getrecordFeedBackPwdModel(HashMap<String, String> map) {
        Observable<BaseBean> baseBeanObservable = RetrofitUtils.getInstance().getservice().recordFeedBackData(map);
        userInfoPresenter.getrecordFeedBackPresenter(baseBeanObservable);
    }

    @Override
    public void getfindAllSysMsgListModel(String page, String count) {
        Observable<FindAllSysMsgListBean> allSysMsgListData = RetrofitUtils.getInstance().getservice().findAllSysMsgListData(page, count);
        userInfoPresenter.getfindAllSysMsgListPresenter(allSysMsgListData);
    }

    @Override
    public void getNewVersionModel(String ak) {
        Observable<NewVersionBean> newVersionBeanObservable = RetrofitUtils.getInstance().getservice().NewVersionData(ak);
        userInfoPresenter.getNewVersionPresenter(newVersionBeanObservable);
    }
}
