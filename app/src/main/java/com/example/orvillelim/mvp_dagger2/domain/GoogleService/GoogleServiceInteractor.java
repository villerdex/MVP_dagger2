package com.example.orvillelim.mvp_dagger2.domain.GoogleService;

import org.reactivestreams.Subscriber;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


/**
 * Created by orvillelim on 05/01/2017.
 */

public class GoogleServiceInteractor implements GoogleInteractor {

   GoogleService googleService;
    ObservableEmitter emitter;
    @Inject
    public GoogleServiceInteractor(GoogleService googleService) {
        this.googleService = googleService;
        googleService.setGoogleInteractor(this);
    }

    public Observable getMails(){
        return    Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                emitter = e;
                e.onNext(googleService.getEmails());
                e.onComplete();
            }
        });

    }
    public void changeData(){
        googleService.changeData();
    }

    @Override
    public void notifyEmailChange() {
        emitter.onNext(googleService.getEmails());
        emitter.onComplete();
    }
}
