package com.dawly.app.screens.auth;

import android.content.Intent;
import android.os.Bundle;
import app.dawly.com.dawly.R;
import com.dawly.app.base.BaseActivity;
import com.dawly.app.entities.User;
import com.dawly.app.entities.ValidationError;
import com.facebook.CallbackManager;
import dagger.android.AndroidInjection;

import javax.inject.Inject;
import java.util.List;

public class LoginActivity extends BaseActivity implements LoginContract.LoginInteractor {
    @Inject
    LoginPresenterImpl loginPresenter;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
