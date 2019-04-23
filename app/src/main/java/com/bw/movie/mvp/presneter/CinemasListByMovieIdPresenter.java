package com.bw.movie.mvp.presneter;



import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.FujinBean;
import com.bw.movie.mvp.contart.CinemasListByMovieIdContart;
import com.bw.movie.mvp.contart.FujinContart;
import com.bw.movie.mvp.model.CinemasListByMovieIdModel;
import com.bw.movie.mvp.model.FujinModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CinemasListByMovieIdPresenter extends BasePresenter<CinemasListByMovieIdContart.ICinemasListByMovieIdView>
        implements CinemasListByMovieIdContart.ICinemasListByMovieIdpresenter {

    private CinemasListByMovieIdModel cinemasListByMovieIdModel;
    public CinemasListByMovieIdPresenter(CinemasListByMovieIdContart.ICinemasListByMovieIdView view) {
        super(view);
    }

    public void getKeyorNum(String movieId){
        cinemasListByMovieIdModel.getCinemasListByMovieIdModel(movieId);
    }


    @Override
    protected void initModel() {
        cinemasListByMovieIdModel = new CinemasListByMovieIdModel(this);
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
                        view.success(cinemasListByMovieIdBean);
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
