package com.dawly.app.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class RequestPermission {

    /**
     * Created by Muhammad on 1/15/2018.
     */


        private Activity activity;
        private static final int REQUEST_PHONE = 1;
        private static final int REQUEST_CONTACTS = 2;
        private static final int REQUEST_ALL= 3;
        public static String[] GENERAL_PERMISSIONS = {Manifest.permission.READ_CONTACTS,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE
        };

        public static String[] PERMISSIONS_CONTACTS = {
                Manifest.permission.READ_CONTACTS
        };

        public static String[] PERMISSIONS_PHONE = {
                Manifest.permission.CALL_PHONE
        };
        public RequestPermission(Activity activity) {
            this.activity = activity;
        }



        public boolean verifyPermissions(Activity activity) {
            // Check if we have write permission
            int permissionPhone = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);
            int permissionContacts = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS);
            int permissionWriteStorage = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permissionContacts != PackageManager.PERMISSION_GRANTED && permissionPhone != PackageManager.PERMISSION_GRANTED && permissionWriteStorage != PackageManager.PERMISSION_GRANTED ) {
                // We don't have permission so prompt the user
                return false;
            } else {
                return true;
            }

        }
        public void requestPermissions(){
            ActivityCompat.requestPermissions(activity, GENERAL_PERMISSIONS, REQUEST_ALL);
        }



        public boolean verifyPhonePermissions(Activity activity) {
            // Check if we have write permission
            int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(activity, PERMISSIONS_PHONE, REQUEST_PHONE);
                return false;
            } else {
                return true;
            }
        }
        public boolean verifyContactsPermissions(Activity activity) {
            // Check if we have write permission
            int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS);
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(activity, PERMISSIONS_CONTACTS, REQUEST_CONTACTS);
                return false;
            } else {
                return true;
            }
        }

        private void checkPermission() {
            if (ContextCompat.checkSelfPermission(activity,
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
