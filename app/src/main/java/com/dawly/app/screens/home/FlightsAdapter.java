package com.dawly.app.screens.home;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.User;

public class FlightsAdapter extends PagedListAdapter<User, RecyclerView.ViewHolder> {


    protected FlightsAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_flight, viewGroup, false);
        return new FlightsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class FlightsViewHolder extends RecyclerView.ViewHolder {

        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
