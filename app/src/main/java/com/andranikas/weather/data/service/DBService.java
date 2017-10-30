package com.andranikas.weather.data.service;

import android.support.annotation.NonNull;

import com.andranikas.weather.data.entities.Forecast;
import com.andranikas.weather.data.entities.Weather;

import io.reactivex.Flowable;
import io.realm.Realm;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by andranikas on 10/30/2017.
 */

public class DBService {

    private final Realm mRealm;

    public DBService(@NonNull Realm realm) {
        checkNotNull(realm);

        mRealm = realm;
    }

    public Flowable<Weather> getCurrentWeather(String city) {
        Weather weather = mRealm.where(Weather.class).equalTo("name", city).findFirstAsync();
        return weather != null ? weather.asFlowable() : Flowable.empty();
    }

    public Flowable<Forecast> getForecast() {
        Forecast forecast = mRealm.where(Forecast.class).findFirstAsync();
        return forecast != null ? forecast.asFlowable() : Flowable.empty();
    }

    public void saveCurrentWeather(Weather weather) {
//        mRealm.beginTransaction();
//        mRealm.insertOrUpdate(weather);
//        mRealm.commitTransaction();
        mRealm.executeTransactionAsync(realm -> realm.insertOrUpdate(weather));
    }

    public void saveForecast(Forecast forecast, String city) {
        mRealm.executeTransactionAsync(realm -> {
            forecast.setName(city);
            realm.insertOrUpdate(forecast);
        });
//        mRealm.beginTransaction();
//        mRealm.insertOrUpdate(forecast);
//        mRealm.commitTransaction();
    }
}
