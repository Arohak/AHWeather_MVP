package com.andranikas.weather.data.entities;

/**
 * Created by andranikas on 10/23/2017.
 */

public class City {

    private String name;
    private String description;
    private int temperature;
    private String conditionIconPath;

    public City(String name, String description, int temperature, String conditionIconPath) {
        this.name = name;
        this.description = description;
        this.temperature = temperature;
        this.conditionIconPath = conditionIconPath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getConditionIconPath() {
        return conditionIconPath;
    }
}
