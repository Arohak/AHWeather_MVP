package com.andranikas.weather.data.source;

import com.andranikas.weather.data.entities.Forecast;
import com.andranikas.weather.data.entities.Weather;

import io.reactivex.Flowable;

/**
 * Created by andranikas on 10/18/2017.
 */

public interface WeatherDataSource {

    Flowable<Weather> getCurrentWeather(final String apiKey, final String city, final String units);

    Flowable<Forecast> getForecast(final String apiKey, final String city, final String units);

    void saveCurrentWeather(Weather weather);

    void saveForecast(Forecast forecast, String city);
}
