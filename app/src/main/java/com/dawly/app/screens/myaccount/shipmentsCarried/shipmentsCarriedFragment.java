package com.dawly.app.screens.myaccount.shipmentsCarried;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.CompletedOrder;


/**
 * A simple {@link Fragment} subclass.
 */
public class shipmentsCarriedFragment extends Fragment {
    shipmentCarriedAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_shipments_carried, container, false);


        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_orders_completed);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new shipmentCarriedAdapter(getContext(), CompletedOrder.getCompletedOrders());
        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setAdapter(adapter);
        return rootView;
    }

}
