package com.example.orvillelim.mvp_dagger2.domain.GoogleService;

import com.example.orvillelim.mvp_dagger2.View.Activities.MailListActivity.MailListPresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by orvillelim on 05/01/2017.
 */
public class GoogleServiceInteractor {

    GoogleService mGoogleService;
    private Observer observer;

    @Inject
    public GoogleServiceInteractor() {
    }

    // injected object cant be used in constructor, @inject method are run after class creation
    @Inject
    public void initializeME( GoogleService mGoogleService ){
        this.mGoogleService =  mGoogleService;
        System.out.println("Wew");
    }

    public Flowable getMails() {

       return Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext(mGoogleService.getEmails());
                e.onComplete();

            }
        }, BackpressureStrategy.BUFFER);


    }

    public void changeData(final Subscriber subscriber) {
        mGoogleService.changeData(new GoogleInteractor(){
            @Override
            public void notifyEmailChange() {
                  getMails()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber);
            }
        });
    }


}
