package com.example.mepositry.study;


import com.example.mepositry.base.BasePresenter;
import com.example.mepositry.bean.StudyBean;
import com.example.mepositry.bean.SubDataBean;

public class StudyPresenter extends BasePresenter<StudyViewInterface> {
    private StudyModel model = new StudyModel();

    //获取学习页面
    public void checkStudy(){
        model.study(new StudyModelInter.Response() {
            @Override
            public void success(StudyBean mStudyBean) {
                mView.studyShow(mStudyBean);
            }
        });
    }

    //获取子栏目
    public void checkSubData(String number){
        model.subData(number,new StudyModelInter.SubResponse() {
            @Override
            public void success(SubDataBean mSubDataBean) {
                mView.subShow(mSubDataBean);
            }
        });
    }

}
