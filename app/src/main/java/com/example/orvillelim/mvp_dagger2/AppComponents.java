package com.example.orvillelim.mvp_dagger2;

import com.example.orvillelim.mvp_dagger2.View.Activities.LoginActivity.MainPresenter;
import com.example.orvillelim.mvp_dagger2.View.Activities.LoginActivity.MainActivity;
import com.example.orvillelim.mvp_dagger2.View.Activities.MailListActivity.MailListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by orvillelim on 02/01/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponents {

    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
    void inject(MailListActivity mailListActivity);

}
