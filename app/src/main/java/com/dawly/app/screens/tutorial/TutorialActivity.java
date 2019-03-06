package com.dawly.app.screens.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import app.dawly.com.dawly.R;
import com.dawly.app.screens.myaccount.activity.MyAccountActivity;

public class TutorialActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout indicator;
    Button btnNext;
    Button btnSkip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        getSupportActionBar().hide();


        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);
        btnNext = findViewById(R.id.btn_next_tutorial);
        btnSkip = findViewById(R.id.btn_skip_tutorial);


        viewPager.setAdapter(new SliderAdapter(this, Tutorial.getDawlyTutorials()));
        indicator.setupWithViewPager(viewPager, true);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() < 2)
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                else
                    startActivity(new Intent(TutorialActivity.this, MyAccountActivity.class));

            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorialActivity.this, MyAccountActivity.class));
            }
        });

    }

}
