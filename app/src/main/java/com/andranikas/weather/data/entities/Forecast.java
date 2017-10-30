package com.andranikas.weather.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Forecast extends RealmObject {

    @PrimaryKey
    private String id;
    private String name;

    @SerializedName("list")
    private RealmList<Weather> weathers;

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setName(String name) {
        this.name = name;
    }
}
