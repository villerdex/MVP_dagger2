package com.example.orvillelim.mvp_dagger2.View.Activities.MailListActivity;

import android.content.Context;
import com.example.orvillelim.mvp_dagger2.View.Activities.PresenterView;
import com.example.orvillelim.mvp_dagger2.domain.GoogleService.GoogleServiceInteractor;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.Reader;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by orvillelim on 03/01/2017.
 */

public class MailListPresenter implements PresenterView<MailListPresenter.MailView> {

    MailView mailView;
    CompositeDisposable composite = new CompositeDisposable();
    Subscriber<String> subscriber;

    @Inject
    GoogleServiceInteractor googleServiceInteractor ;

    @Inject
    public MailListPresenter() {

        subscriber = new Subscriber<String>() {

            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String value) {
                mailView.showEmail(value);
                System.out.println(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        } ;
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

    googleServiceInteractor.getMails()
               .subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(subscriber);

    }

    public void changeData(){

        googleServiceInteractor.changeData(subscriber);
    }

    public void dispose(){
        composite.dispose();
        if (composite.isDisposed()){
            System.out.println("Disposed");
        }
    }

    public interface MailView {
        void showEmail(String email);
    }
}
