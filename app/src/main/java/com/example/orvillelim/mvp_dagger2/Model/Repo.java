package com.example.orvillelim.mvp_dagger2.Model;

import io.realm.RealmObject;

/**
 * Created by Didoy on 2/12/2017.
 */
public class Repo extends RealmObject {

    String name;
    String description;
    String site_admin;

    Owner owner;


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
