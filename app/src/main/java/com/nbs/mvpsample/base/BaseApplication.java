package com.nbs.mvpsample.base;

import android.app.Application;

import com.nbs.mvpsample.BuildConfig;
import com.nbs.mvpsample.di.components.ApplicationComponent;
import com.nbs.mvpsample.di.components.DaggerApplicationComponent;
import com.nbs.mvpsample.di.modules.ApplicationModule;
import com.nbs.mvpsample.utils.ContextProvider;

import timber.log.Timber;

/**
 * Created by ghiyatshanif on 2/21/17.
 */

public class BaseApplication extends Application {

    private ApplicationComponent mApplicationComponent ;

    @Override
    public void onCreate() {
        super.onCreate();

        ContextProvider.initialize(getApplicationContext());

        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent mApplicationComponent) {
        this.mApplicationComponent = mApplicationComponent;
    }
}
