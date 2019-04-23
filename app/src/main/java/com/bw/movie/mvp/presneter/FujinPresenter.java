package com.bw.movie.mvp.presneter;



import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.FujinBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.mvp.contart.FujinContart;
import com.bw.movie.mvp.contart.TuijianContart;
import com.bw.movie.mvp.model.FujinModel;
import com.bw.movie.mvp.model.TuijianModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FujinPresenter extends BasePresenter<FujinContart.IfujinView> implements FujinContart.IFujinpresenter {

    private FujinModel circleModel;
    public FujinPresenter(FujinContart.IfujinView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        circleModel = new FujinModel(this);
    }
    public void getKeyorNum(String page, String count,String longitude,String latitude){
        circleModel.getfujinModel(page, count, longitude, latitude);
    }

    @Override
    public void getfujinPresenter(Observable<FujinBean> Circlebean) {
        Circlebean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FujinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FujinBean CircleBean) {
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

}
