package com.dawly.app.di;

import com.dawly.app.network.ApplicationScope;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@ApplicationScope
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, BuildersModule.class})
public interface InjectionComponent {
}
