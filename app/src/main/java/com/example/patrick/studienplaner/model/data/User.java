package com.example.patrick.studienplaner.model.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Julian on 24.05.2016.
 */
public class User {

    private String tok;

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("given_name")
    private String givenName;

    @SerializedName("family_name")
    private String familyName;

    @SerializedName("link")
    private String link;

    @SerializedName("picture")
    private String picture;

    @SerializedName("gender")
    private String gender;

    @SerializedName("locale")
    private String locale;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getLink() {
        return link;
    }

    public String getPicture() {
        return picture;
    }

    public String getGender() {
        return gender;
    }

    public String getLocale() {
        return locale;
    }

    public User() {
    }


    public void setTok(String tok) {
        this.tok = tok;
    }

    public String getTok() {
        return tok;
    }


}
