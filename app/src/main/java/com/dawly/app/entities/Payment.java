package com.dawly.app.entities;

import java.util.ArrayList;

public class Payment {
    public Payment() {
    }


    public static ArrayList<Payment> getDummyPayments()
    {
        ArrayList<Payment> samplePayments = new ArrayList<>();
        samplePayments.add(new Payment());
        samplePayments.add(new Payment());
        samplePayments.add(new Payment());
        samplePayments.add(new Payment());
        samplePayments.add(new Payment());
        samplePayments.add(new Payment());
        samplePayments.add(new Payment());
        samplePayments.add(new Payment());
        samplePayments.add(new Payment());

        return samplePayments;
    }
}
