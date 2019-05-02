package com.dawly.app.screens.myaccount.accountInfo;


import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountInfoFragment extends Fragment {

    private AccountInfoViewPagerAdapter adapter;
    private ViewPager mViewPager;
    private FragmentManager fragmentManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account_info, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout_account_info);
        mViewPager = rootView.findViewById(R.id.viewpager_account_info);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.orders_completed));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.shipments_carried));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //set adapter
        adapter = new AccountInfoViewPagerAdapter(fragmentManager, getContext());
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
            if(
                    event.getAction() == MotionEvent.ACTION_DOWN &&
                            v instanceof ViewGroup
                    ) {
                ((ViewGroup) v).requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    };

}
