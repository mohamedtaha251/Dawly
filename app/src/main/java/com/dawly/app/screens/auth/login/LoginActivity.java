package com.dawly.app.screens.auth.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.ActivityLoginBinding;
import com.dawly.app.base.BaseActivity;
import com.dawly.app.base.BaseContract;
import com.dawly.app.entities.User;
import com.dawly.app.entities.ValidationError;
import com.dawly.app.views.DawlyEditText;
import com.facebook.CallbackManager;
import dagger.android.AndroidInjection;

import javax.inject.Inject;
import java.util.List;

public class LoginActivity extends BaseActivity implements LoginContract.LoginInteractor, BaseContract.ClickListener {
    @Inject
    LoginPresenterImpl loginPresenter;
    private CallbackManager callbackManager;
    ActivityLoginBinding activityLoginBinding;
    DawlyEditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        email = activityLoginBinding.email;
        password = activityLoginBinding.password;
        activityLoginBinding.setClickListener(this);
        getSupportActionBar().hide();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,
                resultCode, data);
    }

    @Override
    public void showValidationErrors(List<ValidationError> validationErrorList) {

    }

    @Override
    public void loginError(String message) {

    }

    @Override
    public void loginSuccess(User user) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                if (email.isValid(null) && password.isValid(null)) {
                    User user = new User();
                    user.setEmail("");
                    user.setPassword("");
                    loginPresenter.start(user);
                }
                break;
        }
    }
}
