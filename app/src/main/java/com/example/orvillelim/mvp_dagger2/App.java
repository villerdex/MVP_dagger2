package com.example.orvillelim.mvp_dagger2;

import android.app.Application;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

/**
 * Created by orvillelim on 02/01/2017.
 */

public class App extends Application {

    public AppComponents appComponents;
    private GoogleAccountCredential googleAccountCredential;

    public App() {

    }

    public AppComponents getAppComponent(){
        appComponents = DaggerAppComponents
                .builder()
                .appModule(new AppModule(this))
                .build();
        return appComponents;
    }

    public GoogleAccountCredential getGoogleAccountCredential() {
        return googleAccountCredential;
    }

    public void setGoogleAccountCredential(GoogleAccountCredential googleAccountCredential) {
        this.googleAccountCredential = googleAccountCredential;
    }
}
