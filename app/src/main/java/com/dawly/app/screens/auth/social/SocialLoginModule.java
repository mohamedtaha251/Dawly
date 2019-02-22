package com.dawly.app.screens.auth.social;

import dagger.Module;
import dagger.Provides;

@Module
public class SocialLoginModule {
        @Provides
        SocialLoginPresenterImpl provideLoginPresenter(SocialLoginContract.SocialLoginInteractor interactor) {
            return new SocialLoginPresenterImpl(interactor);
        }
    }