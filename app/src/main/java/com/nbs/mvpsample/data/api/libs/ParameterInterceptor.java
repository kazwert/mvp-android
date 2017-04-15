package com.nbs.mvpsample.data.api.libs;

import com.nbs.mvpsample.data.preference.PreferenceManager;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ghiyatshanif on 2/27/17.
 * purpose : put all default parameter that you want to be add to every request here e.g access token
 */

public class ParameterInterceptor implements Interceptor {

    private PreferenceManager mPreferenceManager;

    @Inject
    public ParameterInterceptor(PreferenceManager mPreferenceManager) {
        this.mPreferenceManager =  mPreferenceManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", mPreferenceManager.getAccessToken())
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
