package com.example.orvillelim.mvp_dagger2.View.Activities.MailListActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.orvillelim.mvp_dagger2.App;
import com.example.orvillelim.mvp_dagger2.R;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import javax.inject.Inject;

public class MailListActivity extends AppCompatActivity implements MailListPresenter.MailView {


    @Inject MailListPresenter presenter;
    GoogleAccountCredential credential;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_list2);

        App app = ( (App) getApplication() );
        app.getAppComponent().inject(this);
        credential = app.getGoogleAccountCredential();

        if(credential != null){
            Toast.makeText(this, "Credential Receive", Toast.LENGTH_LONG).show();
        }

        presenter.onActivityStart();
    }

    @Override
    public GoogleAccountCredential getCredential() {
        return  ((App) getApplication() ).getGoogleAccountCredential();
    }
}
