package com.andranikas.weather.app;

import com.andranikas.weather.di.AppComponent;
import com.andranikas.weather.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by andranikas on 10/18/2017.
 */

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
