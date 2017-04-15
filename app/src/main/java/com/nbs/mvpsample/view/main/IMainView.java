package com.nbs.mvpsample.view.main;

import com.nbs.mvpsample.base.IBaseView;
import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;

/**
 * Created by ghiyatshanif on 2/23/17.
 */

public interface IMainView extends IBaseView {

    void setEmailAddress(String email);

    void populateData(ArrayList<Email> emails);


}
