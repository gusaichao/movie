package com.bw.movie.mvp.presneter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.mvp.contart.IRegisterContart;
import com.bw.movie.mvp.model.RegisterModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter extends IRegisterContart.IRegisterprasenter {

    private IRegisterContart.IRegisterView iRegisterView;
    private RegisterModel registerModel;

    public RegisterPresenter(IRegisterContart.IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        registerModel = new RegisterModel();
    }

    @Override
    public void Registerlist(HashMap<String, String> params) {
        registerModel.Registerlist(params, new RegisterModel.IRegisterModelCallback() {
            @Override
            public void success(String result) {
                iRegisterView.success(result);
            }

            @Override
            public void failure(String msg) {
                iRegisterView.failure(msg);
            }
        });
    }
}
