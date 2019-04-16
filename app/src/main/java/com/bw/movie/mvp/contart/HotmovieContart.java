package com.bw.movie.mvp.contart;



import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.ComingBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.NowshowBean;

import io.reactivex.Observable;

public interface HotmovieContart {

    interface IHotmoviepresenter{
        void getHotmoviePresenter(Observable<HotmovieBean> Hotmoviebean);
        void getHotmovie2Presenter(Observable<NowshowBean> Hotmoviebean);
        void getHotmovie3Presenter(Observable<ComingBean> Hotmoviebean);
    }

    interface IHotmoviemodel{
        void getHotmovieModel(String key, String num);
        void getHotmovie2Model(String key, String num);
        void getHotmovie3Model(String key, String num);
    }

    interface IHotmovieView extends IBaseView {
        void success(HotmovieBean result);
        void faild(Throwable t);
        void success2(NowshowBean result);
        void faild2(Throwable t);
        void success3(ComingBean result);
        void faild3(Throwable t);
    }

}
