package com.example.orvillelim.mvp_dagger2.domain.GoogleService;

import javax.inject.Inject;

/**
 * Created by orvillelim on 02/01/2017.
 */

public class GoogleService {

    @Inject
    public GoogleService() {
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

        String email = "How are you?";
        return email;
    }
}
