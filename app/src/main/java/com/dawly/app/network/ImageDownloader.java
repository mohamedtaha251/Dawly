package com.dawly.app.network;

import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by Muhammad on 12/10/2017.
 */

public class ImageDownloader {


    private Picasso picasso;

    public ImageDownloader(Picasso picasso) {
        this.picasso = picasso;
        this.picasso.setIndicatorsEnabled(false);
    }

    public void loadImage(String url, ImageView imageView) {
        if (url != null && imageView != null) {
            if (!url.equalsIgnoreCase(""))
                picasso.load(url).into(imageView);
        }
    }


    public void loadImage(String url, ImageView imageView, int placeholderID) {
        if (url != null && imageView != null) {
            if (!url.equalsIgnoreCase(""))
                picasso.load(url).placeholder(placeholderID).into(imageView);
        }
    }
}
