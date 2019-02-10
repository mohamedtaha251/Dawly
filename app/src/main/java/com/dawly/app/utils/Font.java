package com.dawly.app.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import app.dawly.com.dawly.R;
import com.dawly.app.storage.DawlyStorage;
import com.dawly.app.views.*;

import static com.dawly.app.utils.Constants.*;
import static com.dawly.app.utils.Constants.FontType.REGULAR;


public class Font {

    public Font() {
    }

    private Context context;

    public Font(Context context) {
        this.context = context;
    }

    public void changeFont(View view) {

        if (view instanceof LuckyEditText) {
            LuckyEditText luckyEditText = (LuckyEditText) view;
            luckyEditText.setTextColor(getColor());
            luckyEditText.setTypeface(checkLanguage(REGULAR));
        }
        if (view instanceof LuckyTextView) {
            LuckyTextView luckyTextView = (LuckyTextView) view;
//              luckyTextView.setTextColor(getColor());
            luckyTextView.setTypeface(checkLanguage(REGULAR));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = luckyTextView.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                luckyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 2.0f);
            }
        }
        if (view instanceof LuckyRadioButton) {
            LuckyRadioButton luckyTextView = (LuckyRadioButton) view;
            luckyTextView.setTypeface(checkLanguage(REGULAR));
        }

        if (view instanceof LuckyTextViewBold) {
            LuckyTextViewBold luckyTextView = (LuckyTextViewBold) view;
            luckyTextView.setTextColor(getColor());
            luckyTextView.setTypeface(checkLanguage(Constants.FontType.BOLD));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = luckyTextView.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                luckyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 2.5f);
            }
        }
        if (view instanceof LuckyTextViewSemiBold) {
            LuckyTextViewSemiBold luckyTextView = (LuckyTextViewSemiBold) view;
            luckyTextView.setTextColor(getColor());
            luckyTextView.setTypeface(checkLanguage(Constants.FontType.SEMI_BOLD));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = luckyTextView.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                luckyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 2.0f);
            }
        }

        if (view instanceof LuckyButton) {
            LuckyButton luckyButton = (LuckyButton) view;
//            luckyEditText.setTextColor(getColor());
            luckyButton.setTypeface(checkLanguage(REGULAR));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = luckyButton.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                luckyButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 1.0f);
            }
        }
        if (view instanceof LuckyButtonBold) {
            LuckyButtonBold luckyButtonBold = (LuckyButtonBold) view;
//            luckyEditText.setTextColor(getColor());
            luckyButtonBold.setTypeface(checkLanguage(Constants.FontType.BOLD));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = luckyButtonBold.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                luckyButtonBold.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 1.0f);
            }
        }
        if (view instanceof LuckyBottomNavigation) {
            LuckyBottomNavigation luckyBottomNavigation = (LuckyBottomNavigation) view;
//            luckyBottomNavigation.setTitleTypeface(checkLanguage(REGULAR));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
//                luckyBottomNavigation.setTitleTextSizeInSp(10, 10);
            } else {
//                luckyBottomNavigation.setTitleTextSizeInSp(11, 11);
            }
        }


    }


    private Typeface checkLanguage(Constants.FontType type) {
        if (DawlyStorage.getLanguage() == Constants.ARABIC) {
            switch (type) {
                case REGULAR:
                    return Typeface.createFromAsset(context.getAssets(), CAIRO_REGULAR);
                case THIN:
                    return Typeface.createFromAsset(context.getAssets(), CAIRO_THIN);
                case SEMI_BOLD:
                    return Typeface.createFromAsset(context.getAssets(), CAIRO_SEMI_BOLD);
                case BOLD:
                    return Typeface.createFromAsset(context.getAssets(), CAIRO_BOLD);
            }
        } else {
            switch (type) {
                case REGULAR:
                    return Typeface.createFromAsset(context.getAssets(), PROXIMA_REGULAR);
                case THIN:
                    return Typeface.createFromAsset(context.getAssets(), PROXIMA_THIN);
                case SEMI_BOLD:
                    return Typeface.createFromAsset(context.getAssets(), PROXIMA_SEMI_BOLD);
                case BOLD:
                    return Typeface.createFromAsset(context.getAssets(), PROXIMA_BOLD);
            }
        }

        return Typeface.createFromAsset(context.getAssets(), CAIRO_REGULAR);
    }

    private int getColor() {
        return ContextCompat.getColor(context, R.color.colorPrimary);
    }


}
