package com.example.orvillelim.mvp_dagger2.Model;


import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.example.orvillelim.mvp_dagger2.App;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by orvillelim on 02/01/2017.
 */

public class GoogleService implements LoaderManager.LoaderCallbacks<List<String>> {

    @Inject
    App app;

    public GoogleService() {
    }

    public void initializeMails(GoogleAccountCredential credential){

    }

    @Override
    public Loader<List<String>> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<String>> loader) {

    }
}
