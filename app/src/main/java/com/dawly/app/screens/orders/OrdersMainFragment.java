package com.dawly.app.screens.orders;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentOrdersMainBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.screens.flights.AddFlightPaymentFragment;

public class OrdersMainFragment extends BaseFragment implements View.OnClickListener, TabLayout.OnTabSelectedListener {
    private FragmentOrdersMainBinding fragmentFlightOrdersBinding;
    FrameLayout ordersContainer;
    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFlightOrdersBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders_main, container, false);
        ordersContainer = fragmentFlightOrdersBinding.ordersContainer;
        tabLayout = fragmentFlightOrdersBinding.ordersTabLayout;

        tabLayout.addTab(tabLayout.newTab().setText(R.string.orders));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.my_orders));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        return fragmentFlightOrdersBinding.getRoot();
    }


    @Override
    public void onStart() {
        super.onStart();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.ordersContainer, new OrdersFragment()).commit();
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddFlightPaymentFragment()).commit();
                break;
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.ordersContainer, new OrdersFragment()).commit();
                break;
            case 1:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.ordersContainer, new MyOrdersFragment()).commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}