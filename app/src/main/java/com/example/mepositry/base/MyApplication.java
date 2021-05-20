package com.example.mepositry.base;


import android.app.Application;


public class MyApplication extends Application {
    private static MyApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }

    public static MyApplication getMyApp() {
        return mContext;
    }
}
