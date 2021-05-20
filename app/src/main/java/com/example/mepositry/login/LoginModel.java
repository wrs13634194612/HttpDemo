package com.example.mepositry.login;


import com.example.mepositry.bean.LoginBean;
import com.example.mepositry.net.RetrofitHelper;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginModel implements LoginModelInter {

    @Override
    public void login(String username, String password, final Response response) {
        RetrofitHelper.loginCheck(username, password)
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        response.success(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
