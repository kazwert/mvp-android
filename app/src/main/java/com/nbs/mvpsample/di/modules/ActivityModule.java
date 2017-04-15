package com.nbs.mvpsample.di.modules;

import android.app.Activity;
import android.content.Context;

import com.nbs.mvpsample.view.login.ILoginPresenter;
import com.nbs.mvpsample.view.login.ILoginView;
import com.nbs.mvpsample.view.login.LoginPresenter;
import com.nbs.mvpsample.view.main.IMainPresenter;
import com.nbs.mvpsample.view.main.MainPresenter;
import com.nbs.mvpsample.view.main.IMainView;
import com.nbs.mvpsample.view.splash.ISplashPresenter;
import com.nbs.mvpsample.view.splash.SplashPresenter;
import com.nbs.mvpsample.view.splash.ISplashView;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ghiyatshanif on 2/21/17.
 */

@Module
public class  ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity(Activity mActivity) {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    IMainPresenter<IMainView> provideMainPresenter(MainPresenter<IMainView> mainPresenter){
        return mainPresenter;
    }

    @Provides
    ISplashPresenter<ISplashView> provideSplashPresenter(SplashPresenter<ISplashView> splashPresenter){
        return splashPresenter;
    }

    @Provides
    ILoginPresenter<ILoginView> provideLoginPresenter(LoginPresenter<ILoginView> loginPresenter){
        return loginPresenter;
    }
}
