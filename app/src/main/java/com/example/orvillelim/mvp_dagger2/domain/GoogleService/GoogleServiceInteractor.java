package com.example.orvillelim.mvp_dagger2.domain.GoogleService;

import org.reactivestreams.Subscriber;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


/**
 * Created by orvillelim on 05/01/2017.
 */

public class GoogleServiceInteractor  {

     @Inject
     GoogleService googleService;

    @Inject
    public GoogleServiceInteractor() {
    }

    public Observable getMails(){

        return  Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                   e.onNext(googleService.getEmails());
                   e.onComplete();
            }
        });

    }
}
