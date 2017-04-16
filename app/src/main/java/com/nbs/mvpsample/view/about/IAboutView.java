package com.nbs.mvpsample.view.about;

import com.nbs.mvpsample.base.IBaseView;
import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;

/**
 * Created by User on 15-Apr-17.
 */

public interface IAboutView extends IBaseView {
    void setEmailAddress(String email);

    void populateData(ArrayList<Email> abouts);

    void setPhone(String phone);


}
