package com.andranikas.weather.data.source;

import com.andranikas.weather.data.source.local.WeatherLocalDataSource;
import com.andranikas.weather.data.source.remote.WeatherRemoteDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Created by andranikas on 10/20/2017.
 */

@Module
abstract public class WeatherRepositoryModule {

    @Singleton
    @Binds
    @Local
    abstract WeatherDataSource provideWeatherLocalDataSource(WeatherLocalDataSource dataSource);

    @Singleton
    @Binds
    @Remote
    abstract WeatherDataSource provideWeatherRemoteDataSource(WeatherRemoteDataSource dataSource);
}
