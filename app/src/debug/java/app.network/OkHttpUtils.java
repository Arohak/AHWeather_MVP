package app.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by andranikas on 10/20/2017.
 */

public class OkHttpUtils {

    public static void enableLogging(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);
    }
}