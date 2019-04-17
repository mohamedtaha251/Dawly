package com.dawly.app.screens.post;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentPostRequest4Binding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.entities.Order;
import com.dawly.app.entities.ResponseEntity;
import com.dawly.app.entities.ValidationError;
import com.dawly.app.views.DawlyButtonBold;

import javax.inject.Inject;
import java.util.List;

public class PostRequestFragmentStep4 extends BaseFragment implements View.OnClickListener,AddOrderContract.AddOrderInteractor {

    private FragmentPostRequest4Binding fragmentPostRequestBinding;
    @Inject
    AddOrderPresenterImpl addOrderPresenter;
    DawlyButtonBold doneBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPostRequestBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_request4, container, false);
        doneBtn = fragmentPostRequestBinding.doneBtn;
        doneBtn.setOnClickListener(this);
        return fragmentPostRequestBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.doneBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlightProcessedFragment()).commit();
                break;
        }
    }

    @Override
    public void showValidationErrors(List<ValidationError> validationErrorList) {

    }

    @Override
    public void onAddOrderError(String message) {

    }

    @Override
    public void onAddOrderSuccess(ResponseEntity<Order> responseEntity) {

    }
}
