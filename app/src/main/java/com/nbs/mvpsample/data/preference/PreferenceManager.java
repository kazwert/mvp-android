package com.nbs.mvpsample.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.nbs.mvpsample.di.ApplicationContext;
import com.nbs.mvpsample.di.PreferenceInfo;

import javax.inject.Inject;

/**
 * Created by ghiyatshanif on 2/23/17.
 * purpose : Application preference class
 */

public class PreferenceManager implements IPreferenceManager{

//    put all preference keys here
    private static final String KEY_PREF_ACCESS_TOKEN = "KEY_PREF_ACCESS_TOKEN";
    private static final String KEY_PREF_EMAIL = "KEY_PREF_EMAIL";


    private SharedPreferences mPreferences;

    @Inject
    public PreferenceManager(@ApplicationContext Context context,
                             @PreferenceInfo String prefName){
        mPreferences = context.getSharedPreferences(prefName,Context.MODE_PRIVATE);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferences.edit().putString(KEY_PREF_ACCESS_TOKEN,accessToken).apply();
    }

    @Override
    public String getAccessToken() {
        return mPreferences.getString(KEY_PREF_ACCESS_TOKEN,"");
    }

    @Override
    public void setEmail(String username) {
        mPreferences.edit().putString(KEY_PREF_EMAIL, username).apply();
    }

    @Override
    public String getEmail() {
        return mPreferences.getString(KEY_PREF_EMAIL,"");
    }
}
