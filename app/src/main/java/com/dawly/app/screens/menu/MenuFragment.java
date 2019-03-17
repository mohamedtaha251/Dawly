package com.dawly.app.screens.menu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.FragmentSettingsBinding;
import com.dawly.app.base.BaseFragment;
import com.dawly.app.entities.Menu;
import com.dawly.app.screens.flights.AddFlightPaymentFragment;

import java.util.ArrayList;

public class MenuFragment extends BaseFragment implements View.OnClickListener {
    private FragmentSettingsBinding fragmentSettingsBinding;
    RecyclerView menuRecycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentSettingsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        menuRecycler = fragmentSettingsBinding.menuRecycler;

        return fragmentSettingsBinding.getRoot();
    }


    @Override
    public void onStart() {
        super.onStart();
        ArrayList<Menu> menuArrayList = new ArrayList<>();
        Menu menu = new Menu();
        menu.setItemName(getString(R.string.my_account));
        menu.setImageResourceID(R.drawable.ic_account);



        Menu menu1 = new Menu();
        menu1.setItemName(getString(R.string.terms));
        menu1.setImageResourceID(R.drawable.ic_myflights);

        Menu menu2 = new Menu();
        menu2.setItemName(getString(R.string.safety));
        menu2.setImageResourceID(R.drawable.ic_shield);

        Menu menu3 = new Menu();
        menu3.setItemName(getString(R.string.help_center));
        menu3.setImageResourceID(R.drawable.ic_help_center);

        Menu menu4 = new Menu();
        menu4.setItemName(getString(R.string.action_settings));
        menu4.setImageResourceID(R.drawable.ic_settings);
        Menu menu5 = new Menu();
        menu5.setItemName(getString(R.string.policy));
        menu5.setImageResourceID(R.drawable.ic_terms);

        menuArrayList.add(menu);
        menuArrayList.add(menu1);
        menuArrayList.add(menu2);
        menuArrayList.add(menu3);
        menuArrayList.add(menu4);
        menuArrayList.add(menu5);

        MenuAdapter menuAdapter = new MenuAdapter();
        menuAdapter.setItems(menuArrayList);
        menuRecycler.setHasFixedSize(true);
        menuRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        menuRecycler.setAdapter(menuAdapter);


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