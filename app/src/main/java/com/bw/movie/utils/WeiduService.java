package com.bw.movie.utils;


import com.bw.movie.bean.BaseBean;
import com.bw.movie.bean.BuyTicketRecordListBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.CinemaPageListBean;
import com.bw.movie.bean.CinemasListByMovieIdBean;
import com.bw.movie.bean.ComingBean;
import com.bw.movie.bean.FindAllSysMsgListBean;
import com.bw.movie.bean.FujinBean;
import com.bw.movie.bean.HotmovieBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.ModifyUserInfoBean;
import com.bw.movie.bean.MovieListByCinemaIdBean;
import com.bw.movie.bean.MoviePageListBean;
import com.bw.movie.bean.MovieScheduleListBean;
import com.bw.movie.bean.MovieTicket;
import com.bw.movie.bean.NewVersionBean;
import com.bw.movie.bean.NowshowBean;
import com.bw.movie.bean.PayBean;
import com.bw.movie.bean.PingBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.TuijianBean;
import com.bw.movie.bean.UserInfoByUserIdBean;
import com.bw.movie.bean.XiangBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
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

    //电影关注
    @GET("movie/v1/verify/followMovie")
    Observable<BaseBean> followMovieData(@Query("movieId") String firstCategoryId);
    //取消电影关注
    @GET("movie/v1/verify/cancelFollowMovie")
    Observable<BaseBean> cancelFollowMovieData(@Query("movieId") String firstCategoryId);


    //定位查询附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<FujinBean> fujinData(@Query("page") String page, @Query("count") String count, @Query("longitude") String longitude,@Query("latitude") String latitude);

    //  关注影院
    @GET("cinema/v1/verify/followCinema")
    Observable<BaseBean> guanzhuData(@HeaderMap HashMap<String,String> map,@Query("cinemaId") String firstCategoryId);
    //取消影院关注
    @GET("cinema/v1/verify/cancelFollowCinema")
    Observable<BaseBean> cancelFollowData(@HeaderMap HashMap<String,String> map,@Query("cinemaId") String firstCategoryId);
   //推荐影院关注
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TuijianBean> circleData(@HeaderMap HashMap<String,String> map,@Query("page") String page, @Query("count") String count);
    //电影详情
    @GET("movie/v1/findMoviesDetail")
    Observable<XiangBean> xiangData(@Query("movieId") String movieId);
    //评价
    @GET("movie/v1/findAllMovieComment")
    Observable<PingBean> pingData(@Query("page") String page, @Query("count") String count, @Query("movieId") String commodityId);

    //购票根据电影ID查询当前排片该电影的影院列表
    @GET("movie/v1/findCinemasListByMovieId")
    Observable<CinemasListByMovieIdBean> CinemasListByMovieIdData(@Query("movieId") String movieId);
    //根据电影ID和影院ID查询电影排期列表
    @GET("movie/v1/findMovieScheduleList")
    Observable<MovieScheduleListBean> MovieScheduleListData(@Query("movieId") String movieId,@Query("cinemasId") String cinemasId);

    //添加评价
    @FormUrlEncoded
    @POST("movie/v1/verify/movieComment")
    Observable<BaseBean> addpingData(@FieldMap HashMap<String,String> map);

    //查询用户关注的影院信息
    @GET("cinema/v1/verify/findCinemaPageList")
    Observable<CinemaPageListBean> CinemaPageListData(@Query("page") String page, @Query("count") String count);
    //查询用户关注的电影信息
    @GET("movie/v1/verify/findMoviePageList")
    Observable<MoviePageListBean> MoviePageListData(@Query("page") String page, @Query("count") String count);
    //购票下单
    @FormUrlEncoded
    @POST("movie/v1/verify/buyMovieTicket")
    Observable<MovieTicket> MovieTicketData(@FieldMap HashMap<String,String> map);
    //查询用户购票记录
    @GET("user/v1/verify/findUserBuyTicketRecordList")
    Observable<BuyTicketRecordListBean> BuyTicketRecordListData(@QueryMap HashMap<String,String> map);
    //支付
    @FormUrlEncoded
    @POST("movie/v1/verify/pay")
    Observable<PayBean> payData(@FieldMap HashMap<String,String> map);

    //查询电影信息明细
    @GET("cinema/v1/findCinemaInfo")
    Observable<CinemaInfoBean> cinemainfoData(@Query("cinemaId")String cinemaId);
    //根据影院ID查询该影院当前排期的电影列表
    @GET("movie/v1/findMovieListByCinemaId")
    Observable<MovieListByCinemaIdBean> MovieListByCinemaIdData(@Query("cinemaId")String cinemaId);

    //查询用户信息
    @GET("user/v1/verify/getUserInfoByUserId")
    Observable<UserInfoByUserIdBean> UserInfoByUserIdData();
    //修改用户信息
    @FormUrlEncoded
    @POST("user/v1/verify/modifyUserInfo")
    Observable<ModifyUserInfoBean> modifyUserInfoData(@FieldMap HashMap<String,String> map);

    //修改密码
    @FormUrlEncoded
    @POST("user/v1/verify/modifyUserPwd")
    Observable<BaseBean> modifyUserPwdData(@FieldMap HashMap<String,String> map);

    //意见反馈
    @FormUrlEncoded
    @POST("tool/v1/verify/recordFeedBack")
    Observable<BaseBean> recordFeedBackData(@FieldMap HashMap<String,String> map);

    //查询系统消息列表
    @GET("tool/v1/verify/findAllSysMsgList")
    Observable<FindAllSysMsgListBean> findAllSysMsgListData(@Query("page")String page,@Query("count")String count);
    //查询新版本
    @GET("tool/v1/findNewVersion")
    Observable<NewVersionBean> NewVersionData(@Header("ak")String ak);
}
