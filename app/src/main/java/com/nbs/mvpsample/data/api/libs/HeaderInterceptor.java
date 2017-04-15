package com.nbs.mvpsample.data.api.libs;

import com.nbs.mvpsample.data.preference.PreferenceManager;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ghiyatshanif on 2/27/17.
 * purpose : put all default header that you want to be add to every request here e.g applicationType/apikey
 */

public class HeaderInterceptor implements Interceptor {

    private PreferenceManager mPreferenceManager;

    @Inject
    public HeaderInterceptor(PreferenceManager mPreferenceManager) {
        this.mPreferenceManager =  mPreferenceManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("Key","Value");

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
