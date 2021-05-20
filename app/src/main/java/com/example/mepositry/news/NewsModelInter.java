package com.example.mepositry.news;


import com.example.mepositry.bean.NewsBean;

public interface NewsModelInter {
    void news(String id, String page, Response response);

    interface Response{
        void success(NewsBean mNewsBean);
    }
}
