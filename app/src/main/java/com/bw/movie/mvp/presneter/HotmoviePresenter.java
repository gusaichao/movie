package com.bw.movie.mvp.presneter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.ComingBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.NowshowBean;
import com.bw.movie.mvp.contart.HotmovieContart;
import com.bw.movie.mvp.model.HotmovieModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HotmoviePresenter extends BasePresenter<HotmovieContart.IHotmovieView> implements HotmovieContart.IHotmoviepresenter {

    private HotmovieModel hotmovieModel;
    public HotmoviePresenter(HotmovieContart.IHotmovieView view) {
        super(view);
    }

    @Override
    protected void initModel() {
        hotmovieModel = new HotmovieModel(this);
    }
    public void getKeyorNum(String page,String count){
        hotmovieModel.getHotmovieModel(page, count);

    }
    public void getKeyorNum2(String page,String count){
        hotmovieModel.getHotmovie2Model(page, count);

    }
    public void getKeyorNum3(String page,String count){
        hotmovieModel.getHotmovie3Model(page, count);

    }
    @Override
    public void getHotmoviePresenter(Observable<HotmovieBean> Hotmoviebean) {
        Hotmoviebean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotmovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotmovieBean HotmovieBean) {
                        if (HotmovieBean!=null){
                            view.success(HotmovieBean);
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
    public void getHotmovie2Presenter(Observable<NowshowBean> Hotmoviebean) {
        Hotmoviebean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NowshowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NowshowBean HotmovieBean) {
                        if (HotmovieBean!=null){
                            view.success2(HotmovieBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.faild2(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getHotmovie3Presenter(Observable<ComingBean> Hotmoviebean) {
        Hotmoviebean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ComingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ComingBean HotmovieBean) {
                        if (HotmovieBean!=null){
                            view.success3(HotmovieBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.faild3(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
