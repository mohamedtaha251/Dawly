package com.dawly.app.views;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;
import app.dawly.com.dawly.R;

public class CustomProgressDialog {
    private ProgressDialog progressDialog;

    public ProgressDialog showDialog(Context context) {
        progressDialog = ProgressDialog.show(context, "", context.getString(R.string.loading));
        progressDialog.setProgressStyle(R.style.DialogCustomTheme);
        progressDialog.setContentView(R.layout.activity_main);
        progressDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        ColorDrawable colorDrawable = new ColorDrawable(context.getResources().getColor(R.color.colorWhite));
        colorDrawable.setAlpha(100);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        return progressDialog;
    }

    public boolean isShowing() {
        if (progressDialog != null)
            return progressDialog.isShowing();
        else
            return false;
    }


    public void dismissDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing())
                progressDialog.dismiss();
        }
    }
}
