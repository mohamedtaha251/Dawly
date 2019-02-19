package com.dawly.app.screens.auth.login;

import android.widget.Toast;
import com.dawly.app.application.DawlyApp;
import com.dawly.app.base.BaseModel;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.SignUpResponse;
import com.dawly.app.network.AppService;
import com.dawly.app.utils.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Muhammad on 1/1/2018.
 */

public class LoginModel extends BaseModel {
    private LoginContract.LoginPresenter loginPresenter;

    private final CompositeDisposable mDisposable = new CompositeDisposable();
    private AppService appService;

    public LoginModel(LoginContract.LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        initAPICall();
    }

    private void initAPICall() {
        appService = DawlyApp.getServiceComponent().getAppService();
    }

    @Override
    protected void start(Object user) {
        mDisposable.add(appService.login(Constants.LOGIN, (User) user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError, this::onComplete));
    }


    protected void signUp(Object user) {
        mDisposable.add(appService.signUp(Constants.CREATE_USER, (User) user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError, this::onComplete));
    }



    public void stop() {
        mDisposable.clear();
    }

    @Override
    protected void onComplete() {

    }


    @Override
    public void onSuccess(Object response) {

        //login response
        if (response instanceof LoginResponse) {
            LoginResponse<String> loginResponse = (LoginResponse<String>) response;
            if (loginResponse.getMessage() == "Successful login.") {
                loginPresenter.onLoginSucceed((loginResponse));
            } else {
                loginPresenter.onLoginError(loginResponse.getMessage());
            }
        }

        //signup response
        if (response instanceof SignUpResponse) {
            SignUpResponse signUpResponse = (SignUpResponse) response;
            if (signUpResponse.getMessage() == "Successful login.") {
                loginPresenter.onSignupSucceed((signUpResponse));
            } else {
                loginPresenter.onSignUpError(signUpResponse.getMessage());
            }
        }


    }

    @Override
    public void onError(Throwable throwable) {
        loginPresenter.onLoginError(throwable.getMessage());
    }
}
