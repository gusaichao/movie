package com.bw.movie.mvp.presneter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.mvp.contart.AddpingContart;
import com.bw.movie.mvp.model.AddpingModel;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AddpingPresenter extends BasePresenter<AddpingContart.AddpingView> implements AddpingContart.Addpingprasenter {

    private AddpingModel addpingModel;
    public AddpingPresenter(AddpingContart.AddpingView view) {
        super(view);
    }

    public void gettext(HashMap<String,String> map){
        addpingModel.addpinglist(map);
    }

    @Override
    public void addpinglist(Observable<BaseBean> addping) {
        addping.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseBean>() {
                    @Override
                    public void accept(BaseBean baseBean) throws Exception {
                        view.success(baseBean.getMessage());
                    }
                });
    }

    @Override
    protected void initModel() {
        addpingModel = new AddpingModel(this);
    }
}
