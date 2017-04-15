package com.nbs.mvpsample.view.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.BaseActivity;
import com.nbs.mvpsample.view.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends BaseActivity implements IAboutView {
    @Inject
    AboutPresenter<IAboutView> aboutPresenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv_about_description)
    TextView tvAboutDescription;
    @BindView(R.id.tv_about_phone)
    TextView tvAboutPhone;
    @BindView(R.id.tv_about_facebook)
    TextView tvAboutFacebook;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_about;
    }

    @Override
    protected void initLib() {
        getActivityComponent().inject(AboutActivity.this);
        aboutPresenter.onAttach(this);
    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initAction() {

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, AboutActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
