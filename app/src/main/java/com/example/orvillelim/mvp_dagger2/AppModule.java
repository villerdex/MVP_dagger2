package com.example.orvillelim.mvp_dagger2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by orvillelim on 02/01/2017.
 *xx
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
     SharedPreferences getSharePreference(){
        return   PreferenceManager.getDefaultSharedPreferences(context);
    }

}
