package com.dawly.app.screens.auth.login;

import android.view.View;
import com.dawly.app.base.BasePresenter;
import com.dawly.app.entities.LoginResponse;
import com.dawly.app.entities.User;
import com.dawly.app.entities.ValidationError;

import java.util.List;

public class LoginContract {
    /**
     * Created by Muhammad on 1/1/2018.
     */

    public interface LoginInteractor {
        void showValidationErrors(String message);

        void loginError(String message);

        void loginSuccess(LoginResponse loginResponse);
    }


    public interface LoginPresenter extends BasePresenter {
        void onLoginSucceed(LoginResponse loginResponse);

        void onLoginError(String message);

        void onLoginValidationError(String message);
    }

    public interface ClickListener {
        void onClick(View view);
    }


}
