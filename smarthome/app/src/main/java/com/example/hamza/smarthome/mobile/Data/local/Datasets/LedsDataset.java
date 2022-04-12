package com.example.hamza.smarthome.mobile.Data.local.Datasets;

public class LedsDataset {

    static int [] LedIn = {0,1,2,3,4,5,6,7,8,9,10};
    static int [] LedOut = {11,12,13,14};


    static int led1On = LedIn[1];
    static int led2On = LedIn[3];
    static int led3On = LedIn[5];
    static int led4On = LedIn[7];
    static int led5On = LedIn[9];

    static int Led1outOn = LedOut[0];
    static int Led2outOn = LedOut[2];


    static int led1Off = LedIn[2];
    static int led2Off = LedIn[4];
    static int led3Off = LedIn[6];
    static int led4Off = LedIn[8];
    static int led5Off = LedIn[10];

    static int Led1outoff = LedOut[1];
    static int Led2outoff = LedOut[3];



    public static int getLed1On(){
        return led1On;
    }
    public static int getLed2On(){
        return led2On;
    }
    public static int getLed3On(){
        return led3On;
    }
    public static int getLed4On(){
        return led4On;
    }
    public static int getLed5On(){
        return led5On;
    }

    public static int getLed1OutOn(){
        return Led1outOn;
    }
    public static int getLed2OutOn(){
        return Led2outOn;
    }


    public static int getLed1Off() {return led1Off;}
    public static int getLed2Off() {return led2Off;}
    public static int getLed3Off() {return led3Off;}
    public static int getLed4Off() {return led4Off;}
    public static int getLed5Off() {return led5Off;}

    public static int getLed1OutOff() {return Led1outoff;}
    public static int getLed2OutOff() {return Led2outoff;}

}




