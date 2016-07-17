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

        String secret = MyApp.getAppContext().getResources().getString(R.string.jwt_secret);
        byte[] stringBytes = secret.getBytes();

        Key key = new HmacKey(stringBytes);
        JsonWebSignature jws = new JsonWebSignature();

        jws.setKey(key);
        jws.setPayload(payload);
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
        jws.setDoKeyValidation(false);
        String signedJwt = jws.getCompactSerialization();

        JsonWebEncryption jwe = new JsonWebEncryption();
        jwe.setKey(key);
        jwe.setPayload(signedJwt);
        jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.PBES2_HS256_A128KW);
        jwe.setContentEncryptionKey(stringBytes);
        jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_256_GCM);
        SecureRandom iv = SecureRandom.getInstance("SHA1PRNG");
        jwe.setIv(iv.generateSeed(32));
        String encryptedJwt = jwe.getCompactSerialization();


        return encryptedJwt;
    }

}

