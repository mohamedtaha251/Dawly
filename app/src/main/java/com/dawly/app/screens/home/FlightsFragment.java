package com.dawly.app.screens.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentAddFlightBinding;
import app.dawly.com.dawly.databinding.FragmentPostRequest1Binding;
import com.dawly.app.base.BaseFragment;

public class FlightsFragment extends BaseFragment {
//    FragmentFlightsBinding fragmentFlightsBinding;
    FragmentAddFlightBinding addFlightBinding;
FragmentPostRequest1Binding fragmentPostRequest1Binding;
    RecyclerView flightsRecycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPostRequest1Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_request1, container, false);
//        flightsRecycler = fragmentFlightsBinding.flightsRecycler;
        return fragmentPostRequest1Binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
//        FlightsAdapter flightAdapter = new FlightsAdapter(getActivity());
//
//        flightsRecycler.setHasFixedSize(true);
//        flightsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        flightsRecycler.setAdapter(flightAdapter);

    }
}
