package com.example.orvillelim.mvp_dagger2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.orvillelim.mvp_dagger2.domain.GoogleService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by orvillelim on 02/01/2017.
 *
 *
 *
 */


@Module
public class AppModule {

    Context context;
    AppModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    public GoogleService getGoogleService(){
        return new GoogleService();
    }

    @Provides
    @Singleton
    public SharedPreferences getSharePreference(){
        return   PreferenceManager.getDefaultSharedPreferences(context);
    }
}
