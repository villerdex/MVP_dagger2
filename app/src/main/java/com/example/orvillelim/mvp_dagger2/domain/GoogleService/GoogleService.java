package com.example.orvillelim.mvp_dagger2.domain.GoogleService;

/**
 * Created by orvillelim on 02/01/2017.
 */

public class GoogleService {

    String email = "How are you?";


    public void setGoogleInteractor(){
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

    public void changeData(GoogleInteractor mGoogleInteractor ){
        email = "This is new Email";
        mGoogleInteractor.notifyEmailChange();
    }

}
