package com.nbs.mvpsample.view.login;

import com.nbs.mvpsample.base.IBasePresenter;

/**
 * Created by ghiyatshanif on 3/2/17.
 */

public interface ILoginPresenter <V extends ILoginView> extends IBasePresenter<V>{

    void doLogin(String username, String password);
}
