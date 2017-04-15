package com.nbs.mvpsample.view.main;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.BasePresenter;
import com.nbs.mvpsample.data.DataManager;
import com.nbs.mvpsample.data.api.ApiManager;
import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ghiyatshanif on 2/23/17.
 */

public class MainPresenter<V extends IMainView> extends BasePresenter<V> implements IMainPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onViewready() {
        getView().setEmailAddress(getDataManager().getEmail());
    }

    @Override
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
        getDataManager().loadEmails(new ApiManager.LoadEmailListener() {
            @Override
            public void onSuccess(ArrayList<Email> emails) {
                getDataManager().deleteEmails();
                getDataManager().saveEmails(emails);
                getView().populateData(emails);
                getView().hideLoading();
            }

            @Override
            public void onFailure(String errorMessage) {
                getView().onError(errorMessage);
                getView().hideLoading();
            }
        });
    }

    private boolean checkInternetConnection() {
        boolean isConnected = getView().isNetworkAvailable();
        if (!isConnected) {
            getView().onError(R.string.no_internet_connection);
        }
        return isConnected;
    }
}
