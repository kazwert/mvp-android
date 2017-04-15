package com.nbs.mvpsample.data.db;

import com.nbs.mvpsample.data.db.libs.DbOpenHelper;
import com.nbs.mvpsample.data.sharedmodel.DaoMaster;
import com.nbs.mvpsample.data.sharedmodel.DaoSession;
import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ghiyatshanif on 2/23/17.
 */

public class DbManager implements IDbManager {
    private final DaoSession mDaoSession;

    @Inject
    public DbManager(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public void saveEmails(ArrayList<Email> emails) {
        for (Email e : emails) {
            mDaoSession.getEmailDao().insert(e);
        }
    }

    @Override
    public List<Email> getAllEmails() {
        return mDaoSession.getEmailDao().loadAll();
    }

    @Override
    public void deleteEmails() {
        mDaoSession.getEmailDao().deleteAll();
    }
}
