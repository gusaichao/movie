package com.bw.movie.bean;

public class AllBean {
    HotmovieBean hot;
    NowshowBean showing;
    ComingBean show;

    public HotmovieBean getHot() {
        return hot;
    }

    public void setHot(HotmovieBean hot) {
        this.hot = hot;
    }

    public NowshowBean getShowing() {
        return showing;
    }

    public void setShowing(NowshowBean showing) {
        this.showing = showing;
    }

    public ComingBean getShow() {
        return show;
    }

    public void setShow(ComingBean show) {
        this.show = show;
    }
}
