package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamza.smarthome.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        //check if user is logged in
        if (!SharedPref.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } */

        Switch led1=findViewById(R.id.led1);
        Switch led2=findViewById(R.id.led2);
        Switch led3=findViewById(R.id.led3);
        Switch led4=findViewById(R.id.led4);
        Switch led5=findViewById(R.id.led5);







        Switch auto =findViewById(R.id.auto);
        auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });





    }

}
