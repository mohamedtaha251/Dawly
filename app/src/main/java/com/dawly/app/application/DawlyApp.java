package com.dawly.app.application;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.res.Configuration;
import com.dawly.app.di.DaggerAppComponent;
import com.dawly.app.network.DaggerWebServiceComponent;
import com.dawly.app.network.WebServiceComponent;
import com.dawly.app.storage.DawlyPreferences;
import com.dawly.app.storage.DawlyStorage;
import com.dawly.app.utils.Constants;
import com.dawly.app.utils.LocaleManager;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;

import javax.inject.Inject;
import java.util.Locale;


/**
 * Created by Muhammad on 12/8/2017.
 */

public class DawlyApp extends Application implements HasActivityInjector, HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    AndroidInjector<Fragment> dispatchingFragmentInjector;
    private static WebServiceComponent serviceComponent;
    Locale locale = null;




    @Override
    public void onCreate() {
        super.onCreate();
        createDawlyPrefs(this);
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        Crashlytics crashlyticsKit = new Crashlytics.Builder()
//                .core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
//                .build();
//        Fabric.with(this, crashlyticsKit);
        serviceComponent = DaggerWebServiceComponent.builder().applicationModule(new ApplicationModule(this))
                .build();
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

//        changeLanguage();
    }

    public void changeLanguage() {
        if (DawlyStorage.getLanguage() == Constants.ARABIC) {
            locale = new Locale(Constants.ARABIC_KEY);
            LocaleManager.changeLang(getApplicationContext(), Constants.ARABIC_KEY);
        } else if (DawlyStorage.getLanguage() == Constants.ENGLISH) {
            locale = new Locale(Constants.ENGLISH_KEY);

            LocaleManager.changeLang(getApplicationContext(), Constants.ENGLISH_KEY);
        }

    }


    private void createDawlyPrefs(Application application) {
        DawlyPreferences.getInstance(application);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }


    public static WebServiceComponent getServiceComponent() {
        return serviceComponent;
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return dispatchingFragmentInjector;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (locale != null) {
            Locale.setDefault(locale);
            Configuration config = new Configuration(newConfig);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}
