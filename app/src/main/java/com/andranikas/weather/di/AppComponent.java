package com.andranikas.weather.di;

import android.app.Application;

import com.andranikas.weather.app.App;
import com.andranikas.weather.app.network.DBModule;
import com.andranikas.weather.app.network.NetworkModule;
import com.andranikas.weather.app.network.ServiceModule;
import com.andranikas.weather.data.source.WeatherRepository;
import com.andranikas.weather.data.source.WeatherRepositoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by andranikas on 10/18/2017.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        WeatherRepositoryModule.class,
        NetworkModule.class,
        DBModule.class,
        ServiceModule.class})

public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(App application);

    WeatherRepository getWeatherRepository();

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
