package com.example.mycircle;

import com.google.android.gms.maps.model.LatLng;

public class FamilyMember {
    private String name;
    private String status;
    private String lastSeen;
    private String travelTime;
    private LatLng location;

    public FamilyMember(String name, String status, String lastSeen, String travelTime, LatLng location) {
        this.name = name;
        this.status = status;
        this.lastSeen = lastSeen;
        this.travelTime = travelTime;
        this.location = location;
    }

    public String getName() { return name; }
    public String getStatus() { return status; }
    public String getLastSeen() { return lastSeen; }
    public String getTravelTime() { return travelTime; }
    public LatLng getLocation() { return location; }
}

