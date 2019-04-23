package com.bw.movie.mvp.ui.fragment.homefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.mvp.ui.activity.CinemaPageListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class myFragment extends Fragment {

    @BindView(R.id.my_fragment_image1)
    ImageView myFragmentImage1;
    @BindView(R.id.my_fragment_image2)
    ImageView myFragmentImage2;
    @BindView(R.id.my_fragment_image3)
    ImageView myFragmentImage3;
    @BindView(R.id.my_fragment_image4)
    ImageView myFragmentImage4;
    @BindView(R.id.my_fragment_image5)
    ImageView myFragmentImage5;
    @BindView(R.id.my_fragment_image6)
    ImageView myFragmentImage6;
    @BindView(R.id.my_fragment_remind)
    ImageView myFragmentRemind;
    @BindView(R.id.my_fargment_userimage)
    ImageView myFargmentUserimage;
    @BindView(R.id.my_fargment_username)
    TextView myFargmentUsername;
    @BindView(R.id.my_fargment_userqiandao)
    TextView myFargmentUserqiandao;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }



    @OnClick({R.id.my_fragment_image1, R.id.my_fragment_image2, R.id.my_fragment_image3, R.id.my_fragment_image4, R.id.my_fragment_image5, R.id.my_fragment_image6, R.id.my_fragment_remind, R.id.my_fargment_userqiandao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_fragment_image1:
                break;
            case R.id.my_fragment_image2:
                wodeguanzhu();
                break;
            case R.id.my_fragment_image3:
                break;
            case R.id.my_fragment_image4:
                break;
            case R.id.my_fragment_image5:
                break;
            case R.id.my_fragment_image6:
                break;
            case R.id.my_fragment_remind:
                break;
            case R.id.my_fargment_userqiandao:
                break;
        }
    }

    private void wodeguanzhu() {
        Intent intent = new Intent(getActivity(),CinemaPageListActivity.class);
        startActivity(intent);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
