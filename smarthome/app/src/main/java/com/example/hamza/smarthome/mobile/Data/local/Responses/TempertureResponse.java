package com.example.hamza.smarthome.mobile.Data.local.Responses;

import android.widget.TextView;

import com.example.hamza.smarthome.mobile.Data.RemoteData.ApiInterface;
import com.example.hamza.smarthome.mobile.Data.local.Model.ResponseModel;

import retrofit2.Call;

public class TempertureResponse {

    public static void getTempertureResponse(ApiInterface apiInterface, TextView temperturetextview){

        Call<ResponseModel> callforTemperture = apiInterface.getTemperture();
        RequestForResponse.request(callforTemperture, temperturetextview);
    }

}
