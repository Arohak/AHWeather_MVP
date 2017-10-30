package com.andranikas.weather.app.network;

import android.content.Context;
import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by andranikas on 10/30/2017.
 */

@Module
public abstract class DBModule {

    @Provides
    @NonNull
    static Realm provideRealm(Context context) {
        Realm.init(context);
        return Realm.getDefaultInstance();
    }
}