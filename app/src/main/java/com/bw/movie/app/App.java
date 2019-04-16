package com.bw.movie.app;

import android.app.Application;
import android.os.Environment;

import com.bw.movie.utils.SPFUtil;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SPFUtil.init(getApplicationContext());
        DiskCacheConfig cacheConfig = DiskCacheConfig.newBuilder(this)
                .setMaxCacheSize(30*1024*1024)
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .setBaseDirectoryName("weidumovie")
                .build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(cacheConfig)
                .build();

        Fresco.initialize(this,config);
    }
}
