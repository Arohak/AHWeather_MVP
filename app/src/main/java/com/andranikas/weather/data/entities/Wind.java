package com.andranikas.weather.data.entities;

import io.realm.RealmObject;

/**
 * Created by andranikas on 10/23/2017.
 */

public class Wind extends RealmObject {

    private String speed;

    public String getSpeed() {
        return speed;
    }
}
