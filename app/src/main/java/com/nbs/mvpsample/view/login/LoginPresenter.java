package com.nbs.mvpsample.view.login;

import android.os.Handler;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.BasePresenter;
import com.nbs.mvpsample.data.DataManager;
import com.nbs.mvpsample.utils.CommonUtils;

import java.util.UUID;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ghiyatshanif on 3/2/17.
 */

public class LoginPresenter <V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {

    @Inject
    public LoginPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void doLogin(String email, String password) {
        if (!CommonUtils.isEmailValid(email)){
            getView().onError(R.string.invalid_email);
            return;
        }

//        mock Login
        getDataManager().setEmail(email);
        getDataManager().setAccessToken(String.valueOf(UUID.randomUUID()));

        getView().showToast("sdgasdfasghdfsa");
        getView().showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().hideLoading();
                getView().toMainActivity();
            }
        },1500);

    }
}
