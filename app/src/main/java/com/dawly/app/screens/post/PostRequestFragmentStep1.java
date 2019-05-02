package com.dawly.app.screens.post;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentPostRequest1Binding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.views.DawlyButtonMontserratBold;

public class PostRequestFragmentStep1  extends BaseFragment implements View.OnClickListener {
    private FragmentPostRequest1Binding fragmentPostRequest1Binding;
DawlyButtonMontserratBold continueBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


          fragmentPostRequest1Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_request1, container, false);

        continueBtn = fragmentPostRequest1Binding.continueBtn;
        continueBtn.setOnClickListener(this);
        return fragmentPostRequest1Binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.continueBtn:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PostRequestFragmentStep2()).commit();
                break;


        }

    }
}

