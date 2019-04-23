package com.bw.movie.mvp.presneter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.CinemaPageListBean;
import com.bw.movie.bean.MoviePageListBean;
import com.bw.movie.mvp.contart.CinemaPageListContart;
import com.bw.movie.mvp.model.CinemaPageListModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CinemaPageListPresenter extends BasePresenter<CinemaPageListContart.CinemaPageListView>
        implements CinemaPageListContart.CinemaPageListprasenter {

    private CinemaPageListModel CinemaPageListModel;
    public CinemaPageListPresenter(CinemaPageListContart.CinemaPageListView view) {
        super(view);
    }

    public void gettext(String page,String count){
        CinemaPageListModel.CinemaPageListlist(page, count);
    }
    public void getMoviePageList(String page,String count){
        CinemaPageListModel.MoviePageListlist(page, count);
    }
    @Override
    public void CinemaPageListlist(Observable<CinemaPageListBean> CinemaPageList) {
        CinemaPageList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CinemaPageListBean>() {
                    @Override
                    public void accept(CinemaPageListBean baseBean) throws Exception {
                        view.success(baseBean);
                    }
                });
    }

    @Override
    public void MoviePageListlist(Observable<MoviePageListBean> MoviePageList) {
        MoviePageList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviePageListBean>() {
                    @Override
                    public void accept(MoviePageListBean moviePageListBean) throws Exception {
                        view.MoviePageListsuccess(moviePageListBean);
                    }
                });
    }

    @Override
    protected void initModel() {
        CinemaPageListModel = new CinemaPageListModel(this);
    }
}
