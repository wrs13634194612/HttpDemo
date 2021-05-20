package com.example.mepositry.adapter;



        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

        import com.example.mepositry.R;
        import com.example.mepositry.bean.NewsBean;

        import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private List<NewsBean.DataBean> studyLists;

    public NewsAdapter(Context context, List<NewsBean.DataBean> list) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.study_item, null);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_children = convertView.findViewById(R.id.tv_children);
        tv_name.setText(studyLists.get(position).getTitle());
        tv_children.setText(String.valueOf(studyLists.get(position).getDescription()));
        return convertView;
    }
}
