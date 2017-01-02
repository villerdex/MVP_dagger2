package com.example.orvillelim.mvp_dagger2.Presenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

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

    public interface View{
        void startMailListActivity();
    }

}
