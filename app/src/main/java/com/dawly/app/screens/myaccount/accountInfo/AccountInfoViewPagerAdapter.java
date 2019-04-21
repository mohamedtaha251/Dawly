package com.dawly.app.screens.myaccount.accountInfo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import app.dawly.com.dawly.R;
import com.dawly.app.screens.myaccount.ordersCompleted.OrdersCompletedFragments;
import com.dawly.app.screens.myaccount.shipmentsCarried.shipmentsCarriedFragment;

public class AccountInfoViewPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_FRAGMENTS = 2;
    private Context context;

    public AccountInfoViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OrdersCompletedFragments();
            case 1:
                return new shipmentsCarriedFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.orders_completed);
            case 1:
                return context.getString(R.string.shipments_carried);
            default:
                return null;
        }
    }


}
