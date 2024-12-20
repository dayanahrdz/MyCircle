package com.example.mycircle.models;

import java.util.List;

public class Group {
    private String id;
    private String name;
    private List<String> members;
    private String createdAt;

    // Constructor for compatibility with GroupsFragment
    public Group(String name) {
        this.name = name;
    }

    // Full constructor if needed
    public Group(String id, String name, List<String> members, String createdAt) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
