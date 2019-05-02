package com.dawly.app.screens.myaccount.shipmentsCarried;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.dawly.com.dawly.R;

import java.util.List;


public class shipmentCarriedFlightAdapter extends RecyclerView.Adapter<shipmentCarriedFlightAdapter.ViewHolder> {

    private List<Integer> imagesList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    shipmentCarriedFlightAdapter(Context context, List<Integer> data) {
        this.mInflater = LayoutInflater.from(context);
        this.imagesList = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_shipment_carried_flight, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int imgRes= imagesList.get(position);
        holder.ivFlight.setImageResource(imgRes);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return imagesList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivFlight;

        ViewHolder(View itemView) {
            super(itemView);
            ivFlight = itemView.findViewById(R.id.iv_item_shipment_carried_flight);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    int getItem(int id) {
        return imagesList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {


        void onItemClick(View view, int position);
    }
}