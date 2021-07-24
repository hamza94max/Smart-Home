package com.example.hamza.smarthome.Activities.ResponseModels;


// TODO this class to receive data from server and put the values in these variables
public class RequestModel {

    double request ;

    public RequestModel(int request) {
        this.request = request;
    }

    public double getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }
}

