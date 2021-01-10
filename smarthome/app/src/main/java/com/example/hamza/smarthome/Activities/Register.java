package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hamza.smarthome.ApiClient;
import com.example.hamza.smarthome.Interface.UserClient;
import com.example.hamza.smarthome.Models.User;
import com.example.hamza.smarthome.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText username,email,password;
    Button signup;
    Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username =findViewById(R.id.name);
        email =findViewById(R.id.email);
        password =findViewById(R.id.passward);
        signup=findViewById(R.id.signup);



    }
    public void Regbtn(View view) {

        validateUserData();

    }
    public void loginbtn(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();
    }


    // To check if username,email,pass not empty
    private void validateUserData() {

        //find values
        final String reg_name = username.getText().toString();
        final String reg_email = email.getText().toString();
        final String reg_password = password.getText().toString();
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


//        checking if username is empty
        if (TextUtils.isEmpty(reg_name)) {
            username.setError("Please enter username");
            username.requestFocus();
            // Vibrate for 100 milliseconds
            v.vibrate(100);
            return;
        }
        //checking if email is empty
        if (TextUtils.isEmpty(reg_email)) {
            email.setError("Please enter email");
            email.requestFocus();
            // Vibrate for 100 milliseconds
            v.vibrate(100);
            return;
        }
        //checking if password is empty
        if (TextUtils.isEmpty(reg_password)) {
            password.setError("Please enter password");
            password.requestFocus();
            //Vibrate for 100 milliseconds
            v.vibrate(100);
            return;
        }
        //validating email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(reg_email).matches()) {
            email.setError("Enter a valid email");
            email.requestFocus();
            //Vibrate for 100 milliseconds
            v.vibrate(100);
            return;
        }
        //After Validating we register User
        registerUser(reg_name,reg_email,reg_password);

    }
    private void registerUser(String user_name, String user_mail, String user_pass) {


        final String reg_username = username.getText().toString();
        final String reg_email = email.getText().toString();
        final String reg_password = password.getText().toString();

        //call retrofit
        //making api call
        UserClient api = ApiClient.getClient().create(UserClient.class);
        Call<User> login = api.register(user_name,user_mail,user_pass);

        login.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.body().getIsSuccess() == 1){
                    //get username
                    String user = response.body().getUsername();

                    startActivity(new Intent(Register.this,MainActivity.class));
                }else{
                    Toast.makeText(Register.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Register.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });





}


}