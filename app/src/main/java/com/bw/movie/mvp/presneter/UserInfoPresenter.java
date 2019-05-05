package com.bw.movie.mvp.presneter;

import android.annotation.SuppressLint;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.FindAllSysMsgListBean;
import com.bw.movie.bean.ModifyUserInfoBean;
import com.bw.movie.bean.NewVersionBean;
import com.bw.movie.bean.UserInfoByUserIdBean;
import com.bw.movie.mvp.contart.UserInfoContart;
import com.bw.movie.mvp.model.UserInfoModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UserInfoPresenter extends BasePresenter<UserInfoContart.IUserInfoView> implements UserInfoContart.IUserInfopresenter {

    private UserInfoModel userInfoModel;

    public UserInfoPresenter(UserInfoContart.IUserInfoView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        userInfoModel = new UserInfoModel(this);
    }

    public void getUserInfoByUserId(){
        userInfoModel.getUserInfoByUserIdModel();
    }
    public void getmodifyUserInfo(HashMap<String,String> map){
        userInfoModel.getmodifyUserInfoModel(map);
    }
    public void getmodifyUserPwd(HashMap<String,String> map){
        userInfoModel.getmodifyUserPwdModel(map);
    }
    public void getrecordFeedBack(HashMap<String,String> map){
        userInfoModel.getrecordFeedBackPwdModel(map);
    }
    public void getfindAllSysMsgList(String page,String count){
        userInfoModel.getfindAllSysMsgListModel(page, count);
    }
    public void getNewVersion(String ak){
        userInfoModel.getNewVersionModel(ak);
    }

    @Override
    public void getUserInfoByUserIdPresenter(Observable<UserInfoByUserIdBean> userIdBean) {
        userIdBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserInfoByUserIdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onComplete() {

                    }
                    @Override
                    public void onNext(UserInfoByUserIdBean userInfoByUserIdBean) {
                        view.UserInfoByUserIdsuccess(userInfoByUserIdBean);
                    }
                });
    }

    @Override
    public void getmodifyUserInfoPresenter(Observable<ModifyUserInfoBean> modifyUserInfoBean) {
        modifyUserInfoBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ModifyUserInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ModifyUserInfoBean modifyUserInfoBean) {
                        view.modifyUserInfosuccess(modifyUserInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getmodifyUserPwdPresenter(Observable<BaseBean> baseBean) {
        baseBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        view.modifyUserPwdsuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getrecordFeedBackPresenter(Observable<BaseBean> baseBean) {
        baseBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        view.recordFeedBacksuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getfindAllSysMsgListPresenter(Observable<FindAllSysMsgListBean> baseBean) {
        baseBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindAllSysMsgListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindAllSysMsgListBean baseBean) {
                        view.findAllSysMsgListsuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getNewVersionPresenter(Observable<NewVersionBean> newVersionBean) {
        newVersionBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewVersionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewVersionBean baseBean) {
                        view.NewVersionsuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
