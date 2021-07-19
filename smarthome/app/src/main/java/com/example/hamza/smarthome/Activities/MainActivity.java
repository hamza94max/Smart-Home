package com.example.hamza.smarthome.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamza.smarthome.Activities.Datasets.LedsDataset;
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

    ConstraintLayout constraintLayout;
    final String BASEURL = "http://192.168.4.1/";

    @Override
    protected void onPostResume() {
        super.onPostResume();
        checkInternet();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView temperturetextview = findViewById(R.id.tempertureDegree);



        constraintLayout = findViewById(R.id.allscreen);


        setfansID();
        setheatersID();
        setseekbars();
        setledsId();


        // TODO Bulider
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call <Post> call = apiInterface.gettemp();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                Toast.makeText(MainActivity.this, "connected", Toast.LENGTH_SHORT).show();
                if (response.body() != null) {
                    temperturetextview.setText(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
            }
        });



    }

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

        private void setfansID(){
            fan1 = findViewById(R.id.Fan1);
            fan2 = findViewById(R.id.Fan2);
            fan3 = findViewById(R.id.Fan3);
        }

        private void setheatersID(){
            heater1 = findViewById(R.id.Heater1);
            heater2 = findViewById(R.id.Heater2);
            heater3 = findViewById(R.id.Heater3);
        }

        private void setseekbars(){
            SeekbarFuncations.SeekbarUi(getApplicationContext(),fan1);
            SeekbarFuncations.SeekbarUi(getApplicationContext(),fan2);
            SeekbarFuncations.SeekbarUi(getApplicationContext(),fan3);
            SeekbarFuncations.SeekbarUi(getApplicationContext(),heater1);
            SeekbarFuncations.SeekbarUi(getApplicationContext(),heater2);
            SeekbarFuncations.SeekbarUi(getApplicationContext(),heater3);
        }

        private void setledsId(){
            led1 = findViewById(R.id.led1);
            led2 = findViewById(R.id.led2);
            led3 = findViewById(R.id.led3);
            led4 = findViewById(R.id.led4);
            led5 = findViewById(R.id.led5);
            led1out = findViewById(R.id.led1_out);
            led2out = findViewById(R.id.led2_out);
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