package com.andranikas.weather.app.network;

import com.andranikas.weather.data.service.DBService;
import com.andranikas.weather.data.service.WeatherService;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import retrofit2.Retrofit;

@Module
abstract public class ServiceModule {

    @Provides
    static WeatherService provideWeatherService(Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }

    @Provides
    static DBService provideDBService(Realm realm) {
        return new DBService(realm);
    }
}
