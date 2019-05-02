package com.dawly.app.screens.menu;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentSettingsBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.screens.flights.AddFlightPaymentFragment;

public class SettingsFragment extends BaseFragment implements View.OnClickListener {
    private FragmentSettingsBinding fragmentSettingsBinding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentSettingsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);

        return fragmentSettingsBinding.getRoot();
    }


    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddFlightPaymentFragment()).commit();
                break;
        }
    }
}