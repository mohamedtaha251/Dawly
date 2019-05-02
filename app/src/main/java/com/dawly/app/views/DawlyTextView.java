package com.dawly.app.views;

import android.content.Context;
import android.util.AttributeSet;
import com.dawly.app.utils.Font;

public class DawlyTextView extends androidx.appcompat.widget.AppCompatTextView {
    public DawlyTextView(Context context) {
        super(context);
        initFontAndChange( context);
    }

    public DawlyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initFontAndChange( context);
    }

    public DawlyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initFontAndChange( context);
    }
         private void initFontAndChange(Context context) {
        Font font = new Font(context);
        font.changeFont(this);
    }
}
