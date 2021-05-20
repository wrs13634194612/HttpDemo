package com.example.mepositry.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mepositry.R;
import com.example.mepositry.bean.StudyBean;
import com.example.mepositry.bean.SubDataBean;

import java.util.List;

public class StudyAdapter extends BaseAdapter {
    private Context context;
    private List<SubDataBean.DataBean> studyLists;

    public StudyAdapter(Context context, List<SubDataBean.DataBean> list) {
        this.context = context;
        this.studyLists = list;
    }

    @Override
    public int getCount() {
        return studyLists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.study_item,null);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_children = convertView.findViewById(R.id.tv_children);
        tv_name.setText(studyLists.get(position).getName());
        tv_children.setText(String.valueOf(studyLists.get(position).getNumber()));
        return  convertView;
    }
}
