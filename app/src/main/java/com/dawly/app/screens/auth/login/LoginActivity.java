package com.dawly.app.screens.auth.login;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
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

public class LoginActivity extends BaseActivity implements LoginContract.LoginInteractor {
    @Inject
    LoginPresenterImpl loginPresenter;
    CallbackManager callbackManager;
    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //init
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        //    loginBinding.setClickListener(this);

        getSupportActionBar().hide();

        actions();

    }

    private void actions() {
        loginBinding.btnSwitchToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBinding.signInFrame.setVisibility(View.VISIBLE);
                loginBinding.signUpFrame.setVisibility(View.INVISIBLE);
                loginBinding.signCard.bringToFront();
            }
        });

        loginBinding.btnSwitchToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBinding.signInFrame.setVisibility(View.INVISIBLE);
                loginBinding.signUpFrame.setVisibility(View.VISIBLE);
            }
        });

        loginBinding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginBinding.signInFrame.getVisibility()==View.VISIBLE)
                {

                }
            }
        });
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
