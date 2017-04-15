package com.nbs.mvpsample.di.components;

import com.nbs.mvpsample.di.PerActivity;
import com.nbs.mvpsample.di.modules.ActivityModule;
import com.nbs.mvpsample.view.about.AboutActivity;
import com.nbs.mvpsample.view.login.LoginActivity;
import com.nbs.mvpsample.view.main.MainActivity;
import com.nbs.mvpsample.view.splash.SplashScreenActivity;

import dagger.Component;

/**
 * Created by ghiyatshanif on 2/8/17.
 */

@PerActivity
@Component (modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(SplashScreenActivity splashScreenActivity);

    void inject(AboutActivity aboutActivity);
}
