package com.example.hamza.smarthome.Activities.Responses;

import android.widget.TextView;

import com.example.hamza.smarthome.Activities.Interface.ApiInterface;
import com.example.hamza.smarthome.Activities.ResponseModels.ResponseModel;

import retrofit2.Call;

public class TempertureResponse {

    public static void getTempertureResponse(ApiInterface apiInterface, TextView temperturetextview){

        Call<ResponseModel> callforTemperture = apiInterface.getTemperture();
        RequestForResponse.request(callforTemperture, temperturetextview);
    }

}
