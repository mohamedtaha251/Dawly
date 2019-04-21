package com.dawly.app.screens.orders;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentMyOrdersBinding;
import com.dawly.app.base.BaseFragment;

public class MyOrdersFragment extends BaseFragment {


    private FragmentMyOrdersBinding fragmentMyOrdersBinding;
    RecyclerView flightsOrdersRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMyOrdersBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_orders, container, false);
        flightsOrdersRecycler = fragmentMyOrdersBinding.myOrdersRecycler;

        return fragmentMyOrdersBinding.getRoot();
    }


    @Override
    public void onStart() {
        super.onStart();
        MyOrdersAdapter flightAdapter = new MyOrdersAdapter(getActivity());
        flightsOrdersRecycler.setHasFixedSize(true);
        flightsOrdersRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        flightsOrdersRecycler.setAdapter(flightAdapter);

    }


}
