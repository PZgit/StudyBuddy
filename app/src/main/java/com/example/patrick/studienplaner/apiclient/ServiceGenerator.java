package com.example.patrick.studienplaner.apiclient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Julian on 12.07.2016.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "https://localhost:1337";

    public static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL)
            .setClient(new OkClient(SelfSigningClientBuilder.createClient()));

    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl){
        builder.setEndpoint(baseUrl);
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }


}
