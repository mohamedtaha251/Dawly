package com.dawly.app.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.content.ContextCompat.checkSelfPermission;

/**
 * Created by Muhammad on 1/15/2018.
 */

public class RequestUserPermission {

    private Activity activity;
    public static final int REQUEST_SMS = 1;
    public static final int REQUEST_LOCATION = 2;
    private static String[] PERMISSIONS= {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };
    private static String[] SMS_PERMISSION= {
            Manifest.permission.RECEIVE_SMS
    };
    private static String[] LOCATION_PERMISSION= {
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    public RequestUserPermission(Activity activity) {
        this.activity = activity;
    }

    public boolean verifyPermissions(Activity activity) {
        // Check if we have write permission
//        int permission = checkSelfPermission(activity, Manifest.permission.RECEIVE_SMS);

//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // We don't have permission so prompt the user
//            requestPermissions(
//                    activity,
//                    SMS_PERMISSION,
//                    REQUEST_SMS
//            );
//            return false;
//        } else {
            return true;
//        }
    }
    public boolean verifyLocationPermission() {
        // Check if we have write permission
        int permission = checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permission != PackageManager.PERMISSION_GRANTED) {

            // We don't have permission so prompt the user
            requestPermissions(activity, LOCATION_PERMISSION, REQUEST_LOCATION);
            return false;
        } else {
            return true;
        }
    }
Context context;
    private void checkPermission() {
        if (checkSelfPermission(context,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

//                ActivityCompat.requestPermissions(activity,
//                        new String[]{Manifest.permission.READ_CONTACTS},
//                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

}
