package com.dawly.app.storage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Anas on 12/8/2017.
 */
public class DawlyPreferences {


    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static DawlyPreferences dawlyPreferences;

    public DawlyPreferences(Application application) {
        sharedPreferences = application.getSharedPreferences("Lucky", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public static DawlyPreferences getInstance(Application application) {
        if (dawlyPreferences == null) {
            dawlyPreferences = new DawlyPreferences(application);
        }
        return dawlyPreferences;
    }


    public static void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public static boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public static void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }


    public static boolean getTrueBoolean(String key) {
        if (sharedPreferences != null)
            return sharedPreferences.getBoolean(key, true);
        else
            return false;
    }


    public static long getLong(String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public static void putLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public static String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public static int getInt(String key) {
        return sharedPreferences.getInt(key, 1);
    }

    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

}
