package com.andranikas.weather.data.service;

import com.andranikas.weather.data.entities.Forecast;
import com.andranikas.weather.data.entities.Weather;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("weather")
    Flowable<Weather> getWeather(@Query("appid") String apiKey, @Query("q") String city, @Query("units") String units);

    @GET("forecast")
    Flowable<Forecast> getForecast(@Query("appid") String apiKey, @Query("q") String city, @Query("units") String units);
}
