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
import com.dawly.app.entities.Order;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class OrdersAdapter extends PagedListAdapter<Order, OrdersAdapter.FlightsViewHolder> {
    private Context context;
    List<Order> orderList;

    public OrdersAdapter(Context context, List<Order> orderList) {
        super(Order.DIFF_CALLBACK);
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        View itemView;
        switch (itemType) {
            case 0:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_orders_request, viewGroup, false);
                return new FlightsViewHolder(itemView);
            case 1:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_orders_request_expanded, viewGroup, false);
                return new FlightsViewHolder(itemView);
            default:
                itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_orders_request, viewGroup, false);
                return new FlightsViewHolder(itemView);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull FlightsViewHolder viewHolder, int position) {
        viewHolder.bind(orderList.get(position));

    }

    @Override
    public int getItemViewType(int position) {
        if (orderList.get(position).isExpanded())
            return 1;
        else
            return 0;
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class FlightsViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout cardSide;
        RoundedImageView itemImg;

        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.itemImg);

        }


        public void bind(Order order) {
            itemImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (order.isExpanded()) {
                        order.setExpanded(false);
                        notifyDataSetChanged();
                    } else {
                        order.setExpanded(true);
                        notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
