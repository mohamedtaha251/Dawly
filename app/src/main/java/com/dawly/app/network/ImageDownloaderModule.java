package com.dawly.app.network;

import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Muhammad on 12/10/2017.
 */
@Module
public class ImageDownloaderModule {

    @ApplicationScope
    @Provides
    ImageDownloader provideImageDownloader(Picasso picasso){
        return new ImageDownloader(picasso);
    }
}
