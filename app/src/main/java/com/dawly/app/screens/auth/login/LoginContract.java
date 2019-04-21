package com.dawly.app.screens.auth.login;

import android.view.View;
import com.dawly.app.base.BasePresenter;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.SignUpResponse;

public class LoginContract {
    /**
     * Created by Muhammad on 1/1/2018.
     */

    public interface LoginInteractor {
        void showValidationErrors(String message);

        void loginError(String message);

        void loginSuccess(LoginResponse loginResponse);

        void signUpError(String message);

        void signUpSuccess(SignUpResponse signUpResponse);
    }


    public interface  LoginPresenter extends BasePresenter {
        void onLoginSucceed(LoginResponse loginResponse);

        void onSignupSucceed(SignUpResponse signUpResponse);

        void onLoginError(String message);

        void onSignUpError(String message);

        void onLoginValidationError(String message);

        void signUp(User user);
    }

    public interface ClickListener {
        void onClick(View view);
    }


}
