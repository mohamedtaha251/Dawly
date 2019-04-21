package com.dawly.app.screens.myaccount.ordersCompleted;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.CompletedOrder;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrdersCompletedFragments extends Fragment implements RecyclerViewAdapter.ItemClickListener {

    RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_orders_completed, container, false);


        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_orders_completed);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapter(getContext(), CompletedOrder.getCompletedOrders());
        recyclerView.setNestedScrollingEnabled(false);

        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;

    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

}
