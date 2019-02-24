package com.dawly.app.screens.auth.social;

import com.dawly.app.application.DawlyApp;
import com.dawly.app.base.BaseModel;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.response.SignUpResponse;
import com.dawly.app.network.AppService;
import com.dawly.app.utils.Constants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Muhammad on 1/1/2018.
 */

public class SocialLoginModel  {
    private SocialLoginContract.SocialLoginPresenter presenter;

    private final CompositeDisposable mDisposable = new CompositeDisposable();
    private AppService appService;

    public SocialLoginModel(SocialLoginContract.SocialLoginPresenter loginPresenter) {
        this.presenter = loginPresenter;
        initAPICall();
    }

    private void initAPICall() {
        appService = DawlyApp.getServiceComponent().getAppService();
    }

    protected void createFacebookUser(Object user) {
        mDisposable.add(appService.signUp(Constants.CREATE_USER, (User) user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess));
    }


    protected void createGoogleUser(Object user) {
        mDisposable.add(appService.signUp(Constants.CREATE_USER, (User) user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess));
    }



    public void stop() {
        mDisposable.clear();
    }




    public void onSuccess(Object response) {

        //login response
        if (response instanceof LoginResponse) {
            LoginResponse<String> loginResponse = (LoginResponse<String>) response;
            if (loginResponse.getMessage() == "Successful login.") {
                presenter.onLoginFacebookSucceed((loginResponse));
            } else {
                presenter.onLoginFacebookError(loginResponse.getMessage());
            }
        }




    }

}
