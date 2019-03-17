package com.dawly.app.screens.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.ActivityHomeBinding;
import com.dawly.app.base.BaseContract;
import com.dawly.app.screens.flights.AddFlightFragment;
import com.dawly.app.screens.flights.FlightsFragment;
import com.dawly.app.screens.menu.MenuFragment;
import com.dawly.app.screens.orders.FlightOrdersFragment;
import com.dawly.app.screens.post.PostRequestFragment;
import com.dawly.app.views.BottomNavigation;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, BaseContract.AddClickListener {

    ActivityHomeBinding activityHomeBinding;
    //    public AppBarBinding appBarLayout;
    Toolbar toolbar;
    BottomNavigation bottomNavigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        bottomNavigation = findViewById(R.id.navigation);
//        getSupportActionBar().hide();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlightOrdersFragment()).commit();
        bottomNavigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_orders:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlightOrdersFragment()).commit();
                bottomNavigation.setSelected(0);
                break;
            case R.id.navigation_flights:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlightsFragment()).commit();
                bottomNavigation.setSelected(1);
                break;
            case R.id.navigation_add_orders:
                bottomNavigation.setSelected(2);
                AddFlightDialog addFlightDialog = new AddFlightDialog();
                addFlightDialog.setAddClickListener(this);
                addFlightDialog.show(getSupportFragmentManager(), "");

                break;
            case R.id.navigation_messages:
                bottomNavigation.setSelected(3);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlightOrdersFragment()).commit();

                break;
            case R.id.navigation_menu:
                bottomNavigation.setSelected(4);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MenuFragment()).commit();

                break;


        }
        return false;
    }

    @Override
    public void onAddFlightClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AddFlightFragment()).commit();
    }

    @Override
    public void onAddOrderClick(View view) {

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PostRequestFragment()).commit();
    }
}
