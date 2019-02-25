package com.dawly.app.utils;

import android.app.Activity;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class GoogleHelper {
    public static final int RC_SIGN_IN = 14;
    public static final String CLIENT_ID= "344075834714-9j40grg5pkoktt04ud5bhfaomcerr613.apps.googleusercontent.com";
    public static final String CLIENT_Secret= "Bes_KXFNrqy7CF66E06aJ0by";

    public static void loginGoogle(Activity activity) {
        final GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestProfile()
                .requestIdToken(CLIENT_ID)
                .build();

        final GoogleSignInClient googleClient = GoogleSignIn.getClient(activity, gso);
        final Intent signInIntent = googleClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public static void logOutGoogle(Activity activity) {
        final GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build();
        final GoogleSignInClient googleClient = GoogleSignIn.getClient(activity, gso);
        googleClient.signOut();
    }

}