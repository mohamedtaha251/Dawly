package com.dawly.app.network;


import com.dawly.app.entities.response.LoginResponse;
import com.dawly.app.entities.ResponseEntity;
import com.dawly.app.entities.User;
import com.dawly.app.entities.response.SignUpResponse;
import com.dawly.app.utils.Constants;
import io.reactivex.Observable;
import retrofit2.http.*;

/**
 * Created by Muhammad on 10/1/2017.
 */

public interface AppService {


    //--------------------------------Auth API--------------------------------------
    // @Headers({
    // "Accept: application/json",
    //"Content-Type: application/json"})
    //@FormUrlEncoded
    @POST
    Observable<LoginResponse> login(@Url String url, @Body User user);

    @POST
    Observable<SignUpResponse> signUp(@Url String url, @Body User user);

    @POST
    Observable<ResponseEntity<String>> logout(@Url String url, @Header("Authorization") String token, @Query("token") String authToken);

    @POST
    Observable<ResponseEntity<User>> register(@Url String url, @Body User user);




    @PUT
    Observable<ResponseEntity<String>> changeMobile(@Url String url, @Body User user);


    @GET(Constants.PROFILE)
    Observable<ResponseEntity<User>> getProfile(@Header("Authorization") String authorization);



    @GET
    Observable<ResponseEntity<String>> resendOTP(@Url String url, @Query("email") String email);



}
