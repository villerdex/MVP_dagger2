package com.example.orvillelim.mvp_dagger2.Model;

import io.realm.RealmObject;

/**
 * Created by Didoy on 2/26/2017.
 */

public class Owner extends RealmObject {

    long id;
    String login;
    String avatar_url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
