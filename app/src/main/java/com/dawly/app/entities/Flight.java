package com.dawly.app.entities;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.dawly.app.base.BaseEntity;

public class Flight extends BaseEntity {

    private static int increment = 0;

    private long ids;

    public Flight() {
        ids = ++increment;
    }


    public long getIds() {
        return ids;
    }

    public void setIds(long ids) {
        this.ids = ids;
    }

    public static final DiffUtil.ItemCallback<Flight> DIFF_CALLBACK = new DiffUtil.ItemCallback<Flight>() {

        @Override
        public boolean areItemsTheSame(@NonNull Flight oldOffer, @NonNull Flight newOffer) {
            return oldOffer.getIds() == newOffer.getIds();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Flight oldOffer, @NonNull Flight newOffer) {
            return oldOffer.equals(newOffer);
        }
    };

    private boolean isExpanded;


    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
