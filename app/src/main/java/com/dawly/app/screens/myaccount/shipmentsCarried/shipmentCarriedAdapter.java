package com.dawly.app.screens.myaccount.shipmentsCarried;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.CompletedOrder;

import java.util.List;


public class shipmentCarriedAdapter extends RecyclerView.Adapter<shipmentCarriedAdapter.ViewHolder> {

    private List<CompletedOrder> completedOrders;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;

    // data is passed into the constructor
    shipmentCarriedAdapter(Context context, List<CompletedOrder> data) {
        this.mInflater = LayoutInflater.from(context);
        this.completedOrders = data;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_shipment_carried, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CompletedOrder completedOrder = completedOrders.get(position);
        holder.tvTitle.setText(R.string.jan_10_hanbag_laptop_capital);
        holder.tvPrice.setText(R.string._50dolar);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return completedOrders.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle;
        TextView tvPrice;

        shipmentCarriedFlightAdapter adapter;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title_item_shipment_carried);
            tvPrice = itemView.findViewById(R.id.tv_price_item_shipment_carried);


            RecyclerView recyclerView = itemView.findViewById(R.id.rv_flight_status_shipment_carried);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true));
            adapter = new shipmentCarriedFlightAdapter(context, CompletedOrder.getFlightStatus());
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(adapter);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    CompletedOrder getItem(int id) {
        return completedOrders.get(id);
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