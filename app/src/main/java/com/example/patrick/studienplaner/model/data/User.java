package com.example.patrick.studienplaner.model.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

/**
 * Created by Julian on 24.05.2016.
 */
public class User {

    private String id;

    public User(){
        this.id = "501102";
    }
    public User(String id){
        this.id = id;

    }


    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    public void getIdAsJson(){
        Gson gson = new Gson();
        id = "{ \"id\":\"" + id + " \"}";
    }

}
