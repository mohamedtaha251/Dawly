package com.dawly.app.screens.post;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AddOrderViewModule {

    @Binds
    abstract AddOrderContract.AddOrderInteractor provideAddOrderView(PostRequestFragmentStep4 postRequestFragmentStep4);

}
