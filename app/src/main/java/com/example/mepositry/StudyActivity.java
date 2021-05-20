package com.example.mepositry;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.mepositry.adapter.ILanguageRecycleListener;
import com.example.mepositry.adapter.LanguageRecycleAdapter;
import com.example.mepositry.base.BaseActivity;
import com.example.mepositry.bean.StudyBean;
import com.example.mepositry.bean.SubDataBean;
import com.example.mepositry.study.StudyPresenter;
import com.example.mepositry.study.StudyViewInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudyActivity extends BaseActivity<StudyPresenter> implements StudyViewInterface, ILanguageRecycleListener {

    private RecyclerView rvLanguage;
    private LanguageRecycleAdapter languageRecycleAdapter;
    private List<StudyBean.DataBean> studyLists;
    private String idString;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        rvLanguage = findViewById(R.id.rvLanguage);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.checkStudy();
    }

    @Override
    public StudyPresenter getPresenter() {
        return new StudyPresenter();
    }

    @Override
    public void studyShow(StudyBean mStudyBean) {
        Log.e("TAG","RegisterActivity_registerShow:"+mStudyBean);
        // studyLists.get(0).getId();  //之前的值的id拿到了吗
        studyLists = new ArrayList<>();
        studyLists.addAll(mStudyBean.getData());
        for (int i = 0; i < studyLists.size(); i++) {
            if (studyLists.get(i).getChildren().size() == 0) {
                if (studyLists.get(i).getId() == 407) {
                    /// https://upload-images.jianshu.io/upload_images/17985516-db12d22bb7334370.png
                    studyLists.get(i).getChildren().add(new StudyBean.DataBean.ChildrenBean("学习强国", "default", "https://img-blog.csdnimg.cn/20210518112359215.png", "default"));
                    studyLists.get(i).getChildren().add(new StudyBean.DataBean.ChildrenBean("党建链接", "default", "https://img-blog.csdnimg.cn/20210518112259263.png", "default"));
                } else if (studyLists.get(i).getId() == 408) {
                    studyLists.get(i).getChildren().add(new StudyBean.DataBean.ChildrenBean("卡片学习", "default", "https://img-blog.csdnimg.cn/20210518112319227.png", "default"));
                    studyLists.get(i).getChildren().add(new StudyBean.DataBean.ChildrenBean("在线测试", "default", "https://img-blog.csdnimg.cn/20210518112238931.png", "default"));
                    studyLists.get(i).getChildren().add(new StudyBean.DataBean.ChildrenBean("微生活", "default", "https://img-blog.csdnimg.cn/20210518112334580.png", "default"));
                    studyLists.get(i).getChildren().add(new StudyBean.DataBean.ChildrenBean("直播间", "default", "https://img-blog.csdnimg.cn/20210518112409774.png", "default"));
                }
            }
        }
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this);
        rvLanguage.setLayoutManager(layoutManager);
        languageRecycleAdapter = new LanguageRecycleAdapter(getApplicationContext(), studyLists, this);
        rvLanguage.setAdapter(languageRecycleAdapter);
    }

    @Override
    public void subShow(SubDataBean mSubDataBean) {
        Log.e("TAG","StudyActivity_registerShow:"+mSubDataBean);
        // studyLists.get(0).getId();  //之前的值的id拿到了吗
        if (mSubDataBean.getData().size()==0){
            //重新请求一次  或者把之前的值拿出来  拿出id  然后  传递过去  请求拿数据就行
            Log.e("TAG", "TextActivity:" + mSubDataBean+"\t"+idString);
            Bundle data=new Bundle();
            data.putString("id", idString);
            Intent gotoAnother=new Intent(getApplicationContext(),TwoActivity.class);
            gotoAnother.putExtras(data);
            startActivity(gotoAnother);
        }else{
            Bundle data = new Bundle();
            data.putSerializable("sublist", (Serializable) mSubDataBean.getData());
            Intent gotoAnother = new Intent(getApplicationContext(), FirstActivity.class);
            gotoAnother.putExtras(data);
            startActivity(gotoAnother);
        }
    }

    @Override
    public void itemOnClick(String name, String number, String id) {
        Log.e("TAG", "TextActivity_itemOnClick" + ", " + name + "\t" + number + "\t" + id);

        switch (number) {
            case "legal":
                Log.e("TAG", "TextActivity_itemOnClick-法制专栏");
                presenter.checkSubData(number);
                break;
            case "ykr5e1":
                Log.e("TAG", "TextActivity_itemOnClick-党史教育");
                presenter.checkSubData(number);
                idString = id;
                break;
            case "k4g607":
                Log.e("TAG", "TextActivity_itemOnClick-法制教育");
            //    mPresenter.loadNoteData(number);
                idString = id;
                break;
            case "sfaeoq":
                Log.e("TAG", "TextActivity_itemOnClick-热点专题");
               // mPresenter.loadNoteData(number);
                idString = id;
                break;
            case "1eh9og":
                Log.e("TAG", "TextActivity_itemOnClick-抗疫专题");
               // mPresenter.loadNoteData(number);
                idString = id;
                break;
            case "o56m2q":
                Log.e("TAG", "TextActivity_itemOnClick-头雁引领");
              //  mPresenter.loadNoteData(number);
                idString = id;
                break;
            case "idazbw":
                Log.e("TAG", "TextActivity_itemOnClick-启智润心");
              //  mPresenter.loadNoteData(number);
                idString = id;
                break;
            case "298dq1":
                Log.e("TAG", "TextActivity_itemOnClick-培根铸魂");
              //  mPresenter.loadNoteData(number);
                idString = id;
                break;
            case "f2a8pu":
                Log.e("TAG", "TextActivity_itemOnClick-品牌集群");
             //   mPresenter.loadNoteData(number);
                idString = id;
                break;
        }
    }

}
