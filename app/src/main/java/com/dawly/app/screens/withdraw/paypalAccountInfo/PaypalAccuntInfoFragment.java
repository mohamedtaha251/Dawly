package com.dawly.app.screens.withdraw.paypalAccountInfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaypalAccuntInfoFragment extends Fragment {


    public PaypalAccuntInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paypal_accunt_info, container, false);
    }

}
