package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hamza.smarthome.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Gosignup(View view) {
        Intent intent = new Intent(getApplicationContext(),Register.class);
        startActivity(intent);
        finish();
    }

    public void goback(View view) {
        Gosignup(view);
    }

    public void forgetpassword(View view) {
    }

    public void login(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}