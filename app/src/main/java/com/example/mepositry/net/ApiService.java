package com.example.mepositry.net;


import com.example.mepositry.bean.GankBean;
import com.example.mepositry.bean.LoginBean;
import com.example.mepositry.bean.NewsBean;
import com.example.mepositry.bean.StudyBean;
import com.example.mepositry.bean.SubDataBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

     @Headers({"urlname:gank"})
    @GET("api/data/{type}/{counts}/{pages}")
     Observable<GankBean> getResult(@Path("type") String type, @Path("counts") int counts, @Path("pages") int pages);

    //登录api
    @Headers({"urlname:wananzhuo"})
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> login(@Field("username") String username, @Field("password") String password);


    //注册api
    @Headers({"urlname:wananzhuo"})
    @FormUrlEncoded
    @POST("user/register")
    Observable<LoginBean> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    //学习api http://znzb.test/api/node/column2list
    @Headers({"urlname:gank"})
    @GET("node/column2list")
    Observable<StudyBean> study();

    //子栏目api http://znzb.test/api/node/list2/ykr5e1
    @Headers({"urlname:gank"})
    @GET("node/list2/{number}")
    Observable<SubDataBean> subData(@Path("number") String number);

    //资讯api http://znzb.test/api/info/list/387_1
    @Headers({"urlname:gank"})
    @GET("info/list/{id}_{page}")
    Observable<NewsBean> news(@Path("id") String id, @Path("page") String page);

}
