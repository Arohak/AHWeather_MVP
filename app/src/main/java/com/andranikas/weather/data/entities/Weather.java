package com.andranikas.weather.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Weather extends RealmObject {

    @PrimaryKey
    private String name;
    private Wind wind;

    @SerializedName("dt")
    private long dateTimeInMillis;

    @SerializedName("weather")
    private RealmList<WeatherCondition> conditions;

    @SerializedName("main")
    private Temperature temperature;

    @SerializedName("sys")
    private Sun sun;

    @SerializedName("clouds")
    private Cloud cloud;

    public String getName() {
        return name;
    }

    public Wind getWind() {
        return wind;
    }

    public long getDateTimeInMillis() {
        return dateTimeInMillis;
    }

    public List<WeatherCondition> getConditions() {
        return conditions;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Sun getSun() {
        return sun;
    }

    public Cloud getCloud() {
        return cloud;
    }
}
