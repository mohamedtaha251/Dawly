package com.dawly.app.screens.home;

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

public class FlightsAdapter extends PagedListAdapter<Flight, FlightsAdapter.FlightsViewHolder> {
private Context context;

    protected FlightsAdapter(Context context) {
        super(Flight.DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_flight, viewGroup, false);
        return new FlightsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull FlightsViewHolder viewHolder, int position) {
        if (position%2 == 0){
            viewHolder.cardSide.setBackgroundColor(context.getResources().getColor(R.color.colorCardSide1));
        }else{
            viewHolder.cardSide.setBackgroundColor(context.getResources().getColor(R.color.colorCardSide2));
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class FlightsViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout cardSide;
        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);
            cardSide = itemView.findViewById(R.id.cardSideLayout);
        }
    }
}
