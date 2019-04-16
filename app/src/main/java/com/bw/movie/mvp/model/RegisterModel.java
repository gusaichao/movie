package com.bw.movie.mvp.model;

import com.bw.movie.bean.RegisterBean;
import com.bw.movie.mvp.contart.IRegisterContart;
import com.bw.movie.mvp.presneter.RegisterPresenter;
import com.bw.movie.utils.OkHttpCallBack;
import com.bw.movie.utils.OkHttpUtils;
import com.bw.movie.utils.RetrofitUtils;
import com.bw.movie.utils.WeiduBaseApi;

import java.util.HashMap;

import io.reactivex.Observable;

public class RegisterModel implements IRegisterContart.IRegistermodel {


    @Override
    public void Registerlist(HashMap<String, String> params, final RegisterModel.IRegisterModelCallback callback) {
        String api = WeiduBaseApi.BASE_URL+"user/v1/registerUser";
        OkHttpUtils.getInstance().dopost(api, params, new OkHttpCallBack() {
            @Override
            public void Success(String result) {
                callback.success(result);
            }

            @Override
            public void failure(String msg) {
                callback.failure(msg);
            }
        });
    }


    public interface IRegisterModelCallback{
        void success(String result);
        void failure(String msg);
    }
}
