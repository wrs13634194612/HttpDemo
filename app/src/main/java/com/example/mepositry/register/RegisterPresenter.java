package com.example.mepositry.register;


import com.example.mepositry.bean.LoginBean;
import com.example.mepositry.base.BasePresenter;

public class RegisterPresenter extends BasePresenter<RegisterViewInterface> {
    private RegisterModel model = new RegisterModel();

    public void checkRegister(String username, String password, String repassword){
        model.register(username, password, repassword, new RegisterModelInter.Response() {
            @Override
            public void success(LoginBean loginBean) {
                mView.registerShow(loginBean);
            }
        });
    }
}
