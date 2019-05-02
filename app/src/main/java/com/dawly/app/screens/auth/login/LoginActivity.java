package com.dawly.app.screens.auth.login;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.ActivityLoginBinding;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dawly.app.base.BaseActivity;
import com.dawly.app.base.BaseContract;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.response.SignUpResponse;
import com.dawly.app.screens.tutorial.TutorialActivity;
import com.dawly.app.utils.Toaster;
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

    Techniques in_animation = Techniques.ZoomIn;
    Techniques out_animation = Techniques.ZoomOut;
    private static final int duration = 1000;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        //init
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        etSignUpFirstName = loginBinding.signupFirstName;
        etSignUpLastName = loginBinding.etSignUpLastName;
        etSignUpPassword = loginBinding.signupPassword;
        etPhoneNumber = loginBinding.etPhoneNumber;
        etSignUpConfirmPassword = loginBinding.signupConfirmPassword;
        etSignUpEmail = loginBinding.signupEmail;
        signUpEmailInput = loginBinding.signupEmailInput;
        signUpPasswordInput = loginBinding.signupPasswordInput;
        confirmPasswordInput = loginBinding.signupConfirmPasswordInput;
        firstNameInput = loginBinding.signupFirstNameInput;
        lastNameInput = loginBinding.lastNameInput;


        loginBinding.setClickListener(this);
        loginBinding.signCard.bringToFront();
//        getSupportActionBar().hide();

    }

    private boolean validateLogin() {
        if (loginBinding.loginEmail.getText().toString().equals("")) {
            loginBinding.loginEmail.setError(getString(R.string.email_is_required));
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(loginBinding.loginEmail.getText().toString()).matches()) {
            loginBinding.loginEmail.setError(getString(R.string.invalid_email));
            return false;
        }

        if (loginBinding.loginPassword.getText().toString().equals("")) {
            loginBinding.loginPassword.setError(getString(R.string.password_is_required));
            return false;
        }

        return true;
    }

    private boolean validateSignup() {
        if (etSignUpFirstName.getText().toString().equals("")) {
            etSignUpFirstName.setError(getString(R.string.first_name_is_required));
            return false;
        }

        if (etSignUpFirstName.getText().toString().length() < 3) {
            etSignUpFirstName.setError(getString(R.string.first_name_is_too_short));
            return false;
        }

        if (etSignUpLastName.getText().toString().equals("")) {
            etSignUpLastName.setError(getString(R.string.last_name_is_required));
            return false;
        }

        if (etSignUpLastName.getText().toString().length() < 3) {
            etSignUpLastName.setError(getString(R.string.last_name_is_too_short));
            return false;
        }

        if (etSignUpPassword.getText().toString().equals("")) {
            etSignUpPassword.setError(getString(R.string.password_is_required));
            return false;
        }

        if (etSignUpPassword.getText().toString().length() < 6) {
            etSignUpPassword.setError(getString(R.string.at_least_6_digit));
            return false;
        }

        if (!Validation.isContainLowerCase(etSignUpPassword.getText().toString())) {
            etSignUpPassword.setError(getString(R.string.at_least_one_lower_case_letter));
            return false;
        }

        if (!Validation.isContainUpperCase(etSignUpPassword.getText().toString())) {
            etSignUpPassword.setError(getString(R.string.at_least_one_upper_case_letter));
            return false;
        }

        if (!etSignUpPassword.getText().toString().equals(etSignUpConfirmPassword.getText().toString())) {
            etSignUpConfirmPassword.setError(getString(R.string.password_is_not_matched));
            return false;
        }

        if (etSignUpEmail.getText().toString().equals("")) {
            etSignUpEmail.setError(getString(R.string.email_is_required));
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(etSignUpEmail.getText().toString()).matches()) {
            etSignUpEmail.setError(getString(R.string.invalid_email));
            return false;
        }

        if (etPhoneNumber.getText().toString().equals("")) {
            etPhoneNumber.setError(getString(R.string.phone_is_required));
            return false;
        }

        if (etPhoneNumber.getText().toString().length() < 10) {
            etPhoneNumber.setError(getString(R.string.invalid_phone));
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
        Toaster.showShort(getBaseContext(), message);
    }

    @Override
    public void loginError(String message) {
        Toaster.showShort(getBaseContext(), getString(R.string.user_not_Found));
    }

    @Override
    public void signUpError(String message) {
        Toaster.showShort(getBaseContext(), message);
    }

    @Override
    public void signUpSuccess(SignUpResponse signUpResponse) {
        Toaster.showShort(getBaseContext(), signUpResponse.getMessage());
        startActivity(new Intent(this, TutorialActivity.class));

    }

    @Override
    public void loginSuccess(LoginResponse loginResponse) {
        Toaster.showShort(getBaseContext(), loginResponse.getMessage());
        startActivity(new Intent(this, TutorialActivity.class));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                signUp();
                break;
            case R.id.btn_switch_to_sign_up:
                animateToSignUp();
                loginBinding.loginBtn.setText(R.string.sign_up);

                break;
            case R.id.btn_switch_to_sign_in:
                animateToSignIn();

                loginBinding.loginBtn.setText(R.string.sign_in);
                break;
        }
    }

    private void animateToSignIn() {

        YoYo.with(Techniques.ZoomOut)
                .onEnd(animator -> loginBinding.signUpLayout.setVisibility(View.GONE))
                .duration(500)
                .playOn(loginBinding.signUpLayout);

        YoYo.with(Techniques.ZoomInUp)
                .duration(1000)
                .onStart(animator -> loginBinding.signInFrame.setVisibility(View.VISIBLE))
                .playOn(loginBinding.signInFrame);

    }

    private void animateToSignUp() {

        YoYo.with(Techniques.ZoomOut)
                .duration(500)
                .onEnd(animator -> loginBinding.signInFrame.setVisibility(View.GONE))
                .playOn(loginBinding.signInFrame);

        YoYo.with(Techniques.ZoomInUp)
                .duration(duration)
                .onStart(animator -> loginBinding.signUpLayout.setVisibility(View.VISIBLE))
                .playOn(loginBinding.signUpLayout);

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
//                loginPresenter.loginWithFacebook(user);
            }
        }

        if (loginBinding.signUpLayout.getVisibility() == View.VISIBLE) {
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
