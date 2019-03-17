package com.dawly.app.screens.messages;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentFlightOrdersBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.screens.flights.AddFlightPaymentFragment;

public class MessagesFragment extends BaseFragment implements View.OnClickListener {
    private FragmentFlightOrdersBinding fragmentFlightOrdersBinding;
    RecyclerView  flightsOrdersRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFlightOrdersBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight_orders, container, false);
        flightsOrdersRecycler = fragmentFlightOrdersBinding.flightsRecycler;
        return fragmentFlightOrdersBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddFlightPaymentFragment()).commit();
                break;
        }
    }
}