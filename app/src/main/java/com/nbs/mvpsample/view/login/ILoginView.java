package com.nbs.mvpsample.view.login;

import com.nbs.mvpsample.base.IBaseView;

/**
 * Created by ghiyatshanif on 3/2/17.
 */

public interface ILoginView extends IBaseView{

    boolean validateFields();

    void toMainActivity();
}
