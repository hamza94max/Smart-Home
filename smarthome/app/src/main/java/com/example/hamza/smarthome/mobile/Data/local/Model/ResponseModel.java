package com.example.hamza.smarthome.mobile.Data.local.Model;


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

