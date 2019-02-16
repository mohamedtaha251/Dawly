package com.dawly.app.screens.auth.login;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginViewModule {

    @Binds
    abstract LoginContract.LoginInteractor provideLoginView(LoginActivity loginActivity);

}
