package com.dawly.app.base;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/**
 * Created by Muhammad on 3/14/2018.
 */

public abstract class BaseModel<T> implements BaseContract.RequestHandler {

    protected void start(T model) {

    }

    protected void start() {

    }

    protected abstract void stop();

    protected abstract void onComplete();

    public String handleOnError(Throwable throwable) {
        if (throwable != null && throwable instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) throwable)
                    .response().errorBody();
//            Log.e("code::", ((HttpException) throwable).code() + " ::"+throwable.getMessage());
//            if (((HttpException) throwable).code() == 500)
//                return "Something is not right";
//            else
            return getErrorMessage(responseBody);
        } else {
            return "";
        }
    }


    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return (String) jsonObject.getJSONArray("Errors").get(0);
        } catch (Exception e) {
            return "";
        }
    }


}
