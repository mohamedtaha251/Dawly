package com.dawly.app.views;

import android.content.Context;
import android.util.AttributeSet;
import com.dawly.app.utils.Font;

public class LuckyButtonBold  extends android.support.v7.widget.AppCompatButton {
    public LuckyButtonBold(Context context) {
        super(context);
        initFontAndChange( context);
    }

    public LuckyButtonBold(Context context, AttributeSet attrs) {
        super(context, attrs);

        initFontAndChange( context);
    }

    public LuckyButtonBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initFontAndChange( context);
    }

         private void initFontAndChange(Context context) {
        Font font = new Font(context);
        font.changeFont(this);
    }
}
