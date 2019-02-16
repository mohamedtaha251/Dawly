package com.dawly.app.utils;



public class Constants {
    //--------------------------------Keys--------------------------------

   //Production
    public static final String BASE_URL = "https://luckycommonapi.dsquares.com/api/";
    public static final String BEARER ="bearer ";
    public static final String LOGIN = "Account/login";

    //--------------------------------Font Family--------------------------------
    public static final String PROXIMA_REGULAR = "fonts/proxima_regular.ttf";
    public static final String PROXIMA_SEMI_BOLD = "fonts/proxima_semi_bold.ttf";
    public static final String PROXIMA_BOLD = "fonts/proxima_bold.ttf";
    public static final String PROXIMA_THIN = "fonts/proxima_thin.ttf";

    public static final String CAIRO_REGULAR = "fonts/cairo_regular.ttf";
    public static final String CAIRO_SEMI_BOLD = "fonts/cairo_semi_bold.ttf";
    public static final String CAIRO_BOLD = "fonts/cairo_bold.ttf";
    public static final String CAIRO_THIN = "fonts/cairo_light.ttf";

    public static final int ARABIC = 1;
 public static final String ARABIC_KEY = "ar";
 public static final int ENGLISH = 2;
 public static final String ENGLISH_KEY = "en";

 public enum FontType {
        REGULAR, THIN,
        SEMI_BOLD,
        BOLD
    }


    //--------------------------------Auth module--------------------------------
    public static final String REGISTER = "Account/Register";
    public static final String VALIDATE = "Account/validate-registration-otp";
    public static final String FORGET_PASSWORD = "account/forgot-password";
    public static final String CHANGE_MOBILE = "Account/correct-phone-number";
    public static final String RESEND_SMS = "Account/resend-registration-otp";
    public static final String PROFILE = "Profile/user-profile";
    public static final String SEND_FEED_BACK = "user/send-feedback";
    public static final String EDIT_PROFILE = "account/update-profile";
    public static final String CHANGE_PASSWORD = "account/change-password";


    public static final String LOGOUT = "account/logout";

    //--------------------------------Search--------------------------------


    //--------------------------------Tab Indices--------------------------------
//    public static final int INDEX_HOME = FragNavController.TAB1;
//    public static final int INDEX_PREMIUM = FragNavController.TAB2;
//    public static final int INDEX_INVITE = FragNavController.TAB3;
//    public static final int INDEX_PROFILE = FragNavController.TAB2;

    public static final String COMING_FROM="COMING_FROM";
    public static final String COMING_FROM_LOGIN="COMING_FROM_LOGIN";
    public static final String COMING_FROM_EDIT_PROFILE="COMING_FROM_EDIT_PROFILE";

}
