package com.bw.movie.mvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangBean;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class ShortVideoAdapter extends RecyclerView.Adapter<ShortVideoAdapter.ViewHolder> {
    Context context;
    XiangBean.ResultBean list;

    public ShortVideoAdapter(Context context, XiangBean.ResultBean list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.recy_view_short_movie,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String imageUrl = list.getShortFilmList().get(i).getImageUrl();
        String videoUrl = list.getShortFilmList().get(i).getVideoUrl();
        //封面
        Glide.with(context).load(imageUrl).into(viewHolder.shortVideos.thumbImageView);
        viewHolder.shortVideos.setUp(videoUrl,JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"预告片");
        viewHolder.shortVideos.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //设置全屏
        viewHolder.shortVideos.fullscreenButton.setVisibility(View.GONE);
        viewHolder.shortVideos.progressBar.setVisibility(View.VISIBLE);
        viewHolder.shortVideos.currentTimeTextView.setVisibility(View.GONE);
        viewHolder.shortVideos.totalTimeTextView.setVisibility(View.GONE);
        viewHolder.shortVideos.tinyBackImageView.setVisibility(View.GONE);
        viewHolder.shortVideos.batteryLevel.setVisibility(View.GONE);
        viewHolder.shortVideos.startButton.setVisibility(View.VISIBLE);
        //设置容器内播放器高,解决黑边（视频全屏）
        JZVideoPlayer.setVideoImageDisplayType(JZVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT);
        JZVideoPlayer.TOOL_BAR_EXIST = false;
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public int getItemCount() {
        return list.getShortFilmList().size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        JZVideoPlayerStandard shortVideos;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shortVideos=itemView.findViewById(R.id.short_videos);
        }
    }
}
