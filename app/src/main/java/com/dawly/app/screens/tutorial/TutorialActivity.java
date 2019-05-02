package com.dawly.app.screens.tutorial;

import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import app.dawly.com.dawly.R;
import com.dawly.app.screens.auth.social.SocialLoginActivity;
import com.dawly.app.views.DawlyButton;
import com.rd.PageIndicatorView;

public class TutorialActivity extends AppCompatActivity {
    ViewPager viewPager;
    PageIndicatorView indicator;
    DawlyButton btnNext;
    DawlyButton btnSkip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
//        getSupportActionBar().hide();


        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);
        btnNext = findViewById(R.id.btn_next_tutorial);
        btnSkip = findViewById(R.id.btn_skip_tutorial);


        viewPager.setAdapter(new SliderAdapter(this, Tutorial.getDawlyTutorials()));
        indicator.setViewPager(viewPager);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() < 2)
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                else
                    startActivity(new Intent(TutorialActivity.this, SocialLoginActivity.class));

            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TutorialActivity.this, SocialLoginActivity.class));
            }
        });

    }

}
