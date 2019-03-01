package com.dawly.app.screens.tutorial;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import app.dawly.com.dawly.R;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout indicator;

    List<Integer> color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        getSupportActionBar().hide();


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicator = (TabLayout) findViewById(R.id.indicator);
        color = new ArrayList<>();
        color.add(Color.RED);
        color.add(Color.GREEN);
        color.add(Color.BLUE);

        viewPager.setAdapter(new SliderAdapter(this, color, Tutorial.getDawlyTutorials()));
        indicator.setupWithViewPager(viewPager, true);

    }

}
