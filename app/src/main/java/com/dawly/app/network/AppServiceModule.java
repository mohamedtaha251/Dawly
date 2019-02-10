package com.dawly.app.network;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Named;

import static com.dawly.app.utils.Constants.BASE_URL;

/**
 * Created by Muhammad on 10/1/2017.
 */
@Module(includes = NetworkModule.class)
public class AppServiceModule {

    ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_0)
            .allEnabledCipherSuites()
            .build();

    @ApplicationScope
    @Provides
    AppService provideAppService(Retrofit retrofit) {
        return retrofit.create(AppService.class);
    }

    @ApplicationScope
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient
            , JacksonConverterFactory factory, RxJava2CallAdapterFactory adapterFactory
            , @Named("base_url") BaseUrlHolder baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl.getBaseUrl())
                .addConverterFactory(factory)
                .addCallAdapterFactory(adapterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Named("base_url")
    public BaseUrlHolder provideBaseUrl() {
        return new BaseUrlHolder(BASE_URL);
    }


    @ApplicationScope
    @Provides
    ObjectMapper provideObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRAP_ROOT_VALUE);
        objectMapper.disable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        return objectMapper;
    }

    @ApplicationScope
    @Provides
    JacksonConverterFactory provideJacksonConverterFactory(ObjectMapper objectMapper) {
        return JacksonConverterFactory.create(objectMapper);
    }

    @ApplicationScope
    @Provides
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

}
