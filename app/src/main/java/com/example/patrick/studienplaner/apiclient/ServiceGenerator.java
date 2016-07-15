package com.example.patrick.studienplaner.apiclient;

import android.util.Base64;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Julian on 12.07.2016.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "https://87.106.149.172:1337";

    public static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL)
            .setClient(new OkClient(SelfSigningClientBuilder.createClient()));

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        if (authToken != null) {
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestInterceptor.RequestFacade request) {
                    request.addHeader("Authorization", authToken);
                }
            });
        }

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }


    public static <S> S createService(Class<S> serviceClass, String username, String password) {
        if (username != null && password != null) {
            // concatenate username and password with colon for authentication
            String credentials = username + ":" + password;
            // create Base64 encoded string
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Authorization", basic);
                    request.addHeader("Accept", "application/json");
                }
            });
        }

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, final AccessToken token) {
        if (token != null) {
            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader("Accept", "application/json");
                    request.addHeader("Authorization",
                            token.getTokenType() + " " + token.getAccessToken());
                }
            });
        }

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
}
