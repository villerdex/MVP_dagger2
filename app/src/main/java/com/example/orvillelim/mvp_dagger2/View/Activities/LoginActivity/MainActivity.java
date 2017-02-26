package com.example.orvillelim.mvp_dagger2.View.Activities.LoginActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.orvillelim.mvp_dagger2.App;
import com.example.orvillelim.mvp_dagger2.R;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.gmail.GmailScopes;

import java.util.Arrays;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    private static final String[] SCOPES = { GmailScopes.GMAIL_LABELS };
    private GoogleAccountCredential credential;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((App) getApplication() ).getAppComponent().inject(this);
        mainPresenter.setView(this);

        // initiate something
        mainPresenter.onActivityStart();
    }

    public void displayAllRepos(){
        System.out.println("displayAllRepos ");
    }



}
