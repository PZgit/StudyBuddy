package com.example.patrick.studienplaner.apiclient;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Julian on 15.07.2016.
 */
public interface LoginService {
    @FormUrlEncoded
    @POST("/token")
    AccessToken getAccessToken(
            @Field("code") String code,
            @Field("grant_type") String grantType);
}
