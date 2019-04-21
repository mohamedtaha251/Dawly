package com.dawly.app.entities;

import app.dawly.com.dawly.R;

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

    public static ArrayList<Integer> getFlightStatus()
    {
        ArrayList<Integer> imgList = new ArrayList<>();
        imgList.add(R.drawable.ic_rectangle_copy_12);
        imgList.add(R.drawable.ic_rectangle_copy_12);
        imgList.add(R.drawable.ic_rectangle_copy_13);
        imgList.add(R.drawable.ic_rectangle_copy_8);


        return imgList;
    }


}
