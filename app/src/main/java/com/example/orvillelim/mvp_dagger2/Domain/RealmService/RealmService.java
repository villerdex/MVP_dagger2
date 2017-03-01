package com.example.orvillelim.mvp_dagger2.Domain.RealmService;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Didoy on 2/27/2017.
 */

public class RealmService {

    private Realm realm;
    private Context context;

    public RealmService(Context context) {
        this.context = context;
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    public Realm getRealm(){
        return realm.getDefaultInstance();
    }
}
