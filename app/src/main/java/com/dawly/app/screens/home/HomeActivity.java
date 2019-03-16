package com.dawly.app.screens.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import app.dawly.com.dawly.R;
import app.dawly.com.dawly.databinding.ActivityHomeBinding;
import app.dawly.com.dawly.databinding.AppBarBinding;
import com.dawly.app.screens.post.PostRequestFragment;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding activityMainBinding;
    public AppBarBinding appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        appBarLayout = activityMainBinding.appBar;
//        setSupportActionBar(appBarLayout.customToolbar);
        getSupportActionBar().hide();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PostRequestFragment()).commit();

    }

}
