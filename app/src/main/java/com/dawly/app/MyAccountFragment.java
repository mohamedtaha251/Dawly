package com.dawly.app;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;

public class MyAccountFragment extends Fragment {

    private MyAccountViewPagerAdapter adapter;
    private ViewPager mViewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_account, container, false);
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout_my_account);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.account_info));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.balance_info));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.account_settings));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //set adapter
        adapter = new MyAccountViewPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager = rootView.findViewById(R.id.viewpager_my_account_container);
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return rootView;
    }

}
