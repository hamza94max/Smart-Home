package com.example.hamza.smarthome.Activities;


// TODO this class to receive data from server and put the values in these variables
public class Post {

    int request ;

    public Post(int request) {
        this.request = request;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }
}

