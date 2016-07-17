package com.example.patrick.studienplaner.apiclient;

import com.example.patrick.studienplaner.model.data.Event;

import java.util.List;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Julian on 14.07.2016.
 */
public interface MyJsonService {

    String API_BASE_URL = "https://localhost:1337";

    @GET("/users/{userId}/events")
    void listEvents(@Header("token") String jwt, @Path("userId") String userId, Callback<List<Event>> eventsCallback);

    @POST("/users")
    void postUser(@Header("token") String jwt);

    @POST("/users/{userId}/events")
    void postEvent(@Header("token") String jwt);

    @GET("/studygroups")
    void listStudyGroups(@Header("token") String jwt);

}
