package com.bw.movie.mvp.contart;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.XiangBean;

import io.reactivex.Observable;

public interface XiangContart {

    interface IXiangtoppresenter{
        void getXiangPresenter(Observable<XiangBean> Xiangbean);

    }

    interface IXiangtopmodel{
        void getXiangModel(String commodityId);
    }

    interface IXiangtopView extends IBaseView {
        void success(XiangBean resultBean);
        void faild(Throwable t);
    }

}
