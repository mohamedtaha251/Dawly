package com.dawly.app.screens.myaccount.balanceInfo;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BalanceInfoFragment extends Fragment {

    private BalanceInfoViewPagerAdapter adapter;
    private ViewPager mViewPager;
    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_balance_info, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout_balance_info);
        mViewPager = rootView.findViewById(R.id.viewpager_balance_info);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.orders_completed));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.shipments_carried));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //set adapter
        adapter = new BalanceInfoViewPagerAdapter(fragmentManager, getContext());
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(mViewPager);

        //disable outer pager on touch inner pager
        mViewPager.setOnTouchListener(mSuppressInterceptListener);


        return rootView;
    }

    private View.OnTouchListener mSuppressInterceptListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (
                    event.getAction() == MotionEvent.ACTION_DOWN &&
                            v instanceof ViewGroup
                    ) {
                ((ViewGroup) v).requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    };

}
