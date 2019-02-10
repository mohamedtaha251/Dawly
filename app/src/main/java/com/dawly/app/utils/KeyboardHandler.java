package com.dawly.app.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardHandler {
    private  Context context;
    public KeyboardHandler(Context context) {
    this.context = context;
    }

    public void removeSoftKeyboard(View view) {
        System.err.println("remove soft keyboard");
        final InputMethodManager imm = (InputMethodManager) context.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
