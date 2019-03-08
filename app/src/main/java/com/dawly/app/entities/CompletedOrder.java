package com.dawly.app.entities;

import java.util.ArrayList;

public class CompletedOrder {
    public CompletedOrder() {
    }


    public static ArrayList<CompletedOrder> getCompletedOrders()
    {
        ArrayList<CompletedOrder> sampleOrders = new ArrayList<>();
        sampleOrders.add(new CompletedOrder());
        sampleOrders.add(new CompletedOrder());
        sampleOrders.add(new CompletedOrder());
        sampleOrders.add(new CompletedOrder());
        sampleOrders.add(new CompletedOrder());
        sampleOrders.add(new CompletedOrder());
        sampleOrders.add(new CompletedOrder());
        sampleOrders.add(new CompletedOrder());
        sampleOrders.add(new CompletedOrder());

        return sampleOrders;
    }
}
