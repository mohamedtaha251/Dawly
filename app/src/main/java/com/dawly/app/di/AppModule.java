package com.dawly.app.di;

import android.content.Context;
import com.dawly.app.application.DawlyApp;
import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(DawlyApp application) {
        return application.getApplicationContext();
    }

}
