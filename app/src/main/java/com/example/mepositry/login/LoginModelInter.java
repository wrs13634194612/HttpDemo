package com.example.mepositry.login;


import com.example.mepositry.base.BaseModelInterface;
import com.example.mepositry.bean.LoginBean;

public interface LoginModelInter extends BaseModelInterface {

    void login(String username, String password, Response response);
    interface Response{
        void success(LoginBean loginBean);
    }
}
