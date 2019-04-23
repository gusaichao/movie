package com.bw.movie.mvp.presneter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.model.XiangModel;

import java.util.HashMap;
import java.util.jar.Manifest;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
    public void getpingKeyorNum(String page, String count,String firstCategoryId){
        PopModel.getpingModel(page,count,firstCategoryId);
    }
    public void getCinemasListByMovieId(String movieId){
        PopModel.getCinemasListByMovieIdModel(movieId);
    }
    public void gettext(HashMap<String,String> map){
        PopModel.addpinglist(map);
    }

    public void getguanzhuKeyorNum(String cinemaId){
        PopModel.getguanzhuModel(cinemaId);
    }
    public void getquxiaocidKeyorNum(String cinemaId){
        PopModel.getquxiaoModel(cinemaId);
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

    @Override
    public void getpingPresenter(Observable<PingBean> piangbean) {
        piangbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PingBean registerBean) {
                        if (registerBean!=null){
                            view.pingsuccess(registerBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.pingfaild(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCinemasListByMovieIdPresenter(Observable<CinemasListByMovieIdBean> cinemasListByMovieIdbean) {
        cinemasListByMovieIdbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemasListByMovieIdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemasListByMovieIdBean cinemasListByMovieIdBean) {
                        view.CinemasListByMovieIdsuccess(cinemasListByMovieIdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.CinemasListByMovieIdfaild(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void addpinglist(Observable<BaseBean> addping) {
        addping.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean>() {
                    @Override
                    public void accept(BaseBean baseBean) throws Exception {
                        view.addpingsuccess(baseBean.getMessage());
                    }
                });
    }
    @Override
    public void getguanzhuPresenter(Observable<BaseBean> guanzhubean) {
        guanzhubean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean CircleBean) {
                        if (CircleBean!=null){
                            view.guanzhusuccess(CircleBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.guanzhufaild(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getquxiaoPresenter(Observable<BaseBean> quxiaobean) {
        quxiaobean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean CircleBean) {
                        if (CircleBean!=null){
                            view.quxiaosuccess(CircleBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.quxiaofaild(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
