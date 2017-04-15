package com.nbs.mvpsample.data.api;

/**
 * Created by ghiyatshanif on 2/23/17.
 */

public interface IApiManager {
    void loadEmails(ApiManager.LoadEmailListener listener);
}
