package com.nbs.mvpsample.view.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.BaseActivity;
import com.nbs.mvpsample.data.sharedmodel.Email;
import com.nbs.mvpsample.view.about.AboutActivity;
import com.nbs.mvpsample.view.adapters.EmailAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements IMainView {

    @Inject
    MainPresenter<IMainView> mainPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_email_address)
    TextView tvEmailAddress;
    @BindView(R.id.lv_inbox)
    ListView lvInbox;
    @BindView(R.id.btn_about)
    Button btnAbout;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    EmailAdapter emailAdapter;
    ArrayList<Email> emails;

    private static final int PERMISSION_REQUEST = 716;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initLib() {
        getActivityComponent().inject(MainActivity.this);
        mainPresenter.onAttach(this);

        String[] permissions = new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET
        };

        requestPermissionsSafely(permissions, PERMISSION_REQUEST);

    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initUI() {
        setupToolbar(toolbar, "Inbox", false);

        emails = new ArrayList<>();
        emailAdapter = new EmailAdapter(MainActivity.this, emails);
        lvInbox.setAdapter(emailAdapter);
        mainPresenter.onViewready();
        mainPresenter.loadEmailData();


    }

    @Override
    protected void initAction() {

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutActivity.start(MainActivity.this);
            }
        });

        lvInbox.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast("aduh mas!");
            }
        });

    }

    @Override
    public void setEmailAddress(String email) {

        tvEmailAddress.setText(email);
    }

    @Override
    public void populateData(ArrayList<Email> emails) {
        emailAdapter.clear();
        emailAdapter.addOrUpdate(emails);
        emailAdapter.notifyDataSetChanged();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
