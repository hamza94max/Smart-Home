package com.example.hamza.smarthome.Activities.InterFace;

import com.example.hamza.smarthome.Activities.Post;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET ("posts/1")
    public Call<Post> getpost();









}
