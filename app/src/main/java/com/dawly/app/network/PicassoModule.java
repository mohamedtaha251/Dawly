package com.dawly.app.network;

import android.app.Application;
import com.dawly.app.application.ApplicationModule;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Muhammad on 10/1/2017.
 */
@Module(includes = {ApplicationModule.class, NetworkModule.class})
public class PicassoModule {

    @ApplicationScope
    @Provides
    Picasso providePicasso(Application application, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(application)
//                .downloader(okHttp3Downloader)
                .build();
    }
    @ApplicationScope
    @Provides
    OkHttp3Downloader provideOkHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}
