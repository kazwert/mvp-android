package com.nbs.mvpsample.data;

import com.nbs.mvpsample.data.api.IApiManager;
import com.nbs.mvpsample.data.db.IDbManager;
import com.nbs.mvpsample.data.preference.IPreferenceManager;

/**
 * Created by ghiyatshanif on 2/28/17.
 */

public interface IDataManager extends IPreferenceManager, IApiManager, IDbManager {

//    dummy function
    void saveUserSession(String accessToken, String username);
}
