package com.dawly.app.screens.auth.social;

import com.dawly.app.screens.auth.login.LoginActivity;
import com.dawly.app.screens.auth.login.LoginContract;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class SocialLoginViewModule {

    @Binds
    abstract SocialLoginContract.SocialLoginInteractor provideSocialLoginView(SocialLoginActivity activity);

}
