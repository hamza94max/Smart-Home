package com.example.hamza.smarthome.Activities.Interface;

import com.example.hamza.smarthome.Activities.ResponseModels.RequestModel;
import com.example.hamza.smarthome.Activities.ResponseModels.UpdateModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    int id = 56;


    @GET ("55")
     Call <RequestModel> gettemperture();

    @GET ("66")
    Call <RequestModel> getHumadity();


    // led 1 on
    @PUT ("{id}")
    Call <UpdateModel> makeLed1On(@Path("id") int id , @Body UpdateModel updateModel);

















}
