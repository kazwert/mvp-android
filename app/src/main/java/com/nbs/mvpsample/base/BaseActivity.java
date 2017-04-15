
package com.nbs.mvpsample.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.di.components.ActivityComponent;
import com.nbs.mvpsample.di.components.DaggerActivityComponent;
import com.nbs.mvpsample.di.modules.ActivityModule;
import com.nbs.mvpsample.utils.MessageFactory;
import com.nbs.mvpsample.utils.NetworkUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity
        implements IBaseView, BaseFragment.Callback {

    private ProgressDialog mProgressDialog;

    private ActivityComponent mActivityComponent;

    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((BaseApplication) getApplication()).getComponent())
                .build();

        setContentView(getLayoutResource());
        setUnbinder(ButterKnife.bind(this));

        onViewReady();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }


    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void setupToolbar(Toolbar toolbar, String title, boolean isChild) {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isChild);
        }
    }

    @Override
    public void setupToolbar(String title, boolean isChild) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isChild);
        }
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = MessageFactory.showLoadingDialog(this, getString(R.string.please_wait));
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackbar(message);
        } else {
            showSnackbar(getString(R.string.error));
        }
    }

    @Override
    public void onError(int stringResource) {
        onError(getString(stringResource));
    }

    @Override
    public void showSnackbar(String message) {
        MessageFactory.showSnackbarMessage(findViewById(android.R.id.content), message);
    }

    @Override
    public void showToast(String message) {
        MessageFactory.showToast(message);
    }

    @Override
    public void showAlert(String message) {
        MessageFactory.showAlertDialog(message);
    }

    @Override
    public boolean isNetworkAvailable() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    private void setUnbinder(Unbinder unbinder) {
        this.mUnBinder = unbinder;
    }

    private void onViewReady() {
        initLib();
        initIntent();
        initUI();
        initAction();
    }

    protected abstract int getLayoutResource();

    protected abstract void initLib();

    protected abstract void initIntent();

    protected abstract void initUI();

    protected abstract void initAction();
}