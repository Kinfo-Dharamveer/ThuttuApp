package com.kinfo.thuttu.events;

public class Events {

    private  String message;



    public Events(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static class TapEvent {

    }

    public static class AutoEvent {

    }

}
