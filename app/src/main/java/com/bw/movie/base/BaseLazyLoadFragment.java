package com.bw.movie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseLazyLoadFragment extends Fragment {

    //是否是第一次加载数据
    protected boolean mIsFirstGetData = true;
    //fragment对用户是否可见
    protected boolean mIsVisibleToUser;
    //根布局
    protected View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //只有为空的时候加载布局，
        // 因为在viewpager中fragment对象不会被销毁，成员变量也不会销毁
        if (mRootView == null) {
            mRootView = inflater.inflate(provideLayoutId(), container, false);
            initView(mRootView);
        }
        return mRootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //懒加载数据
        lazyLoadData();
    }

    //fragment是否需要实时刷新，如果需要返回true，不需要返回false
    protected abstract boolean setIsRealTimeRefresh();

    protected abstract void initData();

    protected abstract void initView(View mRootView);

    protected abstract int provideLayoutId();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(mIsVisibleToUser);
        //设置可视状态
        mIsVisibleToUser = isVisibleToUser;
        //懒加载数据
        lazyLoadData();
    }

    public void lazyLoadData() {
        if ((mIsFirstGetData || setIsRealTimeRefresh()) && mIsVisibleToUser && mRootView != null) {
            mIsFirstGetData = false;
            initData();
        }
    }
}
