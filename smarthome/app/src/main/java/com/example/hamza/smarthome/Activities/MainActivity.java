package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import com.example.hamza.smarthome.Activities.Datasets.Dataset;
import com.example.hamza.smarthome.Activities.InterFace.ApiInterface;
import com.example.hamza.smarthome.Activities.Seekbar.SeekbarFuncations;
import com.example.hamza.smarthome.R;
import com.xw.repo.BubbleSeekBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    BubbleSeekBar fan1,fan2,fan3,heater1,heater2,heater3;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch led1,led2,led3,led4,led5,led1out,led2out;

    int request = 1;
    ConstraintLayout constraintLayout;


    @Override
    protected void onPostResume() {
        super.onPostResume();
        //checkInternet();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Bulider
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://623da264-f3d2-4b98-9180-2bb4595781f8.mock.pstmn.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Call<Post> call = apiInterface.getpost();

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.body().getRequest() == Dataset.getLed1On()) {
                    openled(led1);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });









        constraintLayout = findViewById(R.id.allscreen);

        fan1 = findViewById(R.id.Fan1);
        fan2 = findViewById(R.id.Fan2);
        fan3 = findViewById(R.id.Fan3);

        heater1 = findViewById(R.id.Heater1);
        heater2 = findViewById(R.id.Heater2);
        heater3 = findViewById(R.id.Heater3);

        setseekbars();


        led1 = findViewById(R.id.led1);
        led2 = findViewById(R.id.led2);
        led3 = findViewById(R.id.led3);
        led4 = findViewById(R.id.led4);
        led5 = findViewById(R.id.led5);
        led1out = findViewById(R.id.led1_out);
        led2out = findViewById(R.id.led2_out);



    }

        /*
    private void checkInternet() {
        if (internetIsConnected()){
            constraintLayout.setVisibility(View.VISIBLE);
        } else{
            constraintLayout.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "افتح النت يا صحبي ^_^", Toast.LENGTH_LONG).show();
        }
    }

    public boolean internetIsConnected() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec(command).waitFor() == 0);
        } catch (Exception e) {
            return false;
        }
    }
    */

    private void setseekbars(){
        SeekbarFuncations.SeekbarUi(getApplicationContext(),fan1);
        SeekbarFuncations.SeekbarUi(getApplicationContext(),fan2);
        SeekbarFuncations.SeekbarUi(getApplicationContext(),fan3);
        SeekbarFuncations.SeekbarUi(getApplicationContext(),heater1);
        SeekbarFuncations.SeekbarUi(getApplicationContext(),heater2);
        SeekbarFuncations.SeekbarUi(getApplicationContext(),heater3);
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private void openled(Switch numofled){
        numofled.setChecked(true);
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private void closeled(Switch numofled){
        numofled.setChecked(false);
    }
























}
