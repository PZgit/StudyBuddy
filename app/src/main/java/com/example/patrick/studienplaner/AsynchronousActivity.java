package com.example.patrick.studienplaner;

import android.widget.Toast;

import com.alamkanak.weekview.WeekViewEvent;
//import com.alamkanak.weekview.sample.BaseActivity;import com.alamkanak.weekview.sample.R;import com.alamkanak.weekview.sample.apiclient.Event;
import com.example.patrick.studienplaner.apiclient.MyJsonService;
import com.example.patrick.studienplaner.apiclient.ServiceGenerator;
import com.example.patrick.studienplaner.model.data.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * An example of how events can be fetched from network and be displayed on the week view.
 * Created by Raquib-ul-Alam Kanak on 1/3/2014.
 * Website: http://alamkanak.github.io
 */
public class AsynchronousActivity extends BaseActivity implements Callback<List<Event>> {

    private List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
    ServiceGenerator sg = new ServiceGenerator();
    boolean calledNetwork = false;

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {

        // Download events from network if it hasn't been done already. To understand how events are
        // downloaded using retrofit, visit http://square.github.io/retrofit
        /*if (!calledNetwork) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://87.106.149.172:1337")
                    .build();
            MyJsonService service = retrofit.create(MyJsonService.class);
            service.listEvents(this);
            calledNetwork = true;
        }*/

        // Return only the events that matches newYear and newMonth.
        List<WeekViewEvent> matchedEvents = new ArrayList<WeekViewEvent>();
        for (WeekViewEvent event : events) {
            if (eventMatches(event, newYear, newMonth)) {
                matchedEvents.add(event);
            }
        }
        return matchedEvents;
    }

    /**
     * Checks if an event falls into a specific year and month.
     * @param event The event to check for.
     * @param year The year.
     * @param month The month.
     * @return True if the event matches the year and month.
     */
    private boolean eventMatches(WeekViewEvent event, int year, int month) {
        return (event.getStartTime().get(Calendar.YEAR) == year && event.getStartTime().get(Calendar.MONTH) == month - 1) || (event.getEndTime().get(Calendar.YEAR) == year && event.getEndTime().get(Calendar.MONTH) == month - 1);
    }

    @Override
    public void success(List<Event> events, Response response) {
        this.events.clear();
        for (Event event : events) {
            this.events.add(event.toWeekViewEvent());
        }
        getWeekView().notifyDatasetChanged();
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
        Toast.makeText(this, "Async Error", Toast.LENGTH_SHORT).show();
    }

   /* public static RestAdapter createAdapter(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient();

        // loading CAs from an InputStream
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        InputStream cert = context.getResources().openRawResource(R.raw.my_cert);
        Certificate ca;
        try {
            ca = cf.generateCertificate(cert);
        } finally { cert.close(); }

        // creating a KeyStore containing our trusted CAs
        String keyStoreType = KeyStore.getDefaultType();
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(null, null);
        keyStore.setCertificateEntry("ca", ca);

        // creating a TrustManager that trusts the CAs in our KeyStore
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(keyStore);

        // creating an SSLSocketFactory that uses our TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        okHttpClient.setSslSocketFactory(sslContext.getSocketFactory());

        // creating a RestAdapter using the custom client
        return new RestAdapter.Builder()
                .setEndpoint("https://87.106.149.172:1337")
                .setClient(new OkClient(okHttpClient))
                .build();
    } */

}
