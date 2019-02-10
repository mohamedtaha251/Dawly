package com.dawly.app.storage;

import com.dawly.app.entities.User;
import com.google.gson.Gson;

/**
 * Created by Muhammad on 12/11/2017.
 */

public class DawlyStorage {
    public static final String AUTH_TOKEN = "authToken";
    public static final String CURRENT_USER = "currentUser";
    public static final String FIRST_LOGIN = "firstLogin";
    public static final String LOGGED_IN = "loggedIn";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String USER_LOCATION = "location";
    public static final String BASE_URL = "base";
    public static final String OFFER_ID = "offerID";
    public static final String LANGUAGE = "lang";
    public static final String PROFILE_IMAGE_PATH = "profileImage";
    public static final String SOURCE = "source";
    public static final String COMPLETE_SOURCE = "complete_source";
    public static final String SHOULD_BACK = "SHOULD_BACK";
    public static final String LOCATION_DIALOG = "LOCATION_DIALOG";
    public static final String LOCATION_PERMISSION = "LOCATION_PERMISSION";
    public static final String LOCATION_PERMISSION_COUNT = "PERMISSION_COUNT";



    public static void setUserAuthToken(String authToken) {
        DawlyPreferences.putString(AUTH_TOKEN, authToken);
    }

    public static String getUserAuthToken() {
        return DawlyPreferences.getString(AUTH_TOKEN);
    }

    public static void setCurrentUser(User user) {
        DawlyPreferences.putString(CURRENT_USER, new Gson().toJson(user));
    }

    public static User getCurrentUser() {
        String userJson = DawlyPreferences.getString(CURRENT_USER);
        return new Gson().fromJson(userJson, User.class);
//        if (userJson.equalsIgnoreCase(""))
//            return new User();
//        else
    }





    public static int getOfferID() {
        int offerID = DawlyPreferences.getInt(OFFER_ID);
        return offerID;
    }


    public static void setOfferID(int offerID) {
        DawlyPreferences.putInt(OFFER_ID, offerID);
    }


    public static int getLanguage() {
        return DawlyPreferences.getInt(LANGUAGE);
    }


    public static void setLanguage(int lang) {
        DawlyPreferences.putInt(LANGUAGE, lang);
    }





    public static void setFirstLogIn(boolean loggedIn) {
        DawlyPreferences.putBoolean(FIRST_LOGIN, loggedIn);
    }

    public static boolean getFirstLogIn() {
        return DawlyPreferences.getTrueBoolean(FIRST_LOGIN);
    }



    public static void setShowLocationDialog(boolean loggedIn) {
        DawlyPreferences.putBoolean(LOCATION_DIALOG, loggedIn);
    }

    public static boolean getShowLocationDialog() {
        return DawlyPreferences.getTrueBoolean(LOCATION_DIALOG);
    }


    public static void setShowLocationPermission(boolean loggedIn) {
        DawlyPreferences.putBoolean(LOCATION_PERMISSION, loggedIn);
    }

    public static boolean getShowLocationPermission() {
        return DawlyPreferences.getTrueBoolean(LOCATION_PERMISSION);
    }


    public static void setShowLocationPermissionCount(int loggedIn) {
        DawlyPreferences.putInt(LOCATION_PERMISSION_COUNT, loggedIn);
    }

    public static int getShowLocationPermissionCount() {
        return DawlyPreferences.getInt(LOCATION_PERMISSION_COUNT);
    }



    public static void setLoggedIn(boolean loggedIn) {
        DawlyPreferences.putBoolean(LOGGED_IN, loggedIn);
    }

    public static boolean isLoggedIn() {
        return DawlyPreferences.getBoolean(LOGGED_IN);
    }








    public static void setShouldBack(boolean shouldBack) {
        DawlyPreferences.putBoolean(SHOULD_BACK, shouldBack);
    }

    public static boolean isShouldBack() {
        return DawlyPreferences.getBoolean(SHOULD_BACK);
    }



    public static void setUserLatitude(long latitude) {
        DawlyPreferences.putLong(LATITUDE, latitude);
    }

    public static double getUserLatitude() {
        return DawlyPreferences.getLong(LATITUDE);
    }

    public static void setUserLongitude(long latitude) {
        DawlyPreferences.putLong(LONGITUDE, latitude);
    }

    public static double getUserLongitude() {
        return DawlyPreferences.getLong(LONGITUDE);
    }


    public static void setSource(String currentPath) {
        DawlyPreferences.putString(SOURCE, currentPath);
    }

    public static String getSource() {
        return DawlyPreferences.getString(SOURCE);
    }

    public static void setCompleteSource(String currentPath) {
        DawlyPreferences.putString(COMPLETE_SOURCE, currentPath);
    }

    public static String getCompleteSource() {
        return DawlyPreferences.getString(COMPLETE_SOURCE);
    }





    public static void setImagePath(String currentPath) {
        DawlyPreferences.putString(PROFILE_IMAGE_PATH, currentPath);
    }

    public static String getImagePath() {
        return DawlyPreferences.getString(PROFILE_IMAGE_PATH);
    }


    public static void setBaseURL(String currentPath) {
        DawlyPreferences.putString(BASE_URL, currentPath);
    }

    public static String getBaseURL() {
        return DawlyPreferences.getString(BASE_URL);
    }


    public static void removeCurrentUser() {
        DawlyPreferences.putString(CURRENT_USER, null);
    }


}
