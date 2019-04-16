package com.bw.movie.utils;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    //1创建一个单列模式
    private static volatile RetrofitUtils instance;
    private final Retrofit retrofit;
    //2创建一个私有的无参构造
    private RetrofitUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .addInterceptor(new RequestHeadUtils())
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();


        //3创建Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(WeiduBaseApi.BASEWAI_URL)//接口
                .addConverterFactory(GsonConverterFactory.create())//默认Gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用RxJava2的适配器
                .client(okHttpClient)
                .build();
    }
    //4.创建一个静态方法，得到instance 判断是否为空
    public static RetrofitUtils getInstance(){
        if(instance==null){
            //添加同步锁
            synchronized (RetrofitUtils.class){
                if(null==instance){
                    instance = new RetrofitUtils();
                }
            }
        }
        //5返回创建的instance
        return instance;
    }
    //6创建方法 方便调用
    public WeiduService getservice(){
        return retrofit.create(WeiduService.class);
    }


}
