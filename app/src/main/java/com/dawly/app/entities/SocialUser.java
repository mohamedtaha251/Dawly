package com.dawly.app.entities;

import java.io.Serializable;

public class SocialUser implements Serializable {
    private String socialAccountID;
    private String email;
    private String accessToken;
    private String displayName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSocialAccountID() {
        return socialAccountID;
    }

    public void setSocialAccountID(String socialAccountID) {
        this.socialAccountID = socialAccountID;
    }
}