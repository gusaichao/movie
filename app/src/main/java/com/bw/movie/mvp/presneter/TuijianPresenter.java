package com.bw.movie.mvp.presneter;



import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.mvp.contart.TuijianContart;
import com.bw.movie.mvp.model.TuijianModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TuijianPresenter extends BasePresenter<TuijianContart.ICircleView> implements TuijianContart.ICirclepresenter {

    private TuijianModel circleModel;
    public TuijianPresenter(TuijianContart.ICircleView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        circleModel = new TuijianModel(this);
    }
    public void getKeyorNum(String page,String count){
        circleModel.getCircleModel(page, count);
    }

    public void getcidKeyorNum(String cinemaId){
        circleModel.getguanzhuModel(cinemaId);
    }
    public void getquxiaocidKeyorNum(String cinemaId){
        circleModel.getquxiaoModel(cinemaId);
    }
    @Override
    public void getCirclePresenter(Observable<TuijianBean> Circlebean) {
        Circlebean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuijianBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuijianBean CircleBean) {
                        if (CircleBean!=null){
                            view.success(CircleBean);
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
    public void getguanzhuPresenter(Observable<TuijianBean> guanzhubean) {
        guanzhubean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuijianBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuijianBean CircleBean) {
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
    public void getquxiaoPresenter(Observable<TuijianBean> quxiaobean) {
        quxiaobean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuijianBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TuijianBean CircleBean) {
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
