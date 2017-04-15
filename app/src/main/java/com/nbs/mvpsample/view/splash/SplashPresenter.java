package com.nbs.mvpsample.view.splash;

import android.os.Handler;

import com.nbs.mvpsample.base.BasePresenter;
import com.nbs.mvpsample.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ghiyatshanif on 2/23/17.
 */

public class SplashPresenter<V extends ISplashView>  extends BasePresenter<V> implements ISplashPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }


    @Override
    public void onAttach(V view) {
        super.onAttach(view);

        Handler handler =  new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                decideNextPage();
            }
        };

//        wait 3 seconds
        handler.postDelayed(r, 3000);
    }

    private void decideNextPage(){
        if (getDataManager().getAccessToken().equals("")){
            getView().toLoginActivity();
        }else {
            getView().toMainActivity();
        }
    }
}
