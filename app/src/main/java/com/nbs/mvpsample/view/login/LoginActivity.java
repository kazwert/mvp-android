package com.nbs.mvpsample.view.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.nbs.mvpsample.BuildConfig;
import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.BaseActivity;
import com.nbs.mvpsample.utils.ValidateUtils;
import com.nbs.mvpsample.view.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class LoginActivity extends BaseActivity implements ILoginView {

    @Inject
    LoginPresenter<ILoginView> loginPresenter;

    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_google_login)
    ImageButton btnGoogleLogin;
    @BindView(R.id.btn_fb_login)
    ImageButton btnFbLogin;

    EditText[] fieldsToValidate;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initLib() {
        getActivityComponent().inject(this);
        loginPresenter.onAttach(this);
    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initUI() {
        fieldsToValidate = new EditText[]{edtEmail, edtPassword};
        if (BuildConfig.DEBUG) {
            edtEmail.setText("dinanganteng@gmail.com");
            edtPassword.setText("dinan123");
        }
    }

    @Override
    protected void initAction() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    String email = edtEmail.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();
                    loginPresenter.doLogin(email, password);
                }
            }
        });
    }

    @Override
    public boolean validateFields() {
        return ValidateUtils.validate(getString(R.string.cant_be_empty), fieldsToValidate);
    }

    @Override
    public void toMainActivity() {
        MainActivity.start(LoginActivity.this);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }
}
