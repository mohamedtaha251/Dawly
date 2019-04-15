package com.dawly.app.screens.post;

import com.dawly.app.application.DawlyApp;
import com.dawly.app.base.BaseModel;
import com.dawly.app.entities.Order;
import com.dawly.app.entities.ResponseEntity;
import com.dawly.app.network.AppService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Muhammad on 1/1/2018.
 */

public class AddOrderModel extends BaseModel {
    private AddOrderContract.AddOrderPresenter addOrderPresenter;

    private final CompositeDisposable mDisposable = new CompositeDisposable();
    private AppService appService;

    public AddOrderModel(AddOrderContract.AddOrderPresenter addOrderPresenter) {
        this.addOrderPresenter = addOrderPresenter;
        initAPICall();
    }

    private void initAPICall() {
        appService = DawlyApp.getServiceComponent().getAppService();
    }

    @Override
    protected void start(Object user) {
        mDisposable.add(appService.addOrder( "",(Order) user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError, this::onComplete));
    }

    public void stop() {
        mDisposable.clear();
    }

    @Override
    protected void onComplete() {

    }


    @Override
    public void onSuccess(Object user) {
        ResponseEntity<Order> user1 = (ResponseEntity<Order>) user;
        addOrderPresenter.onAddOrderSuccess(user1);


    }

    @Override
    public void onError(Throwable throwable) {
        addOrderPresenter.onAddOrderError(handleOnError(throwable));
    }
}
