package com.example.patrick.studienplaner.model.LG_DetailModels;

/**
 * Created by Patrick on 24.05.2016.
 */
public class Mitglied extends LG_DetailCardContent {

    public final static int VIEW_TYPE = 2;

    public String name;

    public Mitglied(String name) {
        this.name = name;
    }

    @Override
    public int getType() {
        return VIEW_TYPE;
    }
}
