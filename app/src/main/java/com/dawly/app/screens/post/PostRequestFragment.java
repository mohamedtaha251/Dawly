package com.dawly.app.screens.post;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentPostRequestBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.views.DawlyButtonBold;

public class PostRequestFragment extends BaseFragment implements View.OnClickListener {


    private FragmentPostRequestBinding fragmentPostRequestBinding;

    DawlyButtonBold nextBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPostRequestBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_request, container, false);
//        flightsRecycler = fragmentFlightsBinding.flightsRecycler;
        nextBtn = fragmentPostRequestBinding.nextBtn;
        nextBtn.setOnClickListener(this);
        return fragmentPostRequestBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nextBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PostRequestFragmentStep1()).commit();
                break;
        }
    }
}
