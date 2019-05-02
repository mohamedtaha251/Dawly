package com.dawly.app.screens.orders;

import androidx.paging.PagedListAdapter;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.Flight;

public class MyOrdersAdapter extends PagedListAdapter<Flight, MyOrdersAdapter.FlightsViewHolder> {
private Context context;

    public MyOrdersAdapter(Context context) {
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
