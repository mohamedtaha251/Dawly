package com.dawly.app.screens.auth;

import com.dawly.app.application.DawlyApp;
import com.dawly.app.base.BaseModel;
import com.dawly.app.entities.ResponseEntity;
import com.dawly.app.entities.User;
import com.dawly.app.network.AppService;
import com.dawly.app.utils.Constants;
import com.google.gson.JsonObject;
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
        User userObj = (User) user;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Email", userObj.getEmail());
        jsonObject.addProperty("Password", userObj.getPassword());
        mDisposable.add(appService.login(Constants.BASE_URL_AUTH+Constants.LOGIN,(User) user)
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
    public void onSuccess(Object user) {
        ResponseEntity<User> user1 = (ResponseEntity<User>) user;
        if (user1.getStatus() == 200) {
            loginPresenter.onLoginSucceed((User) user1.getData());
        } else {
            loginPresenter.onLoginError((String) user1.getErrorList().get(0));
        }



    }

    @Override
    public void onError(Throwable throwable) {
        loginPresenter.onLoginError(handleOnError(throwable));
    }
}
