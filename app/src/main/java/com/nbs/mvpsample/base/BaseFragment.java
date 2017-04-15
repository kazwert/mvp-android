package com.nbs.mvpsample.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nbs.mvpsample.di.components.ActivityComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment implements IBaseView {

    private BaseActivity mActivity;
    private Unbinder mUnBinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(getLayoutResource(),container,false);
        setUnBinder(ButterKnife.bind(view));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onViewReady();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading() {
        if (mActivity != null) {
            mActivity.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (mActivity != null) {
            mActivity.hideLoading();
        }
    }

    @Override
    public void setupToolbar(Toolbar toolbar, String title, boolean isChild) {
        mActivity.setupToolbar(toolbar,title, isChild);
    }

    @Override
    public void setupToolbar(String title, boolean isChild) {
        mActivity.setupToolbar(title, isChild);
    }

    @Override
    public void showAlert(String message) {
        mActivity.showAlert(message);
    }

    @Override
    public void showToast(String message) {
        mActivity.showToast(message);
    }

    @Override
    public void showSnackbar(String message) {
        mActivity.showSnackbar(message);
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void onError(int stringResource) {
        mActivity.onError(stringResource);
    }

    @Override
    public boolean isNetworkAvailable() {
        return mActivity.isNetworkAvailable();
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    public ActivityComponent getActivityComponent() {
        return mActivity.getActivityComponent();
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    private void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract void setUp(View view);

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }


    private void onViewReady(){
        initIntent();
        initUI();
        initAction();
    }

    protected abstract int getLayoutResource();

    protected abstract void initIntent();

    protected abstract void initUI();

    protected abstract void initAction();

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}