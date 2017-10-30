package com.andranikas.weather.data.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.andranikas.weather.data.entities.Forecast;
import com.andranikas.weather.data.entities.Weather;
import com.andranikas.weather.util.NetworkUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by andranikas on 10/19/2017.
 */

@Singleton
public class WeatherRepository implements WeatherDataSource {

    private final Context mContext;
    private final WeatherDataSource mWeatherRemoteDataSource;
    private final WeatherDataSource mWeatherLocalDataSource;

    @Inject
    WeatherRepository(@NonNull Context context, @Remote WeatherDataSource weatherRemoteDataSource, @Local WeatherDataSource weatherLocalDataSource) {
        checkNotNull(context);

        mContext = context;
        mWeatherRemoteDataSource = weatherRemoteDataSource;
        mWeatherLocalDataSource = weatherLocalDataSource;
    }

    @Override
    public Flowable<Weather> getCurrentWeather(String apiKey, String city, String units) {
        Flowable<Weather> flowable;
        if (NetworkUtil.isNetworkAvailable(mContext)) {
            flowable = mWeatherRemoteDataSource.getCurrentWeather(apiKey, city, units).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        } else {
            flowable = mWeatherLocalDataSource.getCurrentWeather(apiKey, city, units).observeOn(AndroidSchedulers.mainThread());
        }

        return flowable;
    }

    @Override
    public Flowable<Forecast> getForecast(String apiKey, String city, String units) {
        Flowable<Forecast> flowable;
        if (NetworkUtil.isNetworkAvailable(mContext)) {
            flowable = mWeatherRemoteDataSource.getForecast(apiKey, city, units).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        } else {
            flowable = mWeatherLocalDataSource.getForecast(apiKey, city, units).observeOn(AndroidSchedulers.mainThread());
        }

        return flowable;
    }

    @Override
    public void saveCurrentWeather(Weather weather) {
        mWeatherLocalDataSource.saveCurrentWeather(weather);
    }

    @Override
    public void saveForecast(Forecast forecast, String city) {
        mWeatherLocalDataSource.saveForecast(forecast, city);
    }
}
