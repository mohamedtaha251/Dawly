package com.dawly.app.screens.flights;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentAddFlightDoneBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.screens.post.PostRequestFragmentStep2;

public class AddFlightDoneFragment extends BaseFragment implements View.OnClickListener {
    private FragmentAddFlightDoneBinding fragmentAddFlightBinding;
    ImageView submitBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentAddFlightBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_flight_done, container, false);
        submitBtn = fragmentAddFlightBinding.closeBtn;
        submitBtn.setOnClickListener(this);
        return fragmentAddFlightBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PostRequestFragmentStep2()).commit();
                break;
        }
    }
}