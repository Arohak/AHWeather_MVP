package com.andranikas.weather.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by andranikas on 10/18/2017.
 */

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);
}

