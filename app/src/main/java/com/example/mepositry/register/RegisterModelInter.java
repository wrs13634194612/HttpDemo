package com.example.mepositry.register;


import com.example.mepositry.bean.LoginBean;

public interface RegisterModelInter{
    void register(String username, String password, String repassword, Response response);

    interface Response{
        void success(LoginBean loginBean);
    }
}
