package com.nbs.mvpsample.di.modules;

import com.nbs.mvpsample.data.db.DbManager;
import com.nbs.mvpsample.data.db.IDbManager;
import com.nbs.mvpsample.di.DatabaseInfo;
import com.nbs.mvpsample.utils.AppConstants;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ghiyatshanif on 2/8/17.
 */

@Module
public class DbModule {

    @DatabaseInfo
    @Provides
    String provideDbName(){
        return AppConstants.DB_NAME;
    }

    @Provides
    IDbManager provideDbManager(DbManager dbManager){
        return dbManager;
    }
}
