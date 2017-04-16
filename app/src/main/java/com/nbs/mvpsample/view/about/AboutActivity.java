package com.nbs.mvpsample.view.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.BaseActivity;
import com.nbs.mvpsample.data.sharedmodel.Email;
import com.nbs.mvpsample.view.adapters.AboutAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends BaseActivity implements IAboutView {
    @Inject
    AboutPresenter<IAboutView> aboutPresenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_email_address)
    TextView tvEmailAddress;
    @BindView(R.id.btn_about)
    Button btnAbout;
    @BindView(R.id.lv_inbox)
    ListView lvInbox;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    AboutAdapter aboutAdapter;
    ArrayList<Email> abouts;


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
        setupToolbar("About Us", false);
        abouts = new ArrayList<>();
        aboutAdapter = new AboutAdapter(AboutActivity.this, abouts);
        lvInbox.setAdapter(aboutAdapter);
        aboutPresenter.onViewready();
        aboutPresenter.loadEmailData();

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

    @Override
    public void setEmailAddress(String email) {
        tvEmailAddress.setText(email);
    }

    @Override
    public void populateData(ArrayList<Email> abouts) {
        aboutAdapter.clear();
        aboutAdapter.addOrUpdate(abouts);
        aboutAdapter.notifyDataSetChanged();
    }


    @Override
    public void setPhone(String phone) {

    }

}
