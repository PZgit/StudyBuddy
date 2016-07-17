package com.example.patrick.studienplaner;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.alamkanak.weekview.WeekViewEvent;
import com.example.patrick.studienplaner.apiclient.JWTMaker;
import com.example.patrick.studienplaner.apiclient.MyJsonService;
import com.example.patrick.studienplaner.apiclient.ServiceGenerator;
import com.example.patrick.studienplaner.model.data.Event;
import com.example.patrick.studienplaner.model.data.User;

import org.jose4j.lang.JoseException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

//import com.alamkanak.weekview.sample.BaseActivity;import com.alamkanak.weekview.sample.R;import com.alamkanak.weekview.sample.apiclient.Event;

/**
 * An example of how events can be fetched from network and be displayed on the week view.
 * Created by Raquib-ul-Alam Kanak on 1/3/2014.
 * Website: http://alamkanak.github.io
 */
public class AsynchronousActivity extends BaseActivity implements Callback<List<Event>> {

    private List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
    boolean calledNetwork = false;

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        SharedPreferences settings = getPreferences(0);
        if(!calledNetwork){
            try {
                String userId = settings.getString("user_id", "");

                JWTMaker.createJWT("", userId);
                /*MyJsonService service = ServiceGenerator.createService(MyJsonService.class, MyJsonService.API_BASE_URL);
                service.listEvents(userId, this);*/
            }catch (JoseException e){
                e.printStackTrace();
            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            calledNetwork = true;
        }


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
     *
     * @param event The event to check for.
     * @param year  The year.
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

}
