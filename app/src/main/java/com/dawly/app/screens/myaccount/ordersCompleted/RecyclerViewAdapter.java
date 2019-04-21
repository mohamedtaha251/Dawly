package com.dawly.app.screens.myaccount.ordersCompleted;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.dawly.com.dawly.R;
import com.dawly.app.entities.CompletedOrder;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<CompletedOrder> completedOrders;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public RecyclerViewAdapter(Context context, List<CompletedOrder> data) {
        this.mInflater = LayoutInflater.from(context);
        this.completedOrders = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_order_completed, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CompletedOrder completedOrder = completedOrders.get(position);
        holder.tvHeader.setText(R.string.jan_10_hanbag_laptop);
        holder.tvBody.setText(R.string.shopping_with_dawly_doesn_apos_t_only_bring_the_world_to_you_it_also_allows_you_to_save_money_on_various_fees_like_shipping);
        holder.ivOrderImg.setImageResource(R.drawable.ic_tutorial_1_vector);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return completedOrders.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvHeader;
        TextView tvBody;
        ImageView ivOrderImg;

        ViewHolder(View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tv_item_order_completed_header);
            tvBody = itemView.findViewById(R.id.tv_item_order_completed_body);
            ivOrderImg = itemView.findViewById(R.id.iv_oder_image_oder_completed_item);
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