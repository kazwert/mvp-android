package com.nbs.mvpsample.di.modules;

import android.app.Application;
import android.content.Context;

import com.nbs.mvpsample.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ghiyatshanif on 2/21/17.
 */
@Module
public class ApplicationTestModule {
    private Application mApplication;

    public ApplicationTestModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @ApplicationContext
    @Provides
    Context provideApplicationContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }



}
