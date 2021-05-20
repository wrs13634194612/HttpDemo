package com.example.mepositry.news;


import com.example.mepositry.base.BasePresenter;
import com.example.mepositry.bean.NewsBean;

public class NewsPresenter extends BasePresenter<NewsViewInterface> {
    private NewsModel model = new NewsModel();

    public void checkNews(String id, String page){
        model.news(id, page, new NewsModelInter.Response() {
            @Override
            public void success(NewsBean mNewsBean) {
                mView.newsShow(mNewsBean);
            }
        });
    }
}
