package com.dawly.app.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.InputType;
import android.view.View;
import app.dawly.com.dawly.R;
import com.dawly.app.views.DawlyEditText;
import com.dawly.app.views.DawlyTextView;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean field = false;

    public static boolean isFieldsEmpty(Context context, HashMap<DawlyEditText, DawlyTextView> signUpHashMap) {
        for (DawlyEditText dawlyEditText : signUpHashMap.keySet()) {
            if (dawlyEditText.getText().toString().isEmpty()) {
                dawlyEditText.setBackground(ContextCompat.getDrawable(context, R.drawable.edit_text_invalid_bg));
                DawlyTextView dawlyTextView = signUpHashMap.get(dawlyEditText);
                dawlyTextView.setVisibility(View.VISIBLE);
                field = true;
            } else {
                dawlyEditText.setBackground(ContextCompat.getDrawable(context, R.drawable.edit_text_bg));
                DawlyTextView dawlyTextView = signUpHashMap.get(dawlyEditText);
                dawlyTextView.setVisibility(View.GONE);
                field = true;
            }
            return field;
        }
        return field;
    }

    public static boolean isValidPassword(String password) {

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


    public static void changeTypeToVisible(DawlyEditText dawlyEditText) {
        if (isPasswordVisible(dawlyEditText)) {
            dawlyEditText.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            dawlyEditText.setInputType(
                    InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        }
        dawlyEditText.setSelection(dawlyEditText.getText().length());
    }

    public static boolean isPasswordVisible(DawlyEditText dawlyEditText) {
        if (dawlyEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)
            return true;
        else
            return false;
    }

    public static boolean isContainLowerCase(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN =  "(?=.*[a-z]).+";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public static boolean isContainUpperCase(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN =  "(?=.*[A-Z]).+";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}
