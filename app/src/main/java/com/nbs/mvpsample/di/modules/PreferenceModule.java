package com.nbs.mvpsample.di.modules;

import com.nbs.mvpsample.data.preference.IPreferenceManager;
import com.nbs.mvpsample.data.preference.PreferenceManager;
import com.nbs.mvpsample.di.PreferenceInfo;
import com.nbs.mvpsample.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ghiyatshanif on 2/8/17.
 */

@Module
public class PreferenceModule {

    @PreferenceInfo
    @Provides
    String providePrefname() {
        return AppConstants.PREF_NAME;
    }

    @Singleton
    @Provides
    IPreferenceManager providePreferenceManager(PreferenceManager preferenceManager) {
        return preferenceManager;
    }
}
