package com.example.mycircle.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    // Example of a GET request to fetch some data
    @GET("api/groups") // Change to your desired backend endpoint
    Call<List<YourModel>> getGroups(); // Replace YourModel with the corresponding data model class

    // Example of a POST request to send data
    @POST("api/users") // Change to your desired backend endpoint
    Call<ResponseBody> createUser(@Body YourRequestBody body); // Replace YourRequestBody with the request data class
}
