package com.nbs.mvpsample.data.api.libs;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nbs.mvpsample.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ghiyatshanif on 2/23/17.
 * purpose : generate retrofit service class
 */

public class ApiService {

    private ApiService() {

    }

    public static <S> S createService(Class<S> serviceClass
            , @Nullable HeaderInterceptor headerInterceptor
            , @Nullable ParameterInterceptor parameterInterceptor) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        if (headerInterceptor != null) {
            builder.addInterceptor(headerInterceptor);
        }

        if (parameterInterceptor != null) {
            builder.addInterceptor(parameterInterceptor);
        }

        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor).build();
        }

        Gson gson = new GsonBuilder()
                .create();

        OkHttpClient okHttpClient =  builder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(serviceClass);
    }
}
