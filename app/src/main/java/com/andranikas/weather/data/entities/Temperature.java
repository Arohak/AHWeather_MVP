package com.andranikas.weather.data.entities;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by andranikas on 10/23/2017.
 */

public class Temperature extends RealmObject {

    @SerializedName("temp")
    private float currentTemperature;

    @SerializedName("temp_min")
    private float minTemperature;

    @SerializedName("temp_max")
    private float maxTemperature;

    private String pressure;
    private String humidity;

    public float getCurrentTemperature() {
        return currentTemperature;
    }

    public float getMinTemperature() {
        return minTemperature;
    }

    public float getMaxTemperature() {
        return maxTemperature;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }
}
