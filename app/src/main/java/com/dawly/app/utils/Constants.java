package com.dawly.app.utils;



public class Constants {
    //--------------------------------Keys--------------------------------





   //Production
    public static final String BASE_URL = "https://luckycommonapi.dsquares.com/api/";
    public static final String BASE_URL_AUTH = "https://luckyfrontend.dsquares.com/api/";

    public static final String AM_PRODUCTION_KEY = "97caf2beda13f2279c386b12f0247d77";
    public static final String AM_STAGING_KEY = "5f42f510d1de7b90f76ce630fa67b4ed";

    //Staging
//    public static final String BASE_URL = "https://luckystagingcommonapi.dsquares.com/api/";
//    public static final String BASE_URL_AUTH = "https://luckyStagingFrontEnd.dsquares.com/api/";


    public static final String BEARER ="bearer ";



    public static final String TERMS_URL = "https://thelucky.app/#/pages/policy";
    public static final String SHARE_URL = "https://luckystagingfrontend.dsquares.com/offer?id=";

    public static final String PLACEHOLDER = "https://couponzimages74.dsquares.com/Lucky/images/Logo";
    public static final String LOGIN = "Account/login";
    public static final String PASSWORD = "password";
    public static final String USER = "user";
    public static final int COUNTDOWN_TIME = 60 * 1000;
    public static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";


    //-----------------------------Tracking Params-------------------------------//
    public static final String PLATFORM = "";
    public static final String APP_INSTALL_EVENT =  "app_install_app";
    public static final String LOAD_FEED = "discover_load_feed";
    public static final String VIEW_OFFER = "discover_view_offer";
    public static final String REDEEM_OFFER_TAP_EVENT = "redeem_tap_redeem";
    public static final String LOGIN__COMPLETE_EVENT = "login_complete";
    public static final String EVENT_SCAN_QR = "redeem_scan_qr";
    public static final String LOGIN_EVENT = "login_view";
    public static final String LOGIN_FROM_FAVORITE_EVENT = "favorite";
 public static final String REDEEM_COMPLETED_EVENT  = "redeem_complete_redeem";
    public static final String LOGIN_FROM_PREMIUM = "premium";





    //----------------------------Firebase Params----------------------------
    public static final String kFIRRESULTS_COUNT = "Results_count";
    public static final String kFIRPAGE_NUMBER = "Page_number";
    public static final String kFIRSEARCH_QUERY = "Search_query";
    public static final String kFIRCATEGORY_ID = "Category_ID";
    public static final String kFIROFFER_ID = "Offer_ID";
    public static final String kFIRLOGIN_STATUS = "Login_status";



    public static final String SIGN_UP = "Successful sign up of user";
    public static final String USER_ID = "user_id";
    public static final String SOURCE = "source";
    public static final String FLOW = "flow";
    public static final String EVENT_OFFER_ID = "offer_id";
    public static final String CATEGORY_ID = "category_id";

    public static final String RESULTS_COUNT = "results_count";
    public static final String PAGE_NUMBER = "page_number";
    public static final String SEARCH_QUERY = "search_ query";
    public static final String MERCHANT_ID = "merchant_id";
    public static final String LOGIN_STATUS = "login_status";
    public static final String ANONYMOUS = "anonymous";
    public static final String LOGGED_IN = "logged_in";
    public static final String VERSION = "app_version";
    public static final String OS = "os_name";
    public static final String OS_VERSION = "os_version";
    public static final String DEVICE_TYPE = "device_model";
    public static final String LANGUAGE = "language";
    public static final String HOME = "home";
    public static final String SEARCH = "search";
    public static final String LONGITUDE = "longitude";
    public static final String LATITUDE = "latitude";


    //-------------------API Params----------------------------------
    public static final String SEARCH__QUERY = "SearchString";
    public static final String LANG_ID = "LanguageId";
    public static final String TAKE = "Take";
    public static final String SKIP = "Skip";
    public static final String USER_PHONE= "userPhoneNumber";
    public static final int ITEMS_PER_PAGE= 10;
    public static final int SEARCH_ITEMS_PER_PAGE= 4;












    public static final String PIN_CODE = "pincode";
    public static final String OFFER_LIST = "historyList";
    public static final String MERCHANT_LIST = "merchantList";
    public static final String OFFER_ID = "offerID";
    public static final String OFFER = "offer";
    public static final String QUERY = "query";
    public static final String CATEGORY_NAME = "catName";
    public static final String REDEEM = "redeemData";
    public static final String SMS_SENDER = "Dsquares";
    public static final String ARABIC_KEY = "ar";
    public static final String ENGLISH_KEY = "en";
    public static final int ARABIC = 2;
    public static final int ENGLISH = 1;




    //--------------------------------Status Codes--------------------------------
    public static final int SUCCESS = 200;
    public static final int FAIL = 400;

    //--------------------------------Font Family--------------------------------
    public static final String PROXIMA_REGULAR = "fonts/proxima_regular.ttf";
    public static final String PROXIMA_SEMI_BOLD = "fonts/proxima_semi_bold.ttf";
    public static final String PROXIMA_BOLD = "fonts/proxima_bold.ttf";
    public static final String PROXIMA_THIN = "fonts/proxima_thin.ttf";

    public static final String CAIRO_REGULAR = "fonts/cairo_regular.ttf";
    public static final String CAIRO_SEMI_BOLD = "fonts/cairo_semi_bold.ttf";
    public static final String CAIRO_BOLD = "fonts/cairo_bold.ttf";
    public static final String CAIRO_THIN = "fonts/cairo_light.ttf";
    public static final String HISTORY = "Transaction/user-history";
    public static final String PHONE_NUMBER = "PHONE_NUMBER";
    public static final String COMING_FROM_SIGNUP = "COMING_FROM_SIGNUP";
    public static final String LOGIN_EVENT_FIREBASE ="LOGIN" ;
    public static final String EVENT_REDEEM_COMPLETE = "redeem_complete_redeem";
    public static final String TRANSACTION_ID = "transaction_id" ;

    public static final String SIGN_IN = "signin";
    public static final String SIGN_UP_EVENT = "signup";
    public static final String REDEEM_EVENT = "redeem";
    public static final String LOGIN_FROM_PROFILE = "profile";

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

    //--------------------------------Offers--------------------------------
    public static final String REGULAR_OFFERS = "offer/regular-offers";
    public static final String REGULAR_OFFERS_BY_GEO_LOCATION = "offer/regular-offers-by-geolocation";
    public static final String DEFAULT_BUNDLE = "bundle/default";
    public static final String MERCHANTS_BUNDLE = "merchant/premium";
    public static final String GET_CATEGORY = "lookup/category";
    public static final String REDEEM_OFFER = "offer/redeem-offer";
    public static final String ADD_TO_FAVORITES = "offer/add-to-favorite";
    public static final String GET_FAVORITES = "offer/get-favorite-offers";

    public static final String REMOVE_FROM_FAVORITES = "offer/remove-from-favorite";

    //--------------------------------Search--------------------------------
    public static final String MERCHANT_SEARCH = "merchant/search";
    public static final String OFFER_SEARCH = "offer/search";


    //--------------------------------Tab Indices--------------------------------
//    public static final int INDEX_HOME = FragNavController.TAB1;
//    public static final int INDEX_PREMIUM = FragNavController.TAB2;
//    public static final int INDEX_INVITE = FragNavController.TAB3;
//    public static final int INDEX_PROFILE = FragNavController.TAB2;
    public static final String ARGS_INSTANCE = "LUCKY";

    public static final String COMING_FROM="COMING_FROM";
    public static final String COMING_FROM_LOGIN="COMING_FROM_LOGIN";
    public static final String COMING_FROM_EDIT_PROFILE="COMING_FROM_EDIT_PROFILE";

}
