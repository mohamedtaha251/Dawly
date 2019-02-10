package com.dawly.app.screens.auth;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginViewModule {

    @Binds
    abstract LoginContract.LoginInteractor provideLoginView(LoginActivity loginActivity);

}
