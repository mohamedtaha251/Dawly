package com.dawly.app.application;

import android.app.Application;
import android.content.Context;
import com.dawly.app.network.ApplicationScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Muhammad on 10/1/2017.
 */
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Context provideContext(DawlyApp application) {
        return application.getApplicationContext();
    }



    @Provides
    @ApplicationScope
    Application getApplication(){
        return application;
    }
}
