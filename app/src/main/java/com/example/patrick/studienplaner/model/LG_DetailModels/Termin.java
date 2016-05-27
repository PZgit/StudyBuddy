package com.example.patrick.studienplaner.model.LG_DetailModels;


/**
 * Created by Patrick on 09.05.2016.
 */
public class Termin extends LG_DetailCardContent {

    public final static int VIEW_TYPE = 0;
    public String titel, uhrzeit, ort;

    public Termin(String titel, String ort, String uhrzeit) {
        this.titel = titel;
        this.ort = ort;
        this.uhrzeit = uhrzeit;
    }


    @Override
    public int getType() {
        return VIEW_TYPE;
    }
}