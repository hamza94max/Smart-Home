package com.example.hamza.smarthome.Activities.ResponseModels;


// TODO this class to receive data from server and put the values in these variables
public class ResponseModel {

    int request ;

    public ResponseModel(int request) {
        this.request = request;
    }

    public double getRequest() {
        return request;
    }

}

