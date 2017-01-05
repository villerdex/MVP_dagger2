package com.example.orvillelim.mvp_dagger2.domain.GoogleService;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by orvillelim on 02/01/2017.
 */

public class GoogleService {

    String email = "How are you?";

    GoogleInteractor googleInteractor;

    public GoogleService() {

    }

    public void setGoogleInteractor(GoogleInteractor googleInteractor){
        this.googleInteractor = googleInteractor;
    }

    public String getEmails(){

        long future = System.currentTimeMillis() + 3000;
            while (future > System.currentTimeMillis()){
                try {
                    Thread.sleep(1000);
                    System.out.println("waiting ... ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        return email;
    }

    public void changeData(){
        email = "This is new Email";
        googleInteractor.notifyEmailChange();
    }

}
