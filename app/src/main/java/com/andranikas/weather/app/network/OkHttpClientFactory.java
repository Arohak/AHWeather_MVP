package com.andranikas.weather.app.network;

import app.network.OkHttpUtils;
import okhttp3.OkHttpClient;

/**
 * Created by andranikas on 10/20/2017.
 */

public final class OkHttpClientFactory extends Client.Factory {

    public static OkHttpClient create() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        OkHttpUtils.enableLogging(builder);

        return builder.build();
    }

    private OkHttpClientFactory() {
    }
}
