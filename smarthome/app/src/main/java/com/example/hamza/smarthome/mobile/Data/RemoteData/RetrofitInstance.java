package com.example.hamza.smarthome.mobile.Data.RemoteData;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static void connectToserver(String baseurl) {

        final String BASEURL = "http://" + baseurl;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
    }

}
