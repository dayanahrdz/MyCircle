package com.example.mycircle.models;

public class Event {
    private final String title;
    private final String time;

    public Event(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }
}
