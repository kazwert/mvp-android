package com.nbs.mvpsample.base;

import android.support.v7.widget.Toolbar;

public interface IBaseView {

    void setupToolbar(Toolbar toolbar, String title, boolean isChild);

    void setupToolbar(String title, boolean isChild);

    void showLoading();

    void hideLoading();

    void onError(String message);

    void onError(int stringResource);

    void showAlert(String message);

    void showToast(String message);

    void showSnackbar(String message);

    boolean isNetworkAvailable();

}