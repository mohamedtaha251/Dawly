package com.dawly.app.screens.flights;

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
import app.dawly.com.dawly.databinding.FragmentFlightsBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.entities.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightsFragment extends BaseFragment {
        FragmentFlightsBinding fragmentFlightsBinding;
    RecyclerView flightsRecycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentFlightsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_flights, container, false);
        flightsRecycler = fragmentFlightsBinding.flightsRecycler;
        return fragmentFlightsBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        List<Flight> flights  =new ArrayList<>();
        Flight flight = new Flight();
        flight.setExpanded(false);
        flights.add(flight);
        flights.add(flight);
        flights.add(flight);
        flights.add(flight);
        flights.add(flight);
        flights.add(flight);

        FlightsAdapter flightAdapter = new FlightsAdapter(getActivity(),flights);
        flightsRecycler.setHasFixedSize(true);
        flightsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        flightsRecycler.setAdapter(flightAdapter);

    }
}
