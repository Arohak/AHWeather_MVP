package com.andranikas.weather.data.entities;

/**
 * Created by andranikas on 10/23/2017.
 */

public class DayTemperature {

    private float min;
    private float max;
    private long dateTimeInMillis;
    private String day;

    public DayTemperature(float min, float max, long dateTimeInMillis, String day) {
        this.min = min;
        this.max = max;
        this.dateTimeInMillis = dateTimeInMillis;
        this.day = day;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public long getDateTimeInMillis() {
        return dateTimeInMillis;
    }

    public String getDay() {
        return day;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public String getRoundedMaxTemperature() {
        return String.valueOf(Math.round(max));
    }

    public String getRoundedMinTemperature() {
        return String.valueOf(Math.round(min));
    }
}
