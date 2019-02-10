package com.dawly.app.screens.auth;

import android.view.View;
import com.dawly.app.base.BasePresenter;
import com.dawly.app.entities.User;
import com.dawly.app.entities.ValidationError;

import java.util.List;

public class LoginContract {
    /**
     * Created by Muhammad on 1/1/2018.
     */

    public  interface LoginInteractor {
        void showValidationErrors(List<ValidationError> validationErrorList);
        void loginError(String message);
        void loginSuccess(User user);
    }


    public  interface LoginPresenter extends BasePresenter {
        void onLoginSucceed(User responseEntity);
        void onLoginError(String message);
        void onLoginValidationError(List<ValidationError> validationErrorList);
    }
    public  interface ClickListener {
        void onClick(View view);
    }


}
