package com.example.mycircle.models;

public class DaySlot {
    private final String time;
    private final String description;

    public DaySlot(String time, String description) {
        this.time = time;
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
}
