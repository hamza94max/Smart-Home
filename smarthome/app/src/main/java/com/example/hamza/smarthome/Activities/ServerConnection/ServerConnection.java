package com.example.hamza.smarthome.Activities.ServerConnection;

import com.example.hamza.smarthome.Activities.Interface.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerConnection {

    public static void connectToserver(String baseurl) {

        final String BASEURL = "http://" + baseurl;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
    }

}
