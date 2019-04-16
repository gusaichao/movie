package com.bw.movie.mvp.model;



import android.util.Log;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.mvp.contart.IloginContart;
import com.bw.movie.mvp.presneter.LoginPresenter;
import com.bw.movie.utils.OkHttpCallBack;
import com.bw.movie.utils.OkHttpUtils;
import com.bw.movie.utils.RetrofitUtils;
import com.bw.movie.utils.WeiduBaseApi;

import java.util.HashMap;

import io.reactivex.Observable;

import static com.bw.movie.utils.WeiduBaseApi.BASE_URL;

public class LoginModel implements IloginContart.ILoginmodel {


    @Override
    public void getLoginModel(HashMap<String, String> params, final ILoginModelCallback iLoginModelCallback) {
        String api = WeiduBaseApi.BASEWAI_URL+"user/v1/login";
        OkHttpUtils.getInstance().dopost(api, params, new OkHttpCallBack() {
            @Override
            public void Success(String result) {
                iLoginModelCallback.success(result);
            }

            @Override
            public void failure(String msg) {
                iLoginModelCallback.failure(msg);
            }
        });
    }

    @Override
    public void getweixinLoginModel(HashMap<String, String> params, final ILoginModelCallback iLoginModelCallback) {
        String api = WeiduBaseApi.BASEWAI_URL+"user/v1/weChatBindingLogin";
        OkHttpUtils.getInstance().dopost(api, params, new OkHttpCallBack() {
            @Override
            public void Success(String result) {
                iLoginModelCallback.success(result);
            }

            @Override
            public void failure(String msg) {
                iLoginModelCallback.failure(msg);
            }
        });
    }

    public interface ILoginModelCallback{
        void success(String result);
        void failure(String msg);
    }
}
