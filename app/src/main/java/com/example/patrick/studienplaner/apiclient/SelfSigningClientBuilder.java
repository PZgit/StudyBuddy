package com.example.patrick.studienplaner.apiclient;

/**
 * Created by Julian on 14.07.2016.
 */

import com.example.patrick.studienplaner.MyApp;
import com.example.patrick.studienplaner.R;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

@SuppressWarnings("unused")
public class SelfSigningClientBuilder {

    @SuppressWarnings("null")
    public static OkHttpClient configureClient(final OkHttpClient client) {
        // Loading CAs from an InputStream
        try {

            InputStream cert = MyApp.getAppContext().getResources().openRawResource(R.raw.server);

            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509","BC");
            X509Certificate certX509 = (X509Certificate) certificateFactory.generateCertificate(cert);
            String alias = certX509.getSubjectX500Principal().getName();
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null);
            trustStore.setCertificateEntry(alias, certX509);

            // Creating a TrustManager that trusts the CAs in our KeyStore.
            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(trustStore);
            TrustManager[] trustManagers = tmf.getTrustManagers();
            final X509TrustManager origTrustmanager = (X509TrustManager)trustManagers[0];

            TrustManager[] wrappedTrustManagers = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return origTrustmanager.getAcceptedIssuers();
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                            try{
                                origTrustmanager.checkClientTrusted(certs, authType);
                            }catch (CertificateException e){}
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                            try {
                                origTrustmanager.checkServerTrusted(certs, authType);
                            } catch (CertificateException e) {}
                        }
                    }
            };


            // Creating an SSLSocketFactory that uses our TrustManager
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, wrappedTrustManagers, null);

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
