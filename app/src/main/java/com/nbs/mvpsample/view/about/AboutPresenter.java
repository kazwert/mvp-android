package com.nbs.mvpsample.view.about;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.BasePresenter;
import com.nbs.mvpsample.data.DataManager;
import com.nbs.mvpsample.data.api.ApiManager;
import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by User on 15-Apr-17.
 */

public class AboutPresenter<V extends IAboutView > extends BasePresenter<V> implements IAboutPresenter<V> {

    @Inject
    public AboutPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    public void onViewready() {
        getView().setEmailAddress(getDataManager().getEmail());
    }

    private boolean checkInternetConnection() {
        boolean isConnected = getView().isNetworkAvailable();
        if (!isConnected) {
            getView().onError(R.string.no_internet_connection);
        }
        return isConnected;
    }

    public void loadEmailData() {
        checkInternetConnection();
        if (getDataManager().getAllEmails().size() != 0) {
            getView().populateData(getLocalEmails());
        }
        requestEmails();
    }

    private ArrayList<Email> getLocalEmails() {
        return (ArrayList<Email>) getDataManager().getAllEmails();
    }

    private void requestEmails() {
        getView().showLoading();
        getDataManager().loadMovies(new ApiManager.LoadMoviesListener() {
            @Override
            public void onSuccess(ArrayList<Email> movies) {
                getDataManager().deleteEmails();
                getDataManager().saveEmails(movies);
                getView().populateData(movies);
                getView().hideLoading();
            }

            @Override
            public void onFailure(String errorMessage) {
                getView().onError(errorMessage);
                getView().hideLoading();
            }
        });
    }
}
