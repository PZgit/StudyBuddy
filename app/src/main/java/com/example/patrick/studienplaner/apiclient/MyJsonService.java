package com.example.patrick.studienplaner.apiclient;

import com.example.patrick.studienplaner.model.data.Event;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Julian on 14.07.2016.
 */
public interface MyJsonService{


    @GET("/1kpjf")
    void listEvents(Callback<List<Event>> eventsCallback);

    @POST("/events")
    void postEvent(Event event);
}
