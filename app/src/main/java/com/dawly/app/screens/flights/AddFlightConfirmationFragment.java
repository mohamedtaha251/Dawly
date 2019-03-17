package com.dawly.app.screens.flights;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentAddFlightConfirmationBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.views.DawlyButtonBold;

public class AddFlightConfirmationFragment extends BaseFragment implements View.OnClickListener {
    private FragmentAddFlightConfirmationBinding addFlightConfirmationFragment;
    DawlyButtonBold submitBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addFlightConfirmationFragment = DataBindingUtil.inflate(inflater, R.layout.fragment_add_flight_confirmation, container, false);
        submitBtn = addFlightConfirmationFragment.confirmBtn;
        submitBtn.setOnClickListener(this);
        return addFlightConfirmationFragment.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddFlightDoneFragment()).commit();
                break;
        }
    }
}