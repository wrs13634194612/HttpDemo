package com.example.mepositry.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseViewInterface {
    public T presenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
        presenter.attach(this);//connect
    }

    @Override
    protected void onDestroy() {
        presenter.detach();     //break connect
        super.onDestroy();
    }

    public abstract T getPresenter();

}
