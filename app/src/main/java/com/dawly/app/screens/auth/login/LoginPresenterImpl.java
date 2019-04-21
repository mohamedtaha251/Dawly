package com.dawly.app.screens.auth.login;

import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.SignUpResponse;

/**
 * Created by Muhammad on 1/1/2018.
 */

public class LoginPresenterImpl implements LoginContract.LoginPresenter {

    private LoginContract.LoginInteractor loginInteractor;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginContract.LoginInteractor loginInteractor) {
        this.loginInteractor = loginInteractor;
        loginModel = new LoginModel(this);
    }


    @Override
    public void onLoginSucceed(LoginResponse loginResponse) {
        loginInteractor.loginSuccess(loginResponse);
    }

    @Override
    public void onSignupSucceed(SignUpResponse signUpResponse) {
        loginInteractor.signUpSuccess(signUpResponse);
    }

    @Override
    public void onLoginError(String message) {
        loginInteractor.loginError(message);

    }

    @Override
    public void onSignUpError(String message) {
        loginInteractor.signUpError(message);
    }

    @Override
    public void onLoginValidationError(String message) {
        loginInteractor.showValidationErrors(message);

    }

    @Override
    public void signUp(User user) {
        loginModel.signUp(user);
    }

    @Override
    public void stop() {
        loginModel.stop();
    }

    @Override
    public void start(Object Model) {

    }


}
