package com.example.mepositry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.mepositry.adapter.StudyAdapter;
import com.example.mepositry.base.BaseActivity;
import com.example.mepositry.bean.NewsBean;
import com.example.mepositry.bean.SubDataBean;
import com.example.mepositry.news.NewsPresenter;
import com.example.mepositry.news.NewsViewInterface;

import java.io.Serializable;
import java.util.List;

public class FirstActivity extends BaseActivity<NewsPresenter> implements NewsViewInterface {
    private List<SubDataBean.DataBean> list;
    private ListView list_first;
    private StudyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Bundle receive = getIntent().getExtras();
        list = (List) receive.getSerializable("sublist");
        list_first = findViewById(R.id.list_first);
        Log.e("TAG", "FirstActivity_First_StudyBean:" + list);
         adapter = new StudyAdapter(getApplicationContext(),list);
        list_first.setAdapter(adapter);

        list_first.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.checkNews(String.valueOf(list.get(position).getId()),"1");
            }
        });
    }

    @Override
    public NewsPresenter getPresenter() {
        return new NewsPresenter();
    }


    @Override
    public void newsShow(NewsBean mNewsBean) {
        Log.e("TAG", "FirstActivity_newsShow:" + mNewsBean);
        Bundle data=new Bundle();
        data.putSerializable("twolist", (Serializable) mNewsBean.getData());
        Intent gotoAnother=new Intent(FirstActivity.this,ThreeActivity.class);
        gotoAnother.putExtras(data);
        startActivity(gotoAnother);
    }
}
