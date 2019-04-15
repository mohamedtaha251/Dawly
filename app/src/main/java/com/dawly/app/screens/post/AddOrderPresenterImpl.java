package com.dawly.app.screens.post;

import com.dawly.app.entities.Order;
import com.dawly.app.entities.ResponseEntity;
import com.dawly.app.entities.ValidationError;

import java.util.List;

/**
 * Created by Muhammad on 1/1/2018.
 */

public class AddOrderPresenterImpl implements AddOrderContract.AddOrderPresenter {

    private AddOrderContract.AddOrderInteractor addOrderInteractor;
    private AddOrderModel addOrderModel;

    public AddOrderPresenterImpl(AddOrderContract.AddOrderInteractor addOrderInteractor) {
        this.addOrderInteractor = addOrderInteractor;
        addOrderModel = new AddOrderModel(this);
    }






    @Override
    public void onAddOrderError(String message) {
        addOrderInteractor.onAddOrderError(message);

    }

    @Override
    public void onAddOrderSuccess(ResponseEntity<Order> orderResponseEntity) {

        addOrderInteractor.onAddOrderSuccess(orderResponseEntity);
    }

    @Override
    public void onLoginValidationError(List<ValidationError> validationErrorList) {
        addOrderInteractor.showValidationErrors(validationErrorList);

    }

    @Override
    public void stop() {
        addOrderModel.stop();
    }

    @Override
    public void start(Object user) {
        addOrderModel.start( user);
    }


}
