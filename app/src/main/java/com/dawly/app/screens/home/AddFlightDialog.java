package com.dawly.app.screens.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import com.dawly.app.base.BaseContract;
import com.dawly.app.base.BaseDialog;
import com.dawly.app.views.DawlyButtonMontserratBold;

public class AddFlightDialog extends BaseDialog implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialogStyle);
    }

    private BaseContract.AddClickListener addClickListener;

    public void setAddClickListener(BaseContract.AddClickListener addClickListener) {
        this.addClickListener = addClickListener;
    }

    DawlyButtonMontserratBold addFlight, addOrder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_flight, container, false);
        addFlight = view.findViewById(R.id.addFlight);
        addOrder = view.findViewById(R.id.addOrder);
        addFlight.setOnClickListener(this);
        addOrder.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addFlight:
                dismiss();
                addClickListener.onAddFlightClick(view);
                break;
            case R.id.addOrder:
                dismiss();
                addClickListener.onAddOrderClick(view);
                break;

        }
    }
}
