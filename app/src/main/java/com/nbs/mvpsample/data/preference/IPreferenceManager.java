package com.nbs.mvpsample.data.preference;

/**
 * Created by ghiyatshanif on 2/23/17.
 * purpose : Interface for PreferenceManager, put all corresponding getters/setters method here
 */

public interface IPreferenceManager {
    void setAccessToken(String accessToken);

    String getAccessToken();

    void setEmail(String username);

    String getEmail();
}
