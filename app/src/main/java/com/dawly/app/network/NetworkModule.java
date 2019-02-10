package com.dawly.app.network;

import android.util.Log;
import com.dawly.app.storage.DawlyStorage;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Muhammad on 10/1/2017.
 */
@Module
public class NetworkModule {


    @ApplicationScope
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }


    @ApplicationScope
    @Provides
    Interceptor provideInterceptor() {
        return chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();

//            requestBuilder.header("Content-Type", "application/x-www-form-urlencoded");
            requestBuilder.header("Accept:", "application/json");
            requestBuilder.header("Content-Type", "application/json");
            requestBuilder.addHeader("Cache-Control", "no-cache");
            if (DawlyStorage.isLoggedIn()) {
                String token = DawlyStorage.getCurrentUser().getAccessToken();
//                requestBuilder.header("Authorization: Bearer", token);
            }
            requestBuilder.method(original.method(), original.body());
            if (original.body() != null) {
                Buffer buffer = new Buffer();
                original.body().writeTo(buffer);
                Log.d("NetworkLog ", buffer.readUtf8());
            }
            try {
                Request request = requestBuilder.build();
                return chain.proceed(request);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        };
    }


    @ApplicationScope
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Interceptor interceptor) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        try {
        httpClient
                .addInterceptor(loggingInterceptor)
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .cache(null);

//                .sslSocketFactory(new TLSSocketFactory())
        //                .hostnameVerifier(new AllowAllHostnameVerifier())
//        } catch (KeyManagementException | NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        return httpClient.build();
    }


}
