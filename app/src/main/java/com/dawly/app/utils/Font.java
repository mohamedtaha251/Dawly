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

        if (view instanceof DawlyEditText) {
            DawlyEditText dawlyEditText = (DawlyEditText) view;
            dawlyEditText.setTextColor(getColor());
            dawlyEditText.setTypeface(checkLanguage(REGULAR,false));
        }
        if (view instanceof DawlyTextView) {
            DawlyTextView dawlyTextView = (DawlyTextView) view;
//              luckyTextView.setTextColor(getColor());
            dawlyTextView.setTypeface(checkLanguage(REGULAR,false));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = dawlyTextView.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                dawlyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 2.0f);
            }
        }
        if (view instanceof DawlyRadioButton) {
            DawlyRadioButton luckyTextView = (DawlyRadioButton) view;
            luckyTextView.setTypeface(checkLanguage(REGULAR,false));
        }

        if (view instanceof DawlyTextViewBold) {
            DawlyTextViewBold luckyTextView = (DawlyTextViewBold) view;
//            luckyTextView.setTextColor(getColor());
            luckyTextView.setTypeface(checkLanguage(Constants.FontType.BOLD,false));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = luckyTextView.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                luckyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 2.5f);
            }
        }
        if (view instanceof DawlyTextViewSemiBold) {
            DawlyTextViewSemiBold luckyTextView = (DawlyTextViewSemiBold) view;
//            luckyTextView.setTextColor(getColor());
            luckyTextView.setTypeface(checkLanguage(Constants.FontType.SEMI_BOLD,false));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = luckyTextView.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                luckyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 2.0f);
            }
        }

        if (view instanceof DawlyButton) {
            DawlyButton dawlyButton = (DawlyButton) view;
//            luckyEditText.setTextColor(getColor());
            dawlyButton.setTypeface(checkLanguage(REGULAR,true));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = dawlyButton.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                dawlyButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 1.0f);
            }
        }
        if (view instanceof DawlyButtonBold) {
            DawlyButtonBold dawlyButtonBold = (DawlyButtonBold) view;
//            luckyEditText.setTextColor(getColor());
            dawlyButtonBold.setTypeface(checkLanguage(Constants.FontType.BOLD,true));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                float sp = dawlyButtonBold.getTextSize() / context.getResources().getDisplayMetrics().scaledDensity;
                dawlyButtonBold.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp - 1.0f);
            }
        }
        if (view instanceof DawlyBottomNavigation) {
            DawlyBottomNavigation dawlyBottomNavigation = (DawlyBottomNavigation) view;
//            luckyBottomNavigation.setTitleTypeface(checkLanguage(REGULAR));
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
//                luckyBottomNavigation.setTitleTextSizeInSp(10, 10);
            } else {
//                luckyBottomNavigation.setTitleTextSizeInSp(11, 11);
            }
        }


    }

    private Typeface checkLanguage(Constants.FontType type, boolean isBtn) {
        if (!isBtn) {
            if (DawlyStorage.getLanguage() == Constants.ARABIC) {
                switch (type) {
                    case REGULAR:
                        return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                    case THIN:
                        return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                    case SEMI_BOLD:
                        return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                    case BOLD:
                        return Typeface.createFromAsset(context.getAssets(), ROBOTO_BOLD);
                }
            } else {
                switch (type) {
                    case REGULAR:
                        return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                    case THIN:
                        return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                    case SEMI_BOLD:
                        return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                    case BOLD:
                        return Typeface.createFromAsset(context.getAssets(), ROBOTO_BOLD);
                }
            }

        } else {
            switch (type) {
                case REGULAR:
                    return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                case THIN:
                    return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                case SEMI_BOLD:
                    return Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
                case BOLD:
                    return Typeface.createFromAsset(context.getAssets(), ROBOTO_BOLD);
            }
        }
        return Typeface.createFromAsset(context.getAssets(), CAIRO_REGULAR);
    }


    private int getColor() {
        return ContextCompat.getColor(context, R.color.colorEmail);
    }


}