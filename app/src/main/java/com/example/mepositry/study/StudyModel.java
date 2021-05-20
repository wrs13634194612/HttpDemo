package com.example.mepositry.study;


import com.example.mepositry.bean.StudyBean;
import com.example.mepositry.bean.SubDataBean;
import com.example.mepositry.net.RetrofitHelper;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class StudyModel implements StudyModelInter {

    @Override
    public void study(final Response response) {
        RetrofitHelper.studyCheck()
                .subscribe(new Observer<StudyBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull StudyBean studyBean) {
                        response.success(studyBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void subData(String number,final SubResponse response) {
        RetrofitHelper.subCheck(number)
                .subscribe(new Observer<SubDataBean>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SubDataBean subDataBean) {
                        response.success(subDataBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
