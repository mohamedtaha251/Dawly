package com.dawly.app.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import static com.dawly.app.utils.Constants.MONTSERRAT_MEDIUM;

public class DawlyButtonMontserratBold extends android.support.v7.widget.AppCompatButton {
    public DawlyButtonMontserratBold(Context context) {
        super(context);
        initFontAndChange( context);
    }

    public DawlyButtonMontserratBold(Context context, AttributeSet attrs) {
        super(context, attrs);

        initFontAndChange( context);
    }

    public DawlyButtonMontserratBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initFontAndChange( context);
    }

    private void initFontAndChange(Context context) {

        this.setTypeface(Typeface.createFromAsset(context.getAssets(), MONTSERRAT_MEDIUM));
    }
}
