package com.example.hamza.smarthome.Activities.Interface;

import com.example.hamza.smarthome.Activities.ResponseModels.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("55")
    Call<ResponseModel> getTemperture();

    @GET("66")
    Call<ResponseModel> getHumadity();

    // TODO Leds
    @PUT("{id}")
    Call<ResponseModel> UpdateLedState(@Path("id") int id, @Body ResponseModel body);

}
