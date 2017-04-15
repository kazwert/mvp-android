package com.nbs.mvpsample.view.splash;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.BaseActivity;
import com.nbs.mvpsample.view.login.LoginActivity;
import com.nbs.mvpsample.view.main.MainActivity;

import javax.inject.Inject;

public class SplashScreenActivity extends BaseActivity implements ISplashView {

    @Inject
    SplashPresenter<ISplashView> splashPresenter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void initLib() {
        getActivityComponent().inject(SplashScreenActivity.this);
        splashPresenter.onAttach(this);
    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initAction() {

    }

    @Override
    public void toLoginActivity() {
        LoginActivity.start(SplashScreenActivity.this);
        finish();
    }

    @Override
    public void toMainActivity() {
        MainActivity.start(SplashScreenActivity.this);
        finish();
    }
}