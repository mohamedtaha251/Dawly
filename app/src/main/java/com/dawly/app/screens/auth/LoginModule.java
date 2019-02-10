package com.dawly.app.screens.auth;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
        @Provides
        LoginPresenterImpl provideLoginPresenter(LoginContract.LoginInteractor loginPresenter) {
            return new LoginPresenterImpl(loginPresenter);
        }
    }