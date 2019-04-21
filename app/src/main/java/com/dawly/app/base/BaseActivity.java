package com.dawly.app.base;

import android.os.Bundle;
import com.dawly.app.storage.DawlyStorage;
import com.dawly.app.utils.Constants;
import com.dawly.app.views.CustomProgressDialog;
import com.dawly.app.utils.LocaleManager;
import dagger.android.support.DaggerAppCompatActivity;

public class BaseActivity extends DaggerAppCompatActivity {
    public BaseActivity() {

    }

    public CustomProgressDialog customProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customProgressDialog = new CustomProgressDialog();
    }

    public void showProgressDialog() {
        if (!customProgressDialog.isShowing())
            customProgressDialog.showDialog(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        handleLanguage(Constants.ENGLISH);
    }


    public void handleLanguage(int languageId) {
        if (languageId == Constants.ARABIC) {
            DawlyStorage.setLanguage(Constants.ARABIC);
            LocaleManager.changeLang(this, Constants.ARABIC_KEY);
        } else if (languageId == Constants.ENGLISH) {
            DawlyStorage.setLanguage(Constants.ENGLISH);
            LocaleManager.changeLang(this, Constants.ENGLISH_KEY);
        }

    }
}
