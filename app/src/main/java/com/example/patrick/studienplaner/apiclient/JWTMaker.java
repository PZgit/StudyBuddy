package com.example.patrick.studienplaner.apiclient;

import android.content.SharedPreferences;

import com.example.patrick.studienplaner.MyApp;
import com.example.patrick.studienplaner.R;

import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.JoseException;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.SecretKey;

/**
 * Created by Julian on 16.07.2016.
 */
public class JWTMaker {

    public static String createJWT(String id, String payload) throws JoseException, NoSuchAlgorithmException {

        final SharedPreferences settings = MyApp.getAppContext().getSharedPreferences("UserFile", 0);
        String accessToken = settings.getString("access_token", "");


        String secret = MyApp.getAppContext().getResources().getString(R.string.jwt_secret);
        JsonWebSignature jws = new JsonWebSignature();

        jws.setKey(new HmacKey(secret.getBytes()));
        jws.setPayload(payload);
        //jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
        jws.setHeader("alg", "HS256");
        jws.setHeader("typ", "JWT");
        String signedJwt = jws.getCompactSerialization();

        return signedJwt;
    }

}

