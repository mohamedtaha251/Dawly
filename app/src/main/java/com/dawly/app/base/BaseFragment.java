package com.dawly.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;
import com.dawly.app.storage.DawlyStorage;
import com.dawly.app.utils.Constants;
import com.dawly.app.views.CustomProgressDialog;
import com.dawly.app.utils.LocaleManager;


public class BaseFragment extends Fragment {
    public static final String ARGS_INSTANCE = "LUCKY";

    public FragmentNavigation mFragmentNavigation;
    int mInt = 0;
    public CustomProgressDialog customProgressDialog;

    @SuppressWarnings("deprecation")
    public static final int getColor(Context context, int id) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return ContextCompat.getColor(context, id);
        } else {
            return context.getResources().getColor(id);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customProgressDialog = new CustomProgressDialog();
        Bundle args = getArguments();
        if (args != null) {
            mInt = args.getInt(ARGS_INSTANCE);
        }
        setHasOptionsMenu(true);

    }

    @Override
    public void onStart() {
        super.onStart();
        //handleLanguage(DawlyStorage.getLanguage());
    }

    public void handleLanguage(int languageId) {

        if (languageId == Constants.ARABIC) {
            DawlyStorage.setLanguage(Constants.ARABIC);
            LocaleManager.changeLang(getActivity(), Constants.ARABIC_KEY);
        } else if (languageId == Constants.ENGLISH) {
            DawlyStorage.setLanguage(Constants.ENGLISH);
            LocaleManager.changeLang(getActivity(), Constants.ENGLISH_KEY);
        }

    }

    public void goToNotLoggedInFragment(String source) {
        DawlyStorage.setSource(source);
        mFragmentNavigation.switchTab(0);

    }


    public void showProgressDialog() {
        if (!customProgressDialog.isShowing())
            customProgressDialog.showDialog(getActivity());
    }
    public void dismissProgressDialog() {
            customProgressDialog.dismissDialog();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentNavigation) {
            mFragmentNavigation = (FragmentNavigation) context;
        }
    }

    @SuppressWarnings("deprecation")
    public Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    public interface FragmentNavigation {
//        void pushFragment(Fragment fragment, FragNavTransactionOptions fragNavTransactionOptions);
//
//        void   pushFragment(Fragment fragment);
//
//        void popFragment(int numberOfFragment, FragNavTransactionOptions fragNavTransactionOptions);

//        void popFragment(int numberOfFragment);

        void switchTab(int index);

    }

}
