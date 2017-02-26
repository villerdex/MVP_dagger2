package com.example.orvillelim.mvp_dagger2.View.Activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

/**
 * Created by orvillelim on 03/01/2017.
 */

public interface PresenterView<T> {
        void onActivityStart();
        void onActivityPause();
        void onActivityDestroy();
        void startActivity(Context context);
        void setView(T view);

}
