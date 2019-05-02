package com.dawly.app.screens.withdraw.withdrawOption;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import com.dawly.app.screens.withdraw.withdrawBank.WithdrawBankFragment;
import com.dawly.app.screens.withdraw.withdrawPaypal.WithdrawPaypal;


public class WithdrawOptionFragment extends Fragment {

    CardView bankCard;
    CardView paypalCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_withdraw_option, container, false);

        bankCard = rootView.findViewById(R.id.card_witdraw_bank_option);
        paypalCard = rootView.findViewById(R.id.card_witdraw_paypal_option);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new WithdrawBankFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_withdraw, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        paypalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new WithdrawPaypal();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_withdraw, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
