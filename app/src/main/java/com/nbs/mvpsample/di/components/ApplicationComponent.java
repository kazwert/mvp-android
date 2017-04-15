package com.nbs.mvpsample.di.components;

import android.app.Application;
import android.content.Context;

import com.nbs.mvpsample.base.BaseApplication;
import com.nbs.mvpsample.data.DataManager;
import com.nbs.mvpsample.di.ApplicationContext;
import com.nbs.mvpsample.di.modules.ApiModule;
import com.nbs.mvpsample.di.modules.ApplicationModule;
import com.nbs.mvpsample.di.modules.DbModule;
import com.nbs.mvpsample.di.modules.PreferenceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ghiyatshanif on 2/8/17.
 */

@Singleton
@Component (modules = {ApplicationModule.class, ApiModule.class, DbModule.class, PreferenceModule.class})
public interface ApplicationComponent {

    void inject(BaseApplication baseApplication);

    DataManager getDataManager();


    @ApplicationContext
    Context getContext();

    Application getApplication();

}
