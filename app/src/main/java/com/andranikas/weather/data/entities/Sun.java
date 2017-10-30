package com.andranikas.weather.data.entities;

import io.realm.RealmObject;

/**
 * Created by andranikas on 10/23/2017.
 */

public class Sun extends RealmObject {

    private long sunrise;
    private long sunset;

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
