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

    @JsonProperty("FullName")
    private String fullName;
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("AccessToken")
    private String AccessToken;
    @JsonProperty("Name")
    private String Name;
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


    @JsonProperty("FavoriteOffersCount")
    private int FavoriteOffersCount;
    @JsonProperty("TransactionsCount")
    private int TransactionsCount;
    @JsonProperty("NotificationsCount")
    private int NotificationsCount;
    @JsonProperty("SavingsValue")
    private int SavingsValue;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    private String UserId;
    private String NewNumber;
    private String OldNumber;
    private String Password;
    private String confirmPassword;
    private String mobileNumber;
    private String referralCode;
    private String genderID;
    private String birthDate;
    private String accTypeID;
    private String profilePicName;
    private String profilePicPath;
    private String grant_type;
    private int LanguageId;
    private String OTP;
    private String theName;

    public String getTheName() {
        if (!getName().equalsIgnoreCase(""))
            return getName();
        else
            return getFullName();
    }

    public void setTheName(String theName) {
        this.theName = theName;
    }

    public int getFavoriteOffersCount() {
        return FavoriteOffersCount;
    }

    public void setFavoriteOffersCount(int favoriteOffersCount) {
        FavoriteOffersCount = favoriteOffersCount;
    }

    public int getTransactionsCount() {
        return TransactionsCount;
    }

    public void setTransactionsCount(int transactionsCount) {
        TransactionsCount = transactionsCount;
    }

    public int getNotificationsCount() {
        return NotificationsCount;
    }

    public void setNotificationsCount(int notificationsCount) {
        NotificationsCount = notificationsCount;
    }

    public int getSavingsValue() {
        return SavingsValue;
    }

    public void setSavingsValue(int savingsValue) {
        SavingsValue = savingsValue;
    }



    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        IsActive = active;
    }

    public String getOldNumber() {
        return OldNumber;
    }

    public void setOldNumber(String oldNumber) {
        OldNumber = oldNumber;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getNewNumber() {
        return NewNumber;
    }

    public void setNewNumber(String newNumber) {
        NewNumber = newNumber;
    }


    public String getPhoneNumber() {
        if (phoneNumber != null)
            return phoneNumber;
        else
            return phone;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhone() {
        if (phoneNumber != null)
            return phoneNumber;
        else if (phone != null)
            return phone;
        else
            return "";
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

    public String getName() {
        if (Name != null)
            return Name;
        else
            return "";
    }

    public void setName(String name) {
        Name = name;
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

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public int getLanguageId() {
        return LanguageId;
    }

    public void setLanguageId(int languageId) {
        LanguageId = languageId;
    }


    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getProfilePicName() {
        return profilePicName;
    }

    public void setProfilePicName(String profilePicName) {
        this.profilePicName = profilePicName;
    }

    public String getProfilePicPath() {
        return profilePicPath;
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getGenderID() {
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAccTypeID() {
        return accTypeID;
    }

    public void setAccTypeID(String accTypeID) {
        this.accTypeID = accTypeID;
    }


}
