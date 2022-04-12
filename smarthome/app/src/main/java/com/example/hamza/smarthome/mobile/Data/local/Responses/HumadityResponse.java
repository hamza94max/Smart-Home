package com.example.hamza.smarthome.mobile.Data.local.Responses;

import android.widget.TextView;

import com.example.hamza.smarthome.mobile.Data.RemoteData.ApiInterface;
import com.example.hamza.smarthome.mobile.Data.local.Model.ResponseModel;

import retrofit2.Call;

public class HumadityResponse {

    public static void getHumadityResponse(ApiInterface apiInterface, TextView Humaditytextview){

        Call<ResponseModel> callforHumadity = apiInterface.getHumadity();
        RequestForResponse.request(callforHumadity, Humaditytextview);
    }


}
