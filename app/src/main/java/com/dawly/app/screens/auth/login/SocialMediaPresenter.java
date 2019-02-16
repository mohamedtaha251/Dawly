package com.dawly.app.screens.auth.login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.dawly.app.entities.SocialUser;
import com.facebook.*;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by Muhammad on 12/8/2017.
 */

public class SocialMediaPresenter {
    CallbackManager callbackManager;
    private FacebookLoginListener facebookLoginListener;

    private Context context;


    public SocialMediaPresenter(Context context, FacebookLoginListener facebookLoginListener, CallbackManager callbackManager) {
        this.context = context;
        this.callbackManager = callbackManager;
        this.facebookLoginListener = facebookLoginListener;
    }

    public void registerFaceBookCallback() {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.e("Success facebook ", loginResult.getAccessToken().toString());
                        // App code

                        requestData(loginResult);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Log.e("facebook error ", exception.toString());
                        facebookLoginListener.facebookLoginError(exception);
                    }
                });
    }
    private static final String EMAIL = "email",PUBLIC_PROFILE = "public_profile";

    public void loginWithFacebook() {
        LoginManager.getInstance().logInWithReadPermissions((Activity) context, Arrays.asList(PUBLIC_PROFILE,EMAIL));
    }




    public void requestData(LoginResult loginResult) {
        Log.e("requesting", "data");
        final GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), (object, response) -> {

            try {
                Log.e("facebook response ", response.getJSONObject().toString());
                JSONObject jsonObject = response.getJSONObject();
                String mail = "", id = "", name = "";
                if (jsonObject.has("email")) {
                    mail = jsonObject.getString("email");
                } else {
                    mail = "not available";
                }
                if (jsonObject.has("id")) {
                    id = jsonObject.getString("id");
                } else {
                    id = "not available";
                }
                if (jsonObject.has("name")) {
                    name = jsonObject.getString("name");
                } else {
                    name = "not provided";
                }
                String imagePath = "";
                if (jsonObject.has("picture")) {
                    JSONObject pictureObject = jsonObject.getJSONObject("picture").getJSONObject("data");
                    imagePath = pictureObject.getString("url");
                    Log.e("imagePath", imagePath);
                }
                SocialUser socialUser = new SocialUser();
                socialUser.setAccessToken(loginResult.getAccessToken().getToken());
                socialUser.setDisplayName(name);
                if (!mail.equalsIgnoreCase("not available")) {
                    socialUser.setEmail(mail);
                }
                socialUser.setSocialAccountID(id);

                facebookLoginListener.facebookLoginSuccess(socialUser, mail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,email,picture");
        request.setParameters(parameters);
        request.executeAsync();
    }

    public interface FacebookLoginListener {
        void  facebookLoginSuccess(SocialUser socialLogin, String email);
        void  facebookLoginError(FacebookException exception);
    }

}
