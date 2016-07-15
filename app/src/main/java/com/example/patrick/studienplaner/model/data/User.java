package com.example.patrick.studienplaner.model.data;

/**
 * Created by Julian on 24.05.2016.
 */
public class User {

    private String id;
    private String tok;

    public User() {
    }

    public User(String id, String tok) {
        this.id = id;
        this.tok = tok;

    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setTok(String tok){
        this.tok = tok;
    }

    public String getTok(){return tok;}


}
