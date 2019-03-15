package com.dawly.app.screens.myaccount.paymentHistory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.Payment;

import java.util.List;


public class PaymentHistoryRecyclerViewAdapter extends RecyclerView.Adapter<PaymentHistoryRecyclerViewAdapter.ViewHolder> {

    private List<Payment> payments;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public PaymentHistoryRecyclerViewAdapter(Context context, List<Payment> data) {
        this.mInflater = LayoutInflater.from(context);
        this.payments = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_payment_history, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Payment payment= payments.get(position);
        holder.tvHeader.setText(R.string.jan_10_hanbag_laptop);
        holder.tvPrice.setText(R.string._125);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return payments.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvHeader;
        TextView tvPrice;

        ViewHolder(View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tv_item_payment_history_header);
            tvPrice = itemView.findViewById(R.id.iv_payment_price_payment_history_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Payment getItem(int id) {
        return payments.get(id);
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