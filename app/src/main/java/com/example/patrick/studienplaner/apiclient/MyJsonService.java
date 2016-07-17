package com.example.patrick.studienplaner.apiclient;

import com.example.patrick.studienplaner.model.data.Event;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Julian on 14.07.2016.
 */
public interface MyJsonService {

    String API_BASE_URL = "https://87.106.149.172:1337";

    @GET("/users/{userId}/events")
    void listEvents(@Path("userId") String userId, Callback<List<Event>> eventsCallback);

    @POST("/users")
    void postUser(String jwt);

}
