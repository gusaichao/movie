package com.bw.movie.mvp.contart;



import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.mvp.model.RegisterModel;

import java.util.HashMap;

import io.reactivex.Observable;

public interface AddpingContart {

    interface Addpingprasenter{
        void addpinglist(Observable<BaseBean> addping);
    }


    interface Addpingmodel{
        void addpinglist(HashMap<String, String> params);
    }

    interface AddpingView extends IBaseView {
        void success(String result);
        void failure(String msg);
    }

}
