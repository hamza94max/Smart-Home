package com.example.hamza.smarthome.Activities.Responses;

import android.widget.TextView;

import com.example.hamza.smarthome.Activities.Interface.ApiInterface;
import com.example.hamza.smarthome.Activities.ResponseModels.ResponseModel;

import retrofit2.Call;

public class HumadityResponse {

    public static void getHumadityResponse(ApiInterface apiInterface, TextView Humaditytextview){

        Call<ResponseModel> callforHumadity = apiInterface.getHumadity();
        RequestForResponse.request(callforHumadity, Humaditytextview);
    }


}
