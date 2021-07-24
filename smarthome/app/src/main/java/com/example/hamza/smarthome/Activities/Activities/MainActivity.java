package com.example.hamza.smarthome.Activities.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hamza.smarthome.Activities.Interface.ApiInterface;
import com.example.hamza.smarthome.Activities.ResponseModels.RequestModel;
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

    EditText IPAddressEdittext;
    String BASEURL;

    TextView temperturetextview,humaditytextview;

    Retrofit retrofit;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog();

        temperturetextview = findViewById(R.id.tempertureDegree);
        humaditytextview = findViewById(R.id.HumadityPercent);


        setfansID();
        setheatersID();
        setseekbars();
        setledsId();






    }

        private void showDialog(){

             AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

            View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);

             IPAddressEdittext = mView.findViewById(R.id.IPAddressEdittext);
            Button cancelbtn = mView.findViewById(R.id.btn_cancel);
            Button connectbtn = mView.findViewById(R.id.btn_connect);

            alert.setView(mView);
             AlertDialog alertDialog = alert.create();
            alertDialog.setCanceledOnTouchOutside(false);

            cancelbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BASEURL = "";
                    alertDialog.dismiss();
                }
            });

            connectbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   BASEURL = IPAddressEdittext.getText().toString();
                    final String BASEurL = "http://" + BASEURL;
                    connectToserver(BASEurL);
                   alertDialog.dismiss();
                }
            });
            alertDialog.show();

        }

        private void connectToserver(String baseurl){
            // TODO Bulider
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInterface = retrofit.create(ApiInterface.class);

          // TODO : Requests for textviews
           callfor();

        }

        private void callfor(){

            Call <RequestModel> callforHumadity = apiInterface.getHumadity();
            request(callforHumadity,humaditytextview);

            Call <RequestModel> callforTemperture = apiInterface.gettemperture();
            request(callforTemperture,temperturetextview);
        }

        private void request(Call call, TextView textView){

            call.enqueue(new Callback<RequestModel>() {
                @Override
                public void onResponse(Call<RequestModel> call, Response <RequestModel> response) {

                    Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                    if (response.body() != null) {
                        textView.setText(response.body().toString());
                    }
                }

                @Override
                public void onFailure(Call<RequestModel> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Not Connected to server", Toast.LENGTH_LONG).show();
                }
            });
        }










        @SuppressLint("UseSwitchCompatOrMaterialCode")
        private void openled(Switch numofled){
            numofled.setChecked(true);
        }

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        private void closeled(Switch numofled){
        numofled.setChecked(false);
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



}