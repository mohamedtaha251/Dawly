package com.dawly.app.screens.withdraw.withdrawPaypal;


import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WithdrawPaypal extends Fragment {

    private FragmentManager fragmentManager;
    private ViewPager viewPager;
    private TabLayout indicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_withdraw_paypal, container, false);

        viewPager = rootView.findViewById(R.id.viewPager_withdraw_paypal);
        indicator = rootView.findViewById(R.id.indicator_withdraw_paypal);

        fragmentManager = getActivity().getSupportFragmentManager();


        viewPager.setAdapter(new PaypalSliderAdapter(fragmentManager, getContext()));
        indicator.setupWithViewPager(viewPager, true);

        return rootView;

    }

}
