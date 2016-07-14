package com.example.patrick.studienplaner;

/**
 * Created by Julian on 14.07.2016.
 */

import android.content.Context;

import com.example.patrick.studienplaner.MyApp;
import com.example.patrick.studienplaner.R;
import com.example.patrick.studienplaner.ServiceGenerator;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

@SuppressWarnings("unused")
public class SelfSigningClientBuilder {




    @SuppressWarnings("null")
    public static OkHttpClient configureClient(final OkHttpClient client) {
        // Loading CAs from an InputStream
        try {
            CertificateFactory cf = null;
            cf = CertificateFactory.getInstance("X.509");

            Certificate ca;
            try (InputStream cert = MyApp.getAppContext().getResources().openRawResource(R.raw.server)) {
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

            try {
                final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                    @Override
                    public boolean verify(final String hostname,
                                          final SSLSession session) {
                        return true;
                    }
                };
                client.setHostnameVerifier(hostnameVerifier);
                client.setSslSocketFactory(sslContext.getSocketFactory());
            } catch (final Exception e) {
            }
        } catch (Exception e) {
        }

        return client;
    }

    public static OkHttpClient createClient() {
        final OkHttpClient client = new OkHttpClient();
        return configureClient(client);
    }

}
