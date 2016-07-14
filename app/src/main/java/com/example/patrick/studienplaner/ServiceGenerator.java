package com.example.patrick.studienplaner;

import com.example.patrick.studienplaner.model.SelfSigningClientBuilder;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Julian on 12.07.2016.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "https://87.106.149.172:1337";

    public ServiceGenerator() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_BASE_URL)
                .setClient(new OkClient(SelfSigningClientBuilder.createClient()))
                .build();
    }
}
