package com.dawly.app.views;

import android.content.Context;
import com.google.android.material.tabs.TabLayout;
import android.util.AttributeSet;

public class DawlyTabLayout extends TabLayout {
    public DawlyTabLayout(Context context) {
        super(context);
        initFontAndChange(context);
    }

    public DawlyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        initFontAndChange(context);
    }

    public DawlyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initFontAndChange(context);
    }

    private void initFontAndChange(Context context) {
//        Font font = new Font(context);
        changeFont(context);
    }

    private void changeFont(Context context) {

/*        for (int i = 0; i < this.getTabCount(); i++) {
            TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
            tv.setTypeface(Typeface.createFromAsset(context.getAssets(), CAIRO_REGULAR));
            this.getTabAt(i).setCustomView(tv);
        }*/
    }

}
