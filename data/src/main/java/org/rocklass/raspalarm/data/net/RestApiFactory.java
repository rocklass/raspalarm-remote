package org.rocklass.raspalarm.data.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pbrochado on 31/05/2017.
 */

public class RestApiFactory {
    private static final String API_BASE_URL = "https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/";
    private static final int READ_TIMEOUT_IN_MILLISECONDS = 10000;
    private static final int CONNECT_TIMEOUT_IN_MILLISECONDS = 15000;

    public UserRestApi getUserRestApi() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT_IN_MILLISECONDS, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT_IN_MILLISECONDS, TimeUnit.SECONDS)
                .build();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(UserRestApi.class);
    }
}
