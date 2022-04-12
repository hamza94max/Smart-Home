package com.example.hamza.smarthome.mobile.ui.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hamza.smarthome.R;
import com.example.hamza.smarthome.databinding.ActivityMainBinding;
import com.example.hamza.smarthome.mobile.Data.RemoteData.ApiInterface;
import com.example.hamza.smarthome.mobile.Data.RemoteData.RetrofitInstance;
import com.example.hamza.smarthome.mobile.Data.local.Model.ResponseModel;
import com.example.hamza.smarthome.mobile.Data.local.Responses.HumadityResponse;
import com.example.hamza.smarthome.mobile.Data.local.Responses.TempertureResponse;
import com.example.hamza.smarthome.mobile.ui.Seekbar.SeekbarFuncations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText IPAddressEdittext;
    String BASEURL;

    ApiInterface apiInterface;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.temperature);

        showDialog();
        setseekbars();

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

            cancelbtn.setOnClickListener(v -> {
                alertDialog.dismiss();
                Toast.makeText(MainActivity.this, "Not Connected !!", Toast.LENGTH_SHORT).show();
            });

            connectbtn.setOnClickListener(v -> {
                connectToserver();
               alertDialog.dismiss();
            });
            alertDialog.show();
    }

        private void connectToserver(){
            BASEURL = IPAddressEdittext.getText().toString();
            RetrofitInstance.connectToserver(BASEURL);
            callforResponses();
        }

        private void callforResponses() {
            HumadityResponse.getHumadityResponse(apiInterface, binding.temperturelayout.humdityLayout.tempertureDegreeTextview);
            TempertureResponse.getTempertureResponse(apiInterface, binding.temperturelayout.humdityLayout.HumadityPercentTextview);
        }

        private void setseekbars() {
            SeekbarFuncations.SeekbarUi(getApplicationContext(), binding.temperturelayout.Fan1);
            SeekbarFuncations.SeekbarUi(getApplicationContext(), binding.temperturelayout.Fan2);
            SeekbarFuncations.SeekbarUi(getApplicationContext(), binding.temperturelayout.Fan3);
            SeekbarFuncations.SeekbarUi(getApplicationContext(), binding.temperturelayout.Heater1);
            SeekbarFuncations.SeekbarUi(getApplicationContext(), binding.temperturelayout.Heater2);
            SeekbarFuncations.SeekbarUi(getApplicationContext(), binding.temperturelayout.Heater3);
        }

    private void checkLed1() {

        if (binding.controlLayout.led1.isChecked()) {
            ResponseModel responseModel = new ResponseModel(1);
            Call<ResponseModel> call = apiInterface.UpdateLedState(1, responseModel);

            call.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    openled(binding.controlLayout.led1);
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
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