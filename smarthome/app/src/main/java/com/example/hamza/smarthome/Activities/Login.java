package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.hamza.smarthome.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText username_login,password_login;
    Button login ;
    Vibrator v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         username_login =findViewById(R.id.name_login);
         password_login =findViewById(R.id.passlogin);
         login=findViewById(R.id.loginbtn);
         v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);




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
       //validateUserData();
    }


/*
    private void validateUserData() {

        //first getting the values
        final String username = username_login.getText().toString();
        final String password = password_login.getText().toString();

        //checking if username is empty
        if (TextUtils.isEmpty(username)) {
            username_login.setError("Please enter your username");
            username_login.requestFocus();
            // Vibrate for 100 milliseconds
            v.vibrate(100);
            login.setEnabled(true);
            return;
        }
        //checking if password is empty
        if (TextUtils.isEmpty(password)) {
            password_login.setError("Please enter your password");
            password_login.requestFocus();
            //Vibrate for 100 milliseconds
            v.vibrate(100);
            login.setEnabled(true);
            return;
        }
        //Login User if everything is fine
        loginUser(username,password);


    }

    private void loginUser(String username, String password) {

        //making api call
        UserClient api = ApiClient.getClient().create(UserClient.class);
        Call<User> login = api.login(username,password);

        login.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.body().getIsSuccess() == 1){
                    //get username
                    String user = response.body().getUsername();

                    //storing the user in shared preferences
                    SharedPref.getInstance(Login.this).storeUserName(user);
                    //Toast.makeText(getApplicationContext(),response.body().getUsername(),Toast.LENGTH_LONG).show();

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }*/

}



