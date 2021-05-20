package com.example.mepositry.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mepositry.R;
import com.example.mepositry.bean.StudyBean;

import java.util.List;

public class LanguageRecycleAdapter extends RecyclerView.Adapter<LanguageViewHolder> {
    private List<StudyBean.DataBean> languageList;
    private Context context;
    private ILanguageRecycleListener listener;

    public LanguageRecycleAdapter(Context mContext, List<StudyBean.DataBean> mList, ILanguageRecycleListener listener) {
        this.languageList = mList;
        this.listener = listener;
        context = mContext;
    }

    public void setData(List<StudyBean.DataBean> mList) {
        this.languageList = mList;
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LanguageViewHolder holder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_study, parent, false);
        holder = new LanguageViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, final int position) {
        holder.item_title.setText(languageList.get(position).getName());

        for (int i = 0; i < languageList.get(position).getChildren().size(); i++) {
            holder.layout[i].setVisibility(View.VISIBLE);
            holder.tv[i].setText(languageList.get(position).getChildren().get(i).getName());

            final int finalI = i;
            holder.layout[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemOnClick(
                            languageList.get(position).getChildren().get(finalI).getName(),
                            languageList.get(position).getChildren().get(finalI).getNumber(),
                            languageList.get(position).getChildren().get(finalI).getId()
                    );
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }
}
