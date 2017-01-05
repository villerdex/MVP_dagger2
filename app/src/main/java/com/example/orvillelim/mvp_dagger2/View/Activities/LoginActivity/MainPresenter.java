package com.example.orvillelim.mvp_dagger2.View.Activities.LoginActivity;

import android.content.Context;

import com.example.orvillelim.mvp_dagger2.View.Activities.PresenterView;
import com.example.orvillelim.mvp_dagger2.domain.GoogleService.GoogleService;

import javax.inject.Inject;

/**
 * Created by orvillelim on 02/01/2017.
 */

public class MainPresenter implements PresenterView<MainActivity> {

    @Inject
    GoogleService googleService;

    @Inject
    public MainPresenter() {
    }


    @Override
    public void onActivityStart() {

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
    public void setView(MainActivity view) {
    }

}
