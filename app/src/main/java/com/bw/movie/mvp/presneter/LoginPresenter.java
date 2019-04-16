package com.bw.movie.mvp.presneter;



import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.mvp.contart.IloginContart;
import com.bw.movie.mvp.model.LoginModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends IloginContart.ILoginpresenter {

    private LoginModel loginModel;
    private IloginContart.ILoginView iLoginView;

    public LoginPresenter(IloginContart.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        loginModel = new LoginModel();
    }

    @Override
    public void getLoginPresenter(HashMap<String, String> params) {
        loginModel.getLoginModel(params, new LoginModel.ILoginModelCallback() {
            @Override
            public void success(String result) {
                iLoginView.success(result);
            }

            @Override
            public void failure(String msg) {
                iLoginView.faild(msg);
            }
        });
    }

    @Override
    public void getweixinLoginPresenter(HashMap<String, String> params) {
        loginModel.getweixinLoginModel(params, new LoginModel.ILoginModelCallback() {
            @Override
            public void success(String result) {
                iLoginView.weixinsuccess(result);
            }

            @Override
            public void failure(String msg) {
                iLoginView.weixinfaild(msg);
            }
        });
    }
}
