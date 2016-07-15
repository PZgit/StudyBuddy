package com.example.patrick.studienplaner.apiclient;

import retrofit.http.GET;

/**
 * Created by Julian on 15.07.2016.
 */
public interface GoogleApisService {

    public static final String BASE_URL = "https://www.googleapis.com";

    @GET("/oauth2/v1/userinfo?alt=json")
    Profile getProfile();
}