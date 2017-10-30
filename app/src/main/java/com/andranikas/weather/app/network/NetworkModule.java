package com.andranikas.weather.app.network;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class NetworkModule {

    private final static String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    @Provides
    @NonNull
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClientFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
