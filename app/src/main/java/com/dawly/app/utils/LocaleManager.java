package com.dawly.app.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

public class LocaleManager {

    public static void updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
    }


    public static void changeLang(Context context, String language) {
        Locale locale=new Locale(language);
        Configuration config = context.getResources().getConfiguration();
        Locale.setDefault(locale);
        Configuration conf = new Configuration(config);
        conf.setLayoutDirection(locale);
        conf.locale = locale;
       context.getResources().updateConfiguration(conf, context.getResources().getDisplayMetrics());

    }
}
