package com.example.mepositry.net;




import com.example.mepositry.bean.GankBean;
import com.example.mepositry.bean.LoginBean;
import com.example.mepositry.bean.NewsBean;
import com.example.mepositry.bean.StudyBean;
import com.example.mepositry.bean.SubDataBean;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static final String BASE_URL = "http://name.test/api/";
    public static final String URL = "https://name.com/";
    private static RetrofitHelper instance;
    private Retrofit retrofit;

    private RetrofitHelper(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpManager.getOkHttp())
                .build();
    }

    public static RetrofitHelper getInstance(){
        if (instance == null){
            synchronized (RetrofitHelper.class){
                if (instance == null){
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }

    public ApiService getService(){
        ApiService service = retrofit.create(ApiService.class);
        return service;
    }

    /*
     * 登录
     * */
    public static Observable<LoginBean> loginCheck(String username, String password){
        Observable<LoginBean> observable = RetrofitHelper.getInstance().getService()
                .login(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    /*
     * 注册
     * */
    public static Observable<LoginBean> registerCheck(String username,
                                                      String password, String repassword){
        Observable<LoginBean> observable = RetrofitHelper.getInstance()
                .getService().register(username, password, repassword)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    /*
     * 学习
     * */
    public static Observable<StudyBean> studyCheck(){
        Observable<StudyBean> observable = RetrofitHelper.getInstance()
                .getService().study()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
    /*
     *获取子栏目信息
     * */
    public static Observable<SubDataBean> subCheck(String number){
        Observable<SubDataBean> observable = RetrofitHelper.getInstance()
                .getService().subData(number)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    /*
     *获取资讯信息
     * */
    public static Observable<NewsBean> newsCheck(String id,String page){
        Observable<NewsBean> observable = RetrofitHelper.getInstance()
                .getService().news(id,page)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    /*
     * 从gank上获得数据
     * */
    public static Observable<GankBean> getObservable(String type, int counts, int pages){
        Observable<GankBean> observable =
                RetrofitHelper.getInstance().getService().getResult(type,counts,pages);
        return observable;
    }

    public static <T> ObservableTransformer<T,T> io_main(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return  upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
