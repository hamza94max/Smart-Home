package com.example.hamza.smarthome.mobile.Data.local.Responses;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hamza.smarthome.mobile.Data.local.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestForResponse {

    static void request(Call<ResponseModel> call, TextView textView){

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, @NonNull Response<ResponseModel> response) {

               Log.i("Tag", "there is a response ");
                if (response.body() != null) {
                    textView.setText(response.body().toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel> call, @NonNull Throwable t) {
                Log.i("Tag","no response ");
            }
        });
    }

}
