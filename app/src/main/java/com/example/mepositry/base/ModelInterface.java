package com.example.mepositry.base;


import com.example.mepositry.bean.GankBean;

public interface ModelInterface extends BaseModelInterface {
    void getData(String type, int counts, int pages, Response response);

    interface Response{
        void success(GankBean response);

    }
}
