package com.example.orvillelim.mvp_dagger2.View.Activities.MailListActivity;

import android.content.Context;
import com.example.orvillelim.mvp_dagger2.View.Activities.PresenterView;
import com.example.orvillelim.mvp_dagger2.domain.GoogleService.GoogleServiceInteractor;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import java.io.Reader;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by orvillelim on 03/01/2017.
 */

public class MailListPresenter implements PresenterView<MailListPresenter.MailView> {

    MailView mailView;

    @Inject
    GoogleServiceInteractor googleServiceInteractor;

    @Inject
    public MailListPresenter() {
    }

    @Override
    public void onActivityStart() {
//     GoogleAccountCredential googleAccountCredential =  mailView.getCredential();
    }

    @Override
    public void onActivityPause() {

    }

    @Override
    public void onActivityDestroy() {

    }

    @Override
    public void startActivity(Context context) {

    }

    @Override
    public void setView(MailView view) {
        mailView = view;
    }

    public void fetchEmails(){
        System.out.println("fetch mail");

        Observer observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String email) {
                mailView.showEmail(email);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        googleServiceInteractor.getMails()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public void changeData(){
        googleServiceInteractor.changeData();
    }

    public interface MailView {
        GoogleAccountCredential getCredential();
        void showEmail(String email);
    }
}
