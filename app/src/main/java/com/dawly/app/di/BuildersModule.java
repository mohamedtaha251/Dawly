package com.dawly.app.di;

import com.dawly.app.screens.auth.login.LoginActivity;
import com.dawly.app.screens.auth.login.LoginModule;
import com.dawly.app.screens.auth.login.LoginViewModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {LoginViewModule.class, LoginModule.class})
    abstract LoginActivity bindLoginActivity();
//    @ContributesAndroidInjector(modules = {LoginViewModule.class, LoginModule.class})
//    abstract LoginActivity bindLoginActivity();

//    @ContributesAndroidInjector(modules = {SignUpViewModule.class, SignUpModule.class})
//    abstract SignUpActivity bindSignUpActivity();
//    @ContributesAndroidInjector(modules = {ConfirmEmailViewModule.class, ConfirmEmailModule.class})
//    abstract ConfirmationActivity bindConfirmEmailActivity();







}
