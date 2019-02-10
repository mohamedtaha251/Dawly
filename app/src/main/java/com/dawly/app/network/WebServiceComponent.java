package com.dawly.app.network;

import dagger.Component;

/**
 * Created by Muhammad on 10/1/2017.
 */


@ApplicationScope
@Component(modules = {AppServiceModule.class, PicassoModule.class, ImageDownloaderModule.class})
public interface WebServiceComponent {

    AppService getAppService();
    ImageDownloader getImageDownloader();

}
