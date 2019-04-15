package com.dawly.app.screens.post;

import com.dawly.app.base.BasePresenter;
import com.dawly.app.entities.Order;
import com.dawly.app.entities.ResponseEntity;
import com.dawly.app.entities.ValidationError;

import java.util.List;

public class AddOrderContract {
    /**
     * Created by Muhammad on 1/1/2018.
     */

    public  interface AddOrderInteractor {
        void showValidationErrors(List<ValidationError> validationErrorList);
        void onAddOrderError(String message);
        void onAddOrderSuccess(ResponseEntity<Order> responseEntity);
    }


    public  interface AddOrderPresenter extends BasePresenter {
        void onAddOrderError(String message);
        void onAddOrderSuccess(ResponseEntity<Order> responseEntity);
        void onLoginValidationError(List<ValidationError> validationErrorList);
    }


}
