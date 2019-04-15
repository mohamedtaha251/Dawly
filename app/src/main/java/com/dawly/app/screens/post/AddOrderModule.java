package com.dawly.app.screens.post;

import dagger.Module;
import dagger.Provides;

@Module
public class AddOrderModule {
        @Provides
        AddOrderPresenterImpl provideAddOrderPresenter(AddOrderContract.AddOrderInteractor addOrderInteractor) {
            return new AddOrderPresenterImpl(addOrderInteractor);
        }
    }