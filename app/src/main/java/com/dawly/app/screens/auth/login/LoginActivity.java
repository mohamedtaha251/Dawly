package com.dawly.app.screens.auth.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.ActivityLoginBinding;
import com.dawly.app.base.BaseActivity;
import com.dawly.app.base.BaseContract;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.SignUpResponse;
import com.dawly.app.utils.Validation;
import com.dawly.app.views.DawlyEditText;
import com.facebook.CallbackManager;
import dagger.android.AndroidInjection;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.LoginInteractor, BaseContract.ClickListener {
    @Inject
    LoginPresenterImpl loginPresenter;
    CallbackManager callbackManager;
    ActivityLoginBinding loginBinding;
    DawlyEditText etSignUpFirstName,
            etSignUpLastName,
            etSignUpPassword,
            etSignUpConfirmPassword,
            etSignUpEmail,
            etPhoneNumber;

    TextInputLayout signUpEmailInput, signUpPasswordInput, confirmPasswordInput, firstNameInput, lastNameInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //init
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        etSignUpFirstName = loginBinding.signUpFrame.signupFirstName;
        etSignUpLastName = loginBinding.signUpFrame.etSignUpLastName;
        etSignUpPassword = loginBinding.signUpFrame.signupPassword;
        etPhoneNumber = loginBinding.signUpFrame.etPhoneNumber;
        etSignUpConfirmPassword = loginBinding.signUpFrame.signupConfirmPassword;
        etSignUpEmail = loginBinding.signUpFrame.signupEmail;
        signUpEmailInput = loginBinding.signUpFrame.signupEmailInput;
        signUpPasswordInput = loginBinding.signUpFrame.signupPasswordInput;
        confirmPasswordInput = loginBinding.signUpFrame.signupConfirmPasswordInput;
        firstNameInput = loginBinding.signUpFrame.signupFirstNameInput;
        lastNameInput = loginBinding.signUpFrame.lastNameInput;


        loginBinding.setClickListener(this);
        loginBinding.signCard.bringToFront();
        getSupportActionBar().hide();

    }


    private boolean validateLogin() {
        if (loginBinding.loginEmail.getText().toString().equals("")) {
            loginBinding.loginEmail.setError("email is required");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(loginBinding.loginEmail.getText().toString()).matches()) {
            loginBinding.loginEmail.setError("invalid email");
            return false;
        }

        if (loginBinding.loginPassword.getText().toString().equals("")) {
            loginBinding.loginPassword.setError("password is required");
            return false;
        }

        return true;
    }

    private boolean validateSignup() {
        if (etSignUpFirstName.getText().toString().equals("")) {
            etSignUpFirstName.setError("First name is required");
            return false;
        }

        if (etSignUpFirstName.getText().toString().length() < 3) {
            etSignUpFirstName.setError("First name is too short");
            return false;
        }

        if (etSignUpLastName.getText().toString().equals("")) {
            etSignUpLastName.setError("Last name is required");
            return false;
        }

        if (etSignUpLastName.getText().toString().length() < 3) {
            etSignUpLastName.setError("Last name is too short");
            return false;
        }

        if (etSignUpPassword.getText().toString().equals("")) {
            etSignUpPassword.setError("password is required");
            return false;
        }

        if (etSignUpPassword.getText().toString().length() < 6) {
            etSignUpPassword.setError("at least 6 digit");
            return false;
        }

        if (!Validation.isContainLowerCase(etSignUpPassword.getText().toString())) {
            etSignUpPassword.setError("at least one lower case letter");
            return false;
        }

        if (!Validation.isContainUpperCase(etSignUpPassword.getText().toString())) {
            etSignUpPassword.setError("at least one upper case letter");
            return false;
        }

        if (!etSignUpPassword.getText().toString().equals(etSignUpConfirmPassword.getText().toString())) {
            etSignUpConfirmPassword.setError("Password is not matched");
            return false;
        }

        if (etSignUpEmail.getText().toString().equals("")) {
            etSignUpEmail.setError("email is required");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(etSignUpEmail.getText().toString()).matches()) {
            etSignUpEmail.setError("invalid email");
            return false;
        }

        if (etPhoneNumber.getText().toString().equals("")) {
            etPhoneNumber.setError("phone is required");
            return false;
        }

        if (etPhoneNumber.getText().toString().length() < 10) {
            etPhoneNumber.setError("invalid phone");
            return false;
        }
        return true;
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
        Toast.makeText(this, "User not Found", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                signUp();
                break;
            case R.id.btn_switch_to_sign_up:
                loginBinding.signInFrame.setVisibility(View.INVISIBLE);
                loginBinding.signUpFrame.signUpLayout.setVisibility(View.VISIBLE);
                loginBinding.loginBtn.setText(R.string.sign_up);
                break;
            case R.id.btn_switch_to_sign_in:
                loginBinding.signInFrame.setVisibility(View.VISIBLE);
                loginBinding.signUpFrame.signUpLayout.setVisibility(View.INVISIBLE);
                loginBinding.loginBtn.setText(R.string.sign_in);
                break;
        }
    }


    private void signUp() {

        if (loginBinding.signInFrame.getVisibility() == View.VISIBLE) {
            if (validateLogin()) {
                //collect data from UI
                String email = loginBinding.loginEmail.getText().toString();
                String password = loginBinding.loginPassword.getText().toString();
                //create user
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                loginPresenter.loginWithFacebook(user);
            }
        }

        if (loginBinding.signUpFrame.signUpLayout.getVisibility() == View.VISIBLE) {
            if (validateSignup()) {
                //collect data from UI
                String fname = etSignUpFirstName.getText().toString();
                String lname = etSignUpLastName.getText().toString();
                String password = etSignUpPassword.getText().toString();
                String email = etSignUpEmail.getText().toString();
                String phone = etPhoneNumber.getText().toString();

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
    }

}
