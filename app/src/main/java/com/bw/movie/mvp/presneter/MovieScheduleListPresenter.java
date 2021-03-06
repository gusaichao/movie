package com.bw.movie.mvp.presneter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.XiangBean;
import com.bw.movie.mvp.contart.MovieScheduleListContart;
import com.bw.movie.mvp.contart.XiangContart;
import com.bw.movie.mvp.model.MovieScheduleListModel;
import com.bw.movie.mvp.model.XiangModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieScheduleListPresenter extends BasePresenter<MovieScheduleListContart.IMovieScheduleListView> implements MovieScheduleListContart.IMovieScheduleListpresenter {

    private MovieScheduleListModel PopModel;

    public MovieScheduleListPresenter(MovieScheduleListContart.IMovieScheduleListView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        PopModel = new MovieScheduleListModel(this);
    }

    public void getKeyorNum(String firstCategoryId){
        PopModel.getXiangModel(firstCategoryId);
    }

    public void getMovieScheduleList(String movieId,String cinemasId){
        PopModel.getMovieScheduleListModel(movieId,cinemasId);
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
    public void getMovieScheduleListPresenter(Observable<MovieScheduleListBean> cinemasListByMovieIdbean) {
        cinemasListByMovieIdbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieScheduleListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieScheduleListBean cinemasListByMovieIdBean) {
                        view.MovieScheduleListsuccess(cinemasListByMovieIdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.MovieScheduleListfaild(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
