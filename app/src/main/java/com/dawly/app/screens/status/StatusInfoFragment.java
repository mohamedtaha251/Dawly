package com.dawly.app.screens.status;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentStatusInfoBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.views.DawlyButtonBold;
import com.dawly.app.views.DawlyTextViewBold;

public class StatusInfoFragment extends BaseFragment implements View.OnClickListener {
    private FragmentStatusInfoBinding fragmentStatusInfoBinding;
    DawlyButtonBold waitingBtn;
    ImageView statusCircle;
    DawlyTextViewBold status;
    ImageView statusReceivedImg;
    ImageView boxImg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        fragmentStatusInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_status_info, container, false);
waitingBtn = fragmentStatusInfoBinding.waitingBtn;

        statusCircle= fragmentStatusInfoBinding.statusCircle;
        status = fragmentStatusInfoBinding.itemStatus;
        statusReceivedImg = fragmentStatusInfoBinding.statusReceivedImg;
//        boxImg = fragmentStatusInfoBinding.headerCard.boxImg;
        waitingBtn.setOnClickListener(this);
        return fragmentStatusInfoBinding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.waitingBtn:
                statusCircle.setBackground(getActivity().getDrawable(R.drawable.delivered_circle_bg));
                status.setText(getString(R.string.delivered));
                waitingBtn.setText(getString(R.string.add_tracking));
                statusReceivedImg.setImageDrawable(getActivity().getDrawable(R.drawable.ic_rectangle_status_end));
                statusReceivedImg.setColorFilter(getColor(getActivity(),R.color.colorDelivered));
//                boxImg.setBackground(getActivity().getDrawable(R.drawable.ic_suitcase));
                break;


        }

    }
}

