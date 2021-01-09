package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.example.hamza.smarthome.Fragments.HomeFragment;
import com.example.hamza.smarthome.Fragments.HumidFragment;
import com.example.hamza.smarthome.Fragments.MoveFragment;
import com.example.hamza.smarthome.Fragments.TempFragment;
import com.example.hamza.smarthome.R;
import com.example.hamza.smarthome.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    String home ="Home";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        home=home.toLowerCase();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        getTabs();


    }

    public void getTabs(){
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPagerAdapter.addFragment(HomeFragment.newInstance(),home.toLowerCase());
                viewPagerAdapter.addFragment(TempFragment.newInstance(),"Temp");
                viewPagerAdapter.addFragment(MoveFragment.newInstance(),"Movement");
                viewPagerAdapter.addFragment(HumidFragment.newInstance(),"Humidity");



                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }
}
