package com.example.mepositry.study;

import com.example.mepositry.base.BaseViewInterface;
import com.example.mepositry.bean.StudyBean;
import com.example.mepositry.bean.SubDataBean;

public interface StudyViewInterface extends BaseViewInterface {
    void studyShow(StudyBean mStudyBean);
    void subShow(SubDataBean mSubDataBean);

}
