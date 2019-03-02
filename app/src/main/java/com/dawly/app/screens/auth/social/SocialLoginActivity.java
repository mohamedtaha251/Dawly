package com.dawly.app.screens.auth.social;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import app.dawly.com.dawly.R;
import com.dawly.app.base.BaseActivity;
import com.dawly.app.entities.SocialUser;
import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.response.SignUpResponse;
import com.dawly.app.screens.auth.login.LoginActivity;
import com.dawly.app.screens.tutorial.TutorialActivity;
import com.dawly.app.utils.GoogleHelper;
import com.dawly.app.utils.Toaster;
import com.dawly.app.views.DawlyButtonMontserratBold;
import com.facebook.CallbackManager;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import dagger.android.AndroidInjection;

import javax.inject.Inject;

import static com.dawly.app.utils.GoogleHelper.RC_SIGN_IN;

public class SocialLoginActivity extends BaseActivity implements SocialLoginContract.SocialLoginInteractor, SocialLoginPresenterImpl.FacebookLoginListener {
    @Inject
    SocialLoginPresenterImpl presenter;
    CallbackManager callbackManager;
    DawlyButtonMontserratBold btnFacebook;
    DawlyButtonMontserratBold btnGoogle;
    DawlyButtonMontserratBold btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //init
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login_social);
        getSupportActionBar().hide();

        //init
        btnFacebook = findViewById(R.id.btn_login_facebook);
        btnGoogle = findViewById(R.id.btn_login_google);
        btnEmail = findViewById(R.id.btn_continue_with_email);
        callbackManager = CallbackManager.Factory.create();


        actions();

    }

    private void actions() {

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginWithFacebook(SocialLoginActivity.this, SocialLoginActivity.this, callbackManager);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleHelper.logOutGoogle(SocialLoginActivity.this);
                GoogleHelper.loginGoogle(SocialLoginActivity.this);

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SocialLoginActivity.this, LoginActivity.class));
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                startActivity(new Intent(SocialLoginActivity.this, TutorialActivity.class));
            } catch (ApiException e) {
            }
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public void loginFacebookError(String message) {
        Toaster.showShort(getBaseContext(),message);


    }

    @Override
    public void loginGoogleError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginGoogleSuccess(SignUpResponse signUpResponse) {
    }

    @Override
    public void loginFacebookSuccess(LoginResponse loginResponse) {
        startActivity(new Intent(this, TutorialActivity.class));

    }

    @Override
    public void facebookLoginSuccess(SocialUser socialLogin, String email) {
    }

    @Override
    public void facebookLoginError(FacebookException exception) {

    }

}
