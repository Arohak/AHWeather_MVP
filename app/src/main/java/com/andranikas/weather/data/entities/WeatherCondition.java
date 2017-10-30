package com.andranikas.weather.data.entities;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by andranikas on 10/23/2017.
 */

public class WeatherCondition extends RealmObject {

    @SerializedName("main")
    private String groupedCondition;
    private String description;
    private String icon;

    public String getGroupedCondition() {
        return groupedCondition;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
