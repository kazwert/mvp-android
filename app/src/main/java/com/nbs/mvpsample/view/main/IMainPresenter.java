package com.nbs.mvpsample.view.main;

import com.nbs.mvpsample.base.IBasePresenter;
import com.nbs.mvpsample.base.IBaseView;

/**
 * Created by ghiyatshanif on 2/23/17.
 */

public interface IMainPresenter <V extends IBaseView> extends IBasePresenter<V> {

    void onViewready();

    void loadEmailData();
}
