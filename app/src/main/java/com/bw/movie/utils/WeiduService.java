package com.bw.movie.utils;


import com.bw.movie.bean.ComingBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.NowshowBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.bean.XiangBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WeiduService {
    //登陆
    @POST("user/v1/login")
    Observable<LoginBean> loginData(@Query("phone") String phone, @Query("pwd") String pwd);
    //注册
    @POST("user/v1/registerUser")
    Observable<RegisterBean> regData(@QueryMap HashMap<String,String> map);
    //热门电影
    @GET("movie/v1/findHotMovieList")
    Observable<HotmovieBean> hotmovieData(@Query("page") String page, @Query("count") String count);
    //正在热映
    @GET("movie/v1/findReleaseMovieList")
    Observable<NowshowBean> nowshowData(@Query("page") String page, @Query("count") String count);
    //即将上映
    @GET("movie/v1/findComingSoonMovieList")
    Observable<ComingBean> comingData(@Query("page") String page, @Query("count") String count);

//    //关键字查询
//    @GET("commodity/v1/findCommodityByKeyword")
//    Observable<GoodsmsgBean> goodsmsgData(@Query("page") String page, @Query("count") String count, @Query("keyword") String keyword);
//
//    @GET("commodity/v1/findFirstCategory")
//    Observable<PoptopBean> poptopData();
//  关注影院
    @GET("cinema/v1/verify/followCinema")
    Observable<TuijianBean> guanzhuData(@Query("firstCategoryId") String firstCategoryId);
    //取消关注
    @GET("cinema/v1/verify/cancelFollowCinema")
    Observable<TuijianBean> cancelFollowData(@Query("firstCategoryId") String firstCategoryId);
//    //圈子
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TuijianBean> circleData(@Query("page") String page, @Query("count") String count);
//    //详情
    @GET("movie/v1/findMoviesDetail")
    Observable<XiangBean> xiangData(@Query("movieId") String movieId);
//    //评价
//    @GET("commodity/v1/CommodityCommentList")
//    Observable<AssessBean> assessData(@Query("page") String page, @Query("count") String count, @Query("commodityId") String commodityId);
//    //我的足迹
//    @GET("commodity/verify/v1/browseList")
//    Observable<MyfootBean> myfootData(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);
//
//    //加入购物车
//    @FormUrlEncoded
//    @PUT("order/verify/v1/syncShoppingCart")
//    Observable<BannerBean> addcart(@Header("userId") String userId, @Header("sessionId") String sessionId, @Field("data") String data);
//
//    //查询购物车
//    @GET("order/verify/v1/findShoppingCart")
//    Observable<CartBean> cartData(@Header("userId") String userId, @Header("sessionId") String sessionId);
//
//    //上传头像
//    @POST("user/verify/v1/modifyHeadPic")
//    @Multipart
//    Observable<ModifyHeadPic> headpic(@Header("userId") String userId, @Header("sessionId") String sessionId, @Part MultipartBody.Part f);
//
//    //个人资料
//    @GET("user/verify/v1/getUserById")
//    Observable<UserBean> userData(@Header("userId") String userId, @Header("sessionId") String sessionId);
//    //收货地址列表
//    @GET("user/verify/v1/receiveAddressList")
//    Observable<AddressListBean> addressListData(@Header("userId") String userId, @Header("sessionId") String sessionId);
//
//    @POST("order/verify/v1/createOrder")
//    Observable<BannerBean> creatorder(@Header("userId") String userId, @Header("sessionId") String sessionId, @Body MultipartBody body);

}
