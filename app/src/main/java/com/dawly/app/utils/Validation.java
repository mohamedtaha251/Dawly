package com.dawly.app.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.view.View;
import app.dawly.com.dawly.R;
import com.dawly.app.views.LuckyEditText;
import com.dawly.app.views.LuckyTextView;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean field = false;

    public static boolean isFieldsEmpty(Context context, HashMap<LuckyEditText, LuckyTextView> signUpHashMap) {
        for (LuckyEditText luckyEditText : signUpHashMap.keySet()) {
            if (luckyEditText.getText().toString().isEmpty()) {
                luckyEditText.setBackground(ContextCompat.getDrawable(context, R.drawable.edit_text_invalid_bg));
                LuckyTextView luckyTextView = signUpHashMap.get(luckyEditText);
                luckyTextView.setVisibility(View.VISIBLE);
                field = true;
            } else {
                luckyEditText.setBackground(ContextCompat.getDrawable(context, R.drawable.edit_text_bg));
                LuckyTextView luckyTextView = signUpHashMap.get(luckyEditText);
                luckyTextView.setVisibility(View.GONE);
                field = true;
            }
            return field;
        }
        return field;
    }

    public boolean isValidPassword(String password) {

        String pattern = "^((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{5,}).+$";
        Pattern p = Pattern.compile(pattern);//. represents single character
        Matcher matcher = p.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        boolean isPhoneNumberValid=false;
        if (phoneNumber.length() == 11 && phoneNumber.charAt(0) == '0'
                && phoneNumber.charAt(1) == '1') {
            isPhoneNumberValid = true;
        }
        return isPhoneNumberValid;
    }
    public static boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

    public static boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 8;
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }


    public static void changeTypeToVisible(LuckyEditText luckyEditText) {
        if (isPasswordVisible(luckyEditText)) {
            luckyEditText.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            luckyEditText.setInputType(
                    InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        luckyEditText.setSelection(luckyEditText.getText().length());
    }

    public static boolean isPasswordVisible(LuckyEditText luckyEditText) {
        if (luckyEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            return true;
        else
            return false;
    }
}
