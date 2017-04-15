package com.nbs.mvpsample.view.about;

import com.nbs.mvpsample.base.BasePresenter;
import com.nbs.mvpsample.data.DataManager;

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
}
