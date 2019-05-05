package com.bw.movie.mvp.contart;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.FindAllSysMsgListBean;
import com.bw.movie.bean.ModifyUserInfoBean;
import com.bw.movie.bean.NewVersionBean;
import com.bw.movie.bean.UserInfoByUserIdBean;

import java.util.HashMap;

import io.reactivex.Observable;


public interface UserInfoContart {

    interface IUserInfopresenter{
        void getUserInfoByUserIdPresenter(Observable<UserInfoByUserIdBean> userIdBean);
        void getmodifyUserInfoPresenter(Observable<ModifyUserInfoBean> modifyUserInfoBean);
        void getmodifyUserPwdPresenter(Observable<BaseBean> baseBean);
        void getrecordFeedBackPresenter(Observable<BaseBean> baseBean);
        void getfindAllSysMsgListPresenter(Observable<FindAllSysMsgListBean> baseBean);
        void getNewVersionPresenter(Observable<NewVersionBean> newVersionBean);
    }

    interface IUserInfomodel{
        void getUserInfoByUserIdModel();
        void getmodifyUserInfoModel(HashMap<String,String> map);
        void getmodifyUserPwdModel(HashMap<String,String> map);
        void getrecordFeedBackPwdModel(HashMap<String,String> map);
        void getfindAllSysMsgListModel(String page,String count);
        void getNewVersionModel(String ak);

    }

    interface IUserInfoView extends IBaseView {
        void UserInfoByUserIdsuccess(UserInfoByUserIdBean result);
        void modifyUserInfosuccess(ModifyUserInfoBean result);
        void modifyUserPwdsuccess(BaseBean result);
        void recordFeedBacksuccess(BaseBean result);
        void findAllSysMsgListsuccess(FindAllSysMsgListBean result);
        void NewVersionsuccess(NewVersionBean result);
        void UserInfoByUserIdfaild(Throwable t);
    }


}
