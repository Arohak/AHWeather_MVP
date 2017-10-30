package com.andranikas.weather.data.source.remote;

import android.support.annotation.NonNull;

import com.andranikas.weather.data.entities.Forecast;
import com.andranikas.weather.data.entities.Weather;
import com.andranikas.weather.data.service.WeatherService;
import com.andranikas.weather.data.source.WeatherDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by andranikas on 10/19/2017.
 */

@Singleton
public class WeatherRemoteDataSource implements WeatherDataSource {

    private final WeatherService mService;

    @Inject
    public WeatherRemoteDataSource(@NonNull WeatherService service) {
        checkNotNull(service);

        mService = service;
    }

    @Override
    public Flowable<Weather> getCurrentWeather(String apiKey, String city, String units) {
        return mService.getWeather(apiKey, city, units);
    }

    @Override
    public Flowable<Forecast> getForecast(String apiKey, String city, String units) {
        return mService.getForecast(apiKey, city, units);
    }

    @Override
    public void saveCurrentWeather(Weather weather) {
    }

    @Override
    public void saveForecast(Forecast forecast, String city) {
    }
}
