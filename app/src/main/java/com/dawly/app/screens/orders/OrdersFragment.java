package com.dawly.app.screens.orders;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentOrdersBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.entities.Order;
import com.dawly.app.screens.flights.AddFlightPaymentFragment;

import java.util.ArrayList;
import java.util.List;

public class OrdersFragment extends BaseFragment implements View.OnClickListener {
    private FragmentOrdersBinding fragmentFlightOrdersBinding;
    RecyclerView  flightsOrdersRecycler;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFlightOrdersBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders, container, false);
        flightsOrdersRecycler = fragmentFlightOrdersBinding.ordersRecycler;

        return fragmentFlightOrdersBinding.getRoot();
    }


    @Override
    public void onStart() {
        super.onStart();

        Order order = new Order();
        List<Order> orders = new ArrayList<>();

        orders.add(order);
        orders.add(order);
        orders.add(order);
        orders.add(order);
        orders.add(order);
        orders.add(order);
        orders.add(order);

        OrdersAdapter flightAdapter = new OrdersAdapter(getActivity(),orders);
        flightsOrdersRecycler.setHasFixedSize(true);
        flightsOrdersRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        flightsOrdersRecycler.setAdapter(flightAdapter);

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