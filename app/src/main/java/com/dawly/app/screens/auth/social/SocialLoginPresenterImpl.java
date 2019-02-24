package com.dawly.app.screens.auth.social;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.dawly.app.entities.SocialUser;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.response.SignUpResponse;
import com.facebook.*;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by Muhammad on 1/1/2018.
 */

public class SocialLoginPresenterImpl implements SocialLoginContract.SocialLoginPresenter {

    private static final String EMAIL = "email", PUBLIC_PROFILE = "public_profile";
    CallbackManager callbackManager;


    private SocialLoginContract.SocialLoginInteractor interactor;
    private SocialLoginModel model;

    public SocialLoginPresenterImpl(SocialLoginContract.SocialLoginInteractor loginInteractor) {
        this.interactor = loginInteractor;
        model = new SocialLoginModel(this);
    }


    @Override
    public void onLoginFacebookSucceed(LoginResponse loginResponse) {
        interactor.loginFacebookSuccess(loginResponse);
    }

    @Override
    public void onLoginGoogleSucceed(SignUpResponse signUpResponse) {
        interactor.loginGoogleSuccess(signUpResponse);
    }

    @Override
    public void onLoginFacebookError(String message) {
        interactor.loginFacebookError(message);

    }

    @Override
    public void onLoginGoogleError(String message) {
        interactor.loginGoogleError(message);
    }


    @Override
    public void loginWithGoogle() {
    }


    @Override
    public void loginWithFacebook(Context context, FacebookLoginListener facebookLoginListener, CallbackManager callbackManager) {

        this.callbackManager = callbackManager;

        LoginManager.getInstance().logInWithReadPermissions((Activity) context, Arrays.asList(PUBLIC_PROFILE, EMAIL));

        registerFaceBookCallback(facebookLoginListener, callbackManager);

    }

    public void registerFaceBookCallback(FacebookLoginListener facebookLoginListener, CallbackManager callbackManager) {
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.e("Success facebook ", loginResult.getAccessToken().toString());
                        // App code

                        requestData(loginResult, facebookLoginListener);
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

    public void requestData(LoginResult loginResult, FacebookLoginListener facebookLoginListener) {
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
        void facebookLoginSuccess(SocialUser socialLogin, String email);

        void facebookLoginError(FacebookException exception);
    }


}
