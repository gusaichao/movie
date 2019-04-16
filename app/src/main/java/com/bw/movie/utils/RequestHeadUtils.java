package com.bw.movie.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestHeadUtils implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String userid = (String) SPFUtil.getInstance().getData("userid","");
        String sessionid = (String) SPFUtil.getInstance().getData("sessionid","");
        Request.Builder builder = request.newBuilder();
        builder.addHeader("userId",userid);
        builder.addHeader("sessionId",sessionid);
        Request build = builder.build();
        Response proceed = chain.proceed(build);
        return proceed;
    }
}
