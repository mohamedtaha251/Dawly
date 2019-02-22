package com.dawly.app.base;

/**
 * Created by Muhammad on 3/6/2018.
 */

public interface BasePresenter<T> {
    void stop();
    void loginWithFacebook(T Model);
}
