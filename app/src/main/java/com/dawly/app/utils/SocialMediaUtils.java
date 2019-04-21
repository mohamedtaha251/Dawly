package com.dawly.app.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SocialMediaUtils {
    /*call this function to print facebook KeyHash in log
 KeyHash is a key generated in code ex:cOW71dcUyB/wT2ap/uEiHJkX5M0=
 used in create app on https://developers.facebook.com/*/
    public static void printKeyHash(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo("com.task.firebaseuiauth", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Log.e("KEYHASH", Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
