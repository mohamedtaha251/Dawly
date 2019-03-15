package com.dawly.app.screens.myaccount.balanceInfo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import app.dawly.com.dawly.R;
import com.dawly.app.screens.myaccount.paymentHistory.PaymentHistoryFragment;
import com.dawly.app.screens.myaccount.pendingsOrders.PendingsOrdersFragment;

public class BalanceInfoViewPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_FRAGMENTS = 2;
    private Context context;

    public BalanceInfoViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PaymentHistoryFragment();
            case 1:
                return new PendingsOrdersFragment();
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
                return context.getString(R.string.payment_history);
            case 1:
                return context.getString(R.string.pending_orders);
            default:
                return null;
        }
    }


}
