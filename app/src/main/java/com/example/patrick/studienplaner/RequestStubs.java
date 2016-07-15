package com.example.patrick.studienplaner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.patrick.studienplaner.model.data.Events;
import com.example.patrick.studienplaner.model.data.EventsList;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Julian on 30.05.2016.
 */
public class RequestStubs {


   /* String url = "https://87.106.149.172:1337/";

    //model for JsonObjectequest
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            //try-catch is not immediately necessary
            try {
                if (response == null) {
                    throw new JSONException("Fehler!");
                }
                //do on successful request
            } catch (JSONException e) {
                //throw exception
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //respond to request errors
        }
    });

    //get all Events for a User via userId
    //TODO: missing GET-Header
    GsonRequestGet getAllEvents = new GsonRequestGet(url + "/events", EventsList.class, null, new Response.Listener<EventsList>(){
        @Override
        public void onResponse(EventsList eventsList){
            String res = "";
            for(int i=0; i<eventsList.getEvents().size(); i++){
                Events events = eventsList.getEvents().get(i);


                GsonRequestGet getActualEvents = new GsonRequestGet(events.getUrl(), Event.class, null, new Response.Listener<Event>(){
                    @Override
                    public void onResponse(Event event){

                    }
                }, new Response.ErrorListener(){
                    public void onErrorResponse(VolleyError error){

                    }
                });
            }
        }
    },  new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //respond to request errors
        }
    });

    //get Event by eventId
    //TODO: missing GET-Header
    JsonObjectRequest getEventById = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            //try-catch is not immediately necessary
            try {
                if (response == null) {
                    throw new JSONException("Fehler!");
                }
                //do on successful request
            } catch (JSONException e) {
                //throw exception
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //respond to request errors
        }
    });

    //Create a new Event
    //needs id, event: title, start, end, lecturer, type, building, room (attendees only for groups)
    JsonObjectRequest createEvent = new JsonObjectRequest(Request.Method.POST, url, newEvent, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            //use data
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //respond to request errors
        }
    });

    //delete Event by Id
    JsonObjectRequest deleteEventById = new JsonObjectRequest(Request.Method.DELETE, url, eventId, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            //use data
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //respond to request errors
        }
    });

    //delete Event by eventId
    JsonObjectRequest deleteEvent = new JsonObjectRequest(Request.Method.DELETE, url, eventId, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //respond to request errors
        }
    });



    //get all studygroups via userId
    //TODO: missing GET-Header
    JsonObjectRequest getStudygroups = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            //use data
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError e) {
            //respond to errors
        }
    });

    */


}
