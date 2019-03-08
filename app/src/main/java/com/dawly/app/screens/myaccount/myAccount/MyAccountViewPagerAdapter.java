package com.dawly.app.screens.myaccount.myAccount;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import app.dawly.com.dawly.R;
import com.dawly.app.screens.myaccount.accountSettings.AccountSettingsFragment;
import com.dawly.app.screens.myaccount.balanceInfo.BalanceInfoFragment;
import com.dawly.app.screens.myaccount.accountInfo.AccountInfoFragment;

public class MyAccountViewPagerAdapter extends FragmentPagerAdapter {
    static final int NUM_FRAGMENTS = 3;
    private Context context;

    public MyAccountViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AccountInfoFragment();
            case 1:
                return new BalanceInfoFragment();
            case 2:
                return new AccountSettingsFragment();
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
                return context.getString(R.string.account_info);
            case 1:
                return context.getString(R.string.balance_info);
            case 2:
                return context.getString(R.string.account_settings);
            default:
                return null;
        }
    }
}
