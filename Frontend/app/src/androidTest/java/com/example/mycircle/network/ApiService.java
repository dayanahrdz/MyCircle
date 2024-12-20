package com.example.mycircle.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


import com.example.mycircle.models.Group; // Example model class for group
import com.example.mycircle.models.UserRequestBody; // Example model class for request body

public interface ApiService {

    // Example of a GET request to fetch some data
    @GET("api/groups") // Adjust the endpoint as needed
    Call<List<Group>> getGroups(); // Replace with the appropriate model for your groups data

    // Example of a POST request to send data
    @POST("api/users") // Adjust the endpoint as needed
    Call<Void> createUser(@Body UserRequestBody body); // Replace with your actual request body model
}
