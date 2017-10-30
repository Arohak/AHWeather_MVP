package com.andranikas.weather.data.entities;

/**
 * Created by andranikas on 10/23/2017.
 */

public class CurrentWeather {

    private String sunrise;
    private String sunset;
    private String clouds;
    private String windSpeed;
    private String humidity;
    private String pressure;

    public CurrentWeather(String sunrise, String sunset, String clouds, String windSpeed, String humidity, String pressure) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.clouds = clouds;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String getClouds() {
        return clouds;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }
}
