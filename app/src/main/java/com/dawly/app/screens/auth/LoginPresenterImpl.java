package com.dawly.app.screens.auth;

import com.dawly.app.entities.User;
import com.dawly.app.entities.ValidationError;

import java.util.List;

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
    public void onLoginSucceed(User responseEntity) {
//        String status = responseEntity.getStatus();
//                int code = responseEntity.getCode().intValue();
//        switch (status){
//            case "success":
        loginInteractor.loginSuccess(responseEntity);
//                break;
//            case "fail":
////                loginInteractor.signUpError(responseEntity.getEntity().getMessage());
//                break;
//            case "error":
////                loginInteractor.signUpError(responseEntity.getEntity().getMessage());
//                break;
//        }
    }

    @Override
    public void onLoginError(String message) {
        loginInteractor.loginError(message);

    }

    @Override
    public void onLoginValidationError(List<ValidationError> validationErrorList) {
        loginInteractor.showValidationErrors(validationErrorList);

    }

    @Override
    public void stop() {
        loginModel.stop();
    }

    @Override
    public void start(Object user) {
        loginModel.start( user);
    }


}
