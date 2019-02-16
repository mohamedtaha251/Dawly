package com.dawly.app.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import app.dawly.com.dawly.R;
import com.dawly.app.utils.Font;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DawlyEditText extends android.support.v7.widget.AppCompatEditText {
    private Context context;
    Font font;

    public DawlyEditText(Context context) {
        super(context);
        this.context = context;
        initFontAndChange( context);
    }

    public DawlyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initFontAndChange( context);
    }

    public DawlyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initFontAndChange( context);
    }


    public boolean isValid(DawlyTextView warTextView) {
        if (TextUtils.isEmpty(this.getText().toString())) {
            startAnimation();
            showInvalidBorder(true);
            if (warTextView != null)
                warTextView.setVisibility(VISIBLE);
            return false;
        } else {
            if (warTextView != null)
                warTextView.setVisibility(GONE);
            showInvalidBorder(false);
            return true;
        }
    }
    public boolean isValid(DawlyTextView warTextView, String message) {
        if (TextUtils.isEmpty(this.getText().toString())) {
            startAnimation();
            showInvalidBorder(true);
            if (warTextView != null) {
                warTextView.setVisibility(VISIBLE);
            warTextView.setText(message);
            }
            return false;
        } else {
            if (warTextView != null)
                warTextView.setVisibility(GONE);
            showInvalidBorder(false);
            return true;
        }
    }
    public boolean isValidPassword() {
        if (this.getText().toString().length() < 6 || !isValidPassword(this.getText().toString())) {
            return false;
        } else {
            return true;
        }
    }


    private boolean isValidPassword(String password) {

        String pattern = "^((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{5,}).+$";
        Pattern p = Pattern.compile(pattern);//. represents single character
        Matcher matcher = p.matcher(password);
        return matcher.matches();
    }

    private void startAnimation() {
        this.startAnimation(AnimationUtils.loadAnimation(context, R.anim.shake_error));
    }

    private void showInvalidBorder(boolean show) {
        if (show)
            this.setBackground(context.getDrawable(R.drawable.edit_text_invalid_bg));
        else
            this.setBackground(context.getDrawable(R.drawable.edit_text_bg));
    }


    public boolean isEmailValid(DawlyEditText email) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            startAnimation();
            showInvalidBorder(true);
            return true;
        } else {
            showInvalidBorder(false);
            return false;
        }
    }

    private void initFontAndChange(Context context) {
        font = new Font(context);
        font.changeFont(this);
    }

}
