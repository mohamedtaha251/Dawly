package com.dawly.app.screens.auth.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.ActivityLoginBinding;
import com.dawly.app.base.BaseActivity;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.SignUpResponse;
import com.facebook.CallbackManager;
import dagger.android.AndroidInjection;

import javax.inject.Inject;

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
        loginBinding.signCard.bringToFront();
        getSupportActionBar().hide();

        actions();

    }

    private void actions() {
        loginBinding.btnSwitchToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBinding.signInFrame.setVisibility(View.VISIBLE);
                loginBinding.signUpFrame.setVisibility(View.INVISIBLE);
                loginBinding.loginBtn.setText(R.string.sign_in);

            }
        });

        loginBinding.btnSwitchToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBinding.signInFrame.setVisibility(View.INVISIBLE);
                loginBinding.signUpFrame.setVisibility(View.VISIBLE);
                loginBinding.loginBtn.setText(R.string.sign_up);
            }
        });

        loginBinding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginBinding.signInFrame.getVisibility() == View.VISIBLE) {

                    //collect data from UI
                    String email = loginBinding.loginEmail.getText().toString();
                    String password = loginBinding.loginPassword.getText().toString();

                    //create user
                    User user = new User();
                    user.setEmail(email);
                    user.setPassword(password);

                    loginPresenter.loginWithFacebook(user);
                } else {
                    //collect data from UI
                    String fname = loginBinding.signupFirstName.getText().toString();
                    String lname = loginBinding.etSignUpLastName.getText().toString();
                    String password = loginBinding.signupPassword.getText().toString();
                    String email = loginBinding.signupEmail.getText().toString();
                    String phone = loginBinding.etPhoneNumber.getText().toString();

                    //create user
                    User user = new User();
                    user.setFisrtName(fname);
                    user.setLastName(lname);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setPhone(phone);

                    loginPresenter.signUp(user);


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
    public void showValidationErrors(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void signUpError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signUpSuccess(SignUpResponse signUpResponse) {
        Toast.makeText(this, signUpResponse.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(LoginResponse loginResponse) {
        Toast.makeText(this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();

    }

}
