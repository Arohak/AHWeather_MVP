package com.andranikas.weather.cityweather.presenter;

import com.andranikas.weather.cityweather.view.fragments.CityFragment;
import com.andranikas.weather.cityweather.view.fragments.CurrentWeatherFragment;
import com.andranikas.weather.cityweather.view.fragments.ForecastFragment;
import com.andranikas.weather.di.ActivityScoped;
import com.andranikas.weather.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by andranikas on 10/19/2017.
 */

@Module
public abstract class WeatherModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract CurrentWeatherFragment currentWeatherFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract ForecastFragment forecastFragment();

    @FragmentScoped
    @ContributesAndroidInjector
    abstract CityFragment cityFragment();

    @ActivityScoped
    @Binds
    abstract WeatherContract.Presenter weatherPresenter(WeatherPresenter presenter);
}
