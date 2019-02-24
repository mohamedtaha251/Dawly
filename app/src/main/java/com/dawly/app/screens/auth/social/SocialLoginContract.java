package com.dawly.app.screens.auth.social;

import android.content.Context;
import android.view.View;
import com.dawly.app.base.BasePresenter;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.response.SignUpResponse;
import com.facebook.CallbackManager;

public class SocialLoginContract {
    /**
     * Created by Muhammad on 1/1/2018.
     */

    public interface SocialLoginInteractor {

        void loginFacebookError(String message);

        void loginFacebookSuccess(LoginResponse loginResponse);

        void loginGoogleError(String message);

        void loginGoogleSuccess(SignUpResponse signUpResponse);
    }


    public interface SocialLoginPresenter {
        void onLoginFacebookSucceed(LoginResponse loginResponse);

        void onLoginGoogleSucceed(SignUpResponse signUpResponse);

        void onLoginFacebookError(String message);

        void onLoginGoogleError(String message);

        void loginWithFacebook(Context context, SocialLoginPresenterImpl.FacebookLoginListener facebookLoginListener, CallbackManager callbackManager);

        void loginWithGoogle();
    }

    public interface ClickListener {
        void onClick(View view);
    }


}
