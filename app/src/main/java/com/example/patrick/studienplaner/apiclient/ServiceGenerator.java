package com.example.patrick.studienplaner.apiclient;

import retrofit.RequestInterceptor;
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


    public static <S> S createService(Class<S> serviceClass, final AccessToken token) {
        if (token != null) {
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    //necessary? is header also being encoded?
                    request.addHeader("Accept", "application/json");
                    request.addHeader("Authorization", token.getTokenType() + " " + token.getAccessToken());
                }
            });
        }

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
}
