package com.dawly.app.screens.post;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentPostRequestDoneBinding;
import com.dawly.app.base.BaseFragment;

public class FlightProcessedFragment extends BaseFragment {
FragmentPostRequestDoneBinding postRequestDoneBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        postRequestDoneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_request_done, container, false);
        return  postRequestDoneBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
