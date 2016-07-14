package com.example.patrick.studienplaner;

import android.content.Context;

import com.example.patrick.studienplaner.model.SelfSigningClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit2.Retrofit;

/**
 * Created by Julian on 12.07.2016.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "https://87.106.149.172:1337";
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(API_BASE_URL)
            .setClient(new OkClient(SelfSigningClientBuilder.createClient()))
            .build();
/*
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL);

    OkHttpClient okHttp = new OkHttpClient();
    okHttp.setSslSocketFactory(getSSLConfig(context).getSocketFactory());

    Retrofit retrofit = builder.client(okHttp).build();
    retrofit.create(serviceClass);

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }


    OkHttpClient client = new OkHttpClient.Builder()
            .sslSocketFactory(sslContext.getSocketFactory())
            .build();

    SSLContext sslContext = getSSLConfig();
    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    trustManagerFactory.init(keyStore);
    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    keyManagerFactory.init(keyStore, "keystore_pass".toCharArray());
    sslContext.init(keyManagerFactory.getKeyManagers(),trustManagerFactory.getTrustManagers(), new SecureRandom());
    client.setSslSocketFactory(sslContext.getSocketFactory());




    Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL);




    private static SSLContext getSSLConfig(Context context) throws CertificateException, IOException,
            KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        // Loading CAs from an InputStream
        CertificateFactory cf = null;
        cf = CertificateFactory.getInstance("X.509");

        Certificate ca;
        try (InputStream cert = context.getResources().openRawResource(R.raw.server)) {
            ca = cf.generateCertificate(cert);
        }

        // Creating a KeyStore containing our trusted CAs
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", ca);


        // Creating a TrustManager that trusts the CAs in our KeyStore.
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(keyStore);

        // Creating an SSLSocketFactory that uses our TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        return sslContext;
    }
    */


}
