package com.nbs.mvpsample.di.modules;

import com.nbs.mvpsample.data.api.ApiManager;
import com.nbs.mvpsample.data.api.IApiManager;
import com.nbs.mvpsample.data.api.libs.ApiClient;
import com.nbs.mvpsample.data.api.libs.ApiService;
import com.nbs.mvpsample.data.api.libs.HeaderInterceptor;
import com.nbs.mvpsample.data.api.libs.ParameterInterceptor;
import com.nbs.mvpsample.data.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ghiyatshanif on 2/8/17.
 */

@Module
public class ApiTestModule {

    @Provides
    HeaderInterceptor provideHeaderInterceptor(PreferenceManager preferenceManager){
        return new HeaderInterceptor(preferenceManager);
    }

    @Provides
    ParameterInterceptor provideParameterInterceptor(PreferenceManager preferenceManager){
        return new ParameterInterceptor(preferenceManager);
    }

    @Singleton
    @Provides
    ApiClient provideApiClient(HeaderInterceptor headerInterceptor, ParameterInterceptor parameterInterceptor){
        return ApiService.createService(ApiClient.class,headerInterceptor,parameterInterceptor);
    }

    @Singleton
    @Provides
    IApiManager provideApiManager(ApiManager apiManager){
        return apiManager;
    }

}
