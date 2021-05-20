package com.example.mepositry.login;

import com.example.mepositry.base.BasePresenter;
import com.example.mepositry.bean.LoginBean;

public class LoginPresenter extends BasePresenter<LoginViewInterface> {
    private LoginModel model = new LoginModel();

    public void checkLogin(String username, String password) {
        model.login(username, password, new LoginModelInter.Response() {
            @Override
            public void success(LoginBean loginBean) {
                mView.loginShow(loginBean);
            }
        });
    }
}
