package com.example.patrick.studienplaner.model.LerngruppenModels;

/**
 * Created by Patrick on 27.05.2016.
 */
public class Lerngruppe extends LerngruppenCardContent {

    public final static int VIEW_TYPE = 0;

    public String name;

    public Lerngruppe(String name) {
        this.name = name;
    }

    @Override
    public int getType() {
        return VIEW_TYPE;
    }
}
