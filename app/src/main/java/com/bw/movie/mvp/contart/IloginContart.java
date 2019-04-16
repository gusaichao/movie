package com.bw.movie.mvp.contart;



import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.mvp.model.LoginModel;

import java.util.HashMap;


public interface IloginContart {

    abstract class ILoginpresenter{
         public abstract void getLoginPresenter(HashMap<String,String> params);
         public abstract void getweixinLoginPresenter(HashMap<String,String> params);
    }

    interface ILoginmodel{
        void getLoginModel(HashMap<String,String> params, LoginModel.ILoginModelCallback iLoginModelCallback);
        void getweixinLoginModel(HashMap<String,String> params, LoginModel.ILoginModelCallback iLoginModelCallback);
    }

    interface ILoginView extends IBaseView {
        void success(String result);
        void faild(String t);
        void weixinsuccess(String result);
        void weixinfaild(String t);
    }

}
