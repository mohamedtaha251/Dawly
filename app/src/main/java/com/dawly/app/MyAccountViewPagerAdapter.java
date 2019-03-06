package com.dawly.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.dawly.app.screens.myaccount.accountInfo.AccountInfoFragment;

public class MyAccountViewPagerAdapter extends FragmentPagerAdapter {
    public MyAccountViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new AccountInfoFragment();    }

    @Override
    public int getCount() {
        return 3;
    }
}
