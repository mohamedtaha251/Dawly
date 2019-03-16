package com.dawly.app.screens.post;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentPostRequest2Binding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.views.DawlyButtonBold;

public class PostRequestFragmentStep2 extends BaseFragment implements View.OnClickListener {

    private FragmentPostRequest2Binding fragmentPostRequestBinding;

    DawlyButtonBold continueBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPostRequestBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_request2, container, false);
        continueBtn = fragmentPostRequestBinding.continueBtn;
        continueBtn.setOnClickListener(this);
        return fragmentPostRequestBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.continueBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PostRequestFragmentStep3()).commit();
                break;
        }
    }
}