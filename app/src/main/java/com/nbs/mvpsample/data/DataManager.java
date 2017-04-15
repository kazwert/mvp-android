package com.nbs.mvpsample.data;

import com.nbs.mvpsample.data.api.ApiManager;
import com.nbs.mvpsample.data.api.IApiManager;
import com.nbs.mvpsample.data.db.IDbManager;
import com.nbs.mvpsample.data.preference.IPreferenceManager;
import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by ghiyatshanif on 2/20/17.
 * purpose : Class that handles all database request, delegate all method to each corresponding helpers
 */

@Singleton
public class DataManager implements IDataManager {
    private final IApiManager mApiManager;
    private final IPreferenceManager mPreferenceManager;
    private final IDbManager mDbManager;


    @Inject
    public DataManager(IApiManager mApiManager, IPreferenceManager mPreferenceManager, IDbManager mDbManager) {
        this.mApiManager = mApiManager;
        this.mPreferenceManager = mPreferenceManager;
        this.mDbManager = mDbManager;
    }

    ///////////////////////////////////////////////////////////////////////////
    // API IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void loadEmails(ApiManager.LoadEmailListener listener) {
        mApiManager.loadEmails(listener);
    }


    ///////////////////////////////////////////////////////////////////////////
    // END OF API IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////
    // PREFERENCE IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void saveUserSession(String accessToken, String username) {

    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferenceManager.setAccessToken(accessToken);
    }

    @Override
    public String getAccessToken() {
        return mPreferenceManager.getAccessToken();
    }

    @Override
    public void setEmail(String username) {
        mPreferenceManager.setEmail(username);
    }

    @Override
    public String getEmail() {
        return mPreferenceManager.getEmail();
    }

    ///////////////////////////////////////////////////////////////////////////
    // END OF PREFERENCE IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////
    // DB IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void saveEmails(ArrayList<Email> emails) {
        mDbManager.saveEmails(emails);
    }

    @Override
    public List<Email> getAllEmails() {
        return mDbManager.getAllEmails();
    }

    @Override
    public void deleteEmails() {
        mDbManager.deleteEmails();
    }

    ///////////////////////////////////////////////////////////////////////////
    // END OF DB IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////

}
