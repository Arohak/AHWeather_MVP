package com.andranikas.weather.di;

import com.andranikas.weather.cityweather.presenter.WeatherModule;
import com.andranikas.weather.cityweather.view.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by andranikas on 10/18/2017.
 */

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = WeatherModule.class)
    abstract MainActivity weatherActivity();
}
