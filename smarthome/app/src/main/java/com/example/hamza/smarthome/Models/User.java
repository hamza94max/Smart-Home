package com.example.hamza.smarthome.Models;

public class User {

    private String username;
    private String email;
    private String password;

    private int isSuccess;
    private String message;

    public User(String username, String email, String password, int isSuccess, String message) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isSuccess = isSuccess;
        this.message = message;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}





