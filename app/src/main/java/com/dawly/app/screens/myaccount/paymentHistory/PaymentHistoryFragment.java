package com.dawly.app.screens.myaccount.paymentHistory;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.Payment;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentHistoryFragment extends Fragment  implements PaymentHistoryRecyclerViewAdapter.ItemClickListener {

    PaymentHistoryRecyclerViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_payment_history, container, false);


        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.rv_payment_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PaymentHistoryRecyclerViewAdapter(getContext(), Payment.getDummyPayments());
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
