package com.example.mepositry.study;


import com.example.mepositry.bean.StudyBean;
import com.example.mepositry.bean.SubDataBean;

public interface StudyModelInter {
    void study(Response response);
    void subData(String number,SubResponse response);


    interface Response{
        void success(StudyBean mStudyBean);
    }


    interface SubResponse{
        void success(SubDataBean mSubDataBean);
    }

}
