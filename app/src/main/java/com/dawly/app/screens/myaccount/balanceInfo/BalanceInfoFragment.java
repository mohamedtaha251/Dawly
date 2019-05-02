package com.dawly.app.screens.myaccount.balanceInfo;


import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import com.dawly.app.screens.withdraw.withdraw.WithdrawFragment;
import com.dawly.app.views.DawlyButtonBold;


/**
 * A simple {@link Fragment} subclass.
 */
public class BalanceInfoFragment extends Fragment {

    private BalanceInfoViewPagerAdapter adapter;
    private ViewPager mViewPager;
    private FragmentManager fragmentManager;
    private DawlyButtonBold btnWithdraw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_balance_info, container, false);

        fragmentManager = getActivity().getSupportFragmentManager();
        TabLayout tabLayout = rootView.findViewById(R.id.tab_layout_balance_info);
        mViewPager = rootView.findViewById(R.id.viewpager_balance_info);
        btnWithdraw = rootView.findViewById(R.id.btn_withdraw_balalnce_info);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.payment_history));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.pending_orders));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //set adapter
        adapter = new BalanceInfoViewPagerAdapter(fragmentManager, getContext());
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(mViewPager);

        //disable outer pager on touch inner pager
        mViewPager.setOnTouchListener(mSuppressInterceptListener);

        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new fragment and transaction
                Fragment newFragment = new WithdrawFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_my_account, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView;
    }

    private View.OnTouchListener mSuppressInterceptListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (
                    event.getAction() == MotionEvent.ACTION_DOWN && v instanceof ViewGroup) {
                ((ViewGroup) v).requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    };

}
