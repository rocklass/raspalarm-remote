package org.rocklass.raspalarm.data.net;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pbrochado on 31/05/2017.
 */

public class RestApiFactory {
    private static final String USER_API_BASE_URL = "https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/";
    private static final String DEVICE_API_BASE_URL = "http://127.0.0.1:8080/device/";
    private static final int READ_TIMEOUT_IN_MILLISECONDS = 10000;
    private static final int CONNECT_TIMEOUT_IN_MILLISECONDS = 15000;

    public UserRestApi getUserRestApi() {
        return getRestApi(USER_API_BASE_URL).create(UserRestApi.class);
    }

    public DeviceRestApi getDeviceRestApi() {
        return getRestApi(DEVICE_API_BASE_URL).create(DeviceRestApi.class);
    }

    @NonNull
    private Retrofit getRestApi(final String baseUrl) {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT_IN_MILLISECONDS, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT_IN_MILLISECONDS, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
