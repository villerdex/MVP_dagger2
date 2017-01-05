package com.example.orvillelim.mvp_dagger2.Presenter;

import com.example.orvillelim.mvp_dagger2.Model.GoogleService;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import javax.inject.Inject;

/**
 * Created by orvillelim on 02/01/2017.
 */

public class MainPresenter {

    @Inject
    GoogleService googleService;
    MainPresenter.View mView;


    @Inject
    public MainPresenter() {
    }
    public void startMailListActivity(){
        mView.startMailListActivity();
    }

    public void setView(MainPresenter.View view){
        mView = view;
    }

    public void getMails(GoogleAccountCredential googleCredential){
        googleService.initializeMails(googleCredential);
    }

    public interface View{
        void startMailListActivity();
    }

}
