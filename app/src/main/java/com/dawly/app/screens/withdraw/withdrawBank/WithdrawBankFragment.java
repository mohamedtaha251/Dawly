package com.dawly.app.screens.withdraw.withdrawBank;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WithdrawBankFragment extends Fragment {

    private FragmentManager fragmentManager;
    ViewPager viewPager;
    TabLayout indicator;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_withdraw_bank, container, false);

        viewPager = rootView.findViewById(R.id.viewPager_withdraw_bank);
        indicator = rootView.findViewById(R.id.indicator_withdraw_bank);

        fragmentManager = getActivity().getSupportFragmentManager();


        viewPager.setAdapter(new WithdrawSliderAdapter(fragmentManager, getContext()));
        indicator.setupWithViewPager(viewPager, true);

        return rootView;
    }

}
