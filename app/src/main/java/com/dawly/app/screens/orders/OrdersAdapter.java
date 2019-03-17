package com.dawly.app.screens.orders;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.Flight;

public class OrdersAdapter extends PagedListAdapter<Flight, OrdersAdapter.FlightsViewHolder> {
private Context context;

    public OrdersAdapter(Context context) {
        super(Flight.DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order, viewGroup, false);
        return new FlightsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull FlightsViewHolder viewHolder, int position) {


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class FlightsViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout cardSide;
        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
