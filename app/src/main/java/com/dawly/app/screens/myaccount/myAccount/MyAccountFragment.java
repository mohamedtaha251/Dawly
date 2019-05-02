package com.dawly.app.screens.myaccount.myAccount;


import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import com.dawly.app.screens.myaccount.accountInfo.AccountInfoViewPagerAdapter;

public class MyAccountFragment extends Fragment {

    private MyAccountViewPagerAdapter adapter;
    private ViewPager mViewPager;
    private FragmentManager fragmentManager;
    private int PAGE_LIMIT = MyAccountViewPagerAdapter.NUM_FRAGMENTS * AccountInfoViewPagerAdapter.NUM_FRAGMENTS;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_account, container, false);
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout_my_account);
        mViewPager = rootView.findViewById(R.id.viewpager_my_account_container);
        fragmentManager = getActivity().getSupportFragmentManager();

        tabLayout.addTab(tabLayout.newTab().setText(R.string.account_info));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.balance_info));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.account_settings));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //set adapter
        adapter = new MyAccountViewPagerAdapter(fragmentManager, getContext());
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.setOffscreenPageLimit(PAGE_LIMIT);


        return rootView;
    }

}
