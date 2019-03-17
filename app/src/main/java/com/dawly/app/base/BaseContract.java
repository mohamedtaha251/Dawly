package com.dawly.app.base;

import android.location.Location;
import android.view.View;

public interface BaseContract {


    interface ClickListener {
        void onClick(View view);
    }
      interface HomeClickListener {
        void onCategoryClick(View view, int position);
        void onFavouriteClicked(View view, Integer position);
    }


    interface AddClickListener {
        void onAddFlightClick(View view);
        void onAddOrderClick(View view);
    }



    interface RequestHandler<T> {
        void onSuccess(T baseEntity);

        void onError(Throwable throwable);
    }


    interface LocationDetected{
        void locationDetectedSuccess(Location location);
        void locationDetectedError(Location location);
    }

}
