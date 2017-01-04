package com.example.orvillelim.mvp_dagger2.View.Activities.MailListActivity;

import android.content.Context;
import com.example.orvillelim.mvp_dagger2.View.Activities.PresenterView;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

import javax.inject.Inject;

/**
 * Created by orvillelim on 03/01/2017.
 */

public class MailListPresenter implements PresenterView<MailListPresenter.MailView> {

    MailView mailView;

    @Inject
    public MailListPresenter() {
    }

    @Override
    public void onActivityStart() {
     GoogleAccountCredential googleAccountCredential =  mailView.getCredential();
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
    public void setView(MailView view) {
        mailView = view;
    }

    public interface MailView {
        GoogleAccountCredential getCredential();
    }
}
