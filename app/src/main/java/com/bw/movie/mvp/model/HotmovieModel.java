package com.bw.movie.mvp.model;

import com.bw.movie.bean.ComingBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.NowshowBean;
import com.bw.movie.mvp.contart.HotmovieContart;
import com.bw.movie.mvp.presneter.HotmoviePresenter;
import com.bw.movie.utils.RetrofitUtils;

import io.reactivex.Observable;

public class HotmovieModel implements HotmovieContart.IHotmoviemodel {

    private HotmoviePresenter hotmoviePresenter;

    public HotmovieModel(HotmoviePresenter hotmoviePresenter) {
        this.hotmoviePresenter = hotmoviePresenter;
    }

    @Override
    public void getHotmovieModel(String page, String count) {
        Observable<HotmovieBean> HotmovieData = RetrofitUtils.getInstance().getservice().hotmovieData(page, count);
        hotmoviePresenter.getHotmoviePresenter(HotmovieData);
    }

    @Override
    public void getHotmovie2Model(String key, String num) {
        Observable<NowshowBean> HotmovieData = RetrofitUtils.getInstance().getservice().nowshowData(key, num);
        hotmoviePresenter.getHotmovie2Presenter(HotmovieData);
    }

    @Override
    public void getHotmovie3Model(String key, String num) {
        Observable<ComingBean> HotmovieData = RetrofitUtils.getInstance().getservice().comingData(key, num);
        hotmoviePresenter.getHotmovie3Presenter(HotmovieData);
    }
}
