package com.example.mepositry;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.mepositry.adapter.NewsAdapter;
import com.example.mepositry.bean.NewsBean;

import java.util.List;

public class ThreeActivity extends AppCompatActivity {
    private List<NewsBean.DataBean> list;
    private ListView list_three;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Bundle receive = getIntent().getExtras();
        list = (List) receive.getSerializable("twolist");
        Log.e("TAG", "ThreeActivity_three_StudyBean:" + list);

        list_three = findViewById(R.id.list_three);
        adapter = new NewsAdapter(getApplicationContext(), list);
        list_three.setAdapter(adapter);
    }
}

