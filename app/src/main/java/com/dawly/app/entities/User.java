package com.dawly.app.entities;

import com.dawly.app.base.BaseEntity;
import com.dawly.app.utils.Constants;
import com.fasterxml.jackson.annotation.*;
import com.google.android.gms.common.internal.AccountType;


@JsonRootName("")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseEntity {

    @JsonProperty("firstname")
    private String fisrtName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("AccessToken")
    private String AccessToken;

    @JsonProperty("AccountType")
    private AccountType accountType;

    @JsonProperty("TokenType")
    private String TokenType;

    @JsonProperty("ExpiresIn")
    private String ExpiresIn;

    @JsonProperty("Issued")
    private String Issued;

    @JsonProperty("Expires")
    private String Expires;

    @JsonProperty("IsActive")
    private Boolean IsActive;

    @JsonProperty("Id")
    private String Id;

    @JsonProperty("Phone")
    private String phone;


    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        if (Id != null)
            return Id;
        else return "";
    }

    public void setId(String id) {
        Id = id;
    }


    public String getAccessToken() {
        return AccessToken;
    }

    public String getToken() {
        return Constants.BEARER + AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public String getTokenType() {
        return TokenType;
    }

    public void setTokenType(String tokenType) {
        TokenType = tokenType;
    }

    public String getExpiresIn() {
        return ExpiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        ExpiresIn = expiresIn;
    }

    public String getIssued() {
        return Issued;
    }

    public void setIssued(String issued) {
        Issued = issued;
    }

    public String getExpires() {
        return Expires;
    }

    public void setExpires(String expires) {
        Expires = expires;
    }

    public Boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(Boolean isActive) {
        IsActive = isActive;
    }


    public String getFullName() {
        if (fullName != null)
            return fullName;
        else
            return "";
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }
}
