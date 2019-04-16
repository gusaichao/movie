package com.bw.movie.mvp.contart;



import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.mvp.model.RegisterModel;

import java.util.HashMap;

import io.reactivex.Observable;

public interface IRegisterContart {

    abstract class IRegisterprasenter{
        public abstract void  Registerlist(HashMap<String,String>params);
    }


    interface IRegistermodel{
        void Registerlist(HashMap<String,String>params, RegisterModel.IRegisterModelCallback callback);
    }

    interface IRegisterView extends IBaseView {
        void success(String result);
        void failure(String msg);
    }

}
