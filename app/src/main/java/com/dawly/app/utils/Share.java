package com.dawly.app.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import app.dawly.com.dawly.R;

public class Share {
    public static Intent createShareIntent(Context context ,String message) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);
                Intent intent = Intent.createChooser(shareIntent,context.getString(R.string.app_name));
        return shareIntent;
    }

    public  static void rateApp(Context context){
        final String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }


}
