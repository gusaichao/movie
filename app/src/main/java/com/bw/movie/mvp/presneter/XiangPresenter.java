package com.bw.movie.mvp.presneter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.model.XiangModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class XiangPresenter extends BasePresenter<XiangContart.IXiangtopView> implements XiangContart.IXiangtoppresenter {

    private XiangModel PopModel;

    public XiangPresenter(XiangContart.IXiangtopView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        PopModel = new XiangModel(this);
    }

    public void getKeyorNum(String firstCategoryId){
        PopModel.getXiangModel(firstCategoryId);
    }


    @Override
    public void getXiangPresenter(Observable<XiangBean> xiangbean) {
        xiangbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XiangBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XiangBean registerBean) {
                       if (registerBean!=null){
                            view.success(registerBean);
                       }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.faild(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
