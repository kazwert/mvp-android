package com.nbs.mvpsample.data.db;

import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghiyatshanif on 2/23/17.
 */

public interface IDbManager {
    void saveEmails(ArrayList<Email> emails);

    List<Email> getAllEmails();

    void deleteEmails();

}
