package com.andranikas.weather.data.entities;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by andranikas on 10/23/2017.
 */

public class Cloud extends RealmObject {

    @SerializedName("all")
    private String cloudiness;

    public String getCloudiness() {
        return cloudiness;
    }
}
