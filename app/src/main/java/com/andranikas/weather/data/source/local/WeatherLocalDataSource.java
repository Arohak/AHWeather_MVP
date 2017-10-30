package com.andranikas.weather.data.source.local;

import android.support.annotation.NonNull;

import com.andranikas.weather.data.entities.Forecast;
import com.andranikas.weather.data.entities.Weather;
import com.andranikas.weather.data.service.DBService;
import com.andranikas.weather.data.source.WeatherDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by andranikas on 10/19/2017.
 */

@Singleton
public class WeatherLocalDataSource implements WeatherDataSource {

    private final DBService mService;

    @Inject
    public WeatherLocalDataSource(@NonNull DBService service) {
        checkNotNull(service);

        mService = service;
    }

    @Override
    public Flowable<Weather> getCurrentWeather(String apiKey, String city, String units) {
        return mService.getCurrentWeather(city);
    }

    @Override
    public Flowable<Forecast> getForecast(String apiKey, String city, String units) {
        return mService.getForecast();
    }

    @Override
    public void saveCurrentWeather(Weather weather) {
        mService.saveCurrentWeather(weather);
    }

    @Override
    public void saveForecast(Forecast forecast, String city) {
        mService.saveForecast(forecast, city);
    }
}
