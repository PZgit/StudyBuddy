package com.example.patrick.studienplaner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 09.05.2016.
 */
public class Termin {

    public String titel, uhrzeit, ort;

    public Termin(String titel, String ort, String uhrzeit) {
        this.titel = titel;
        this.ort = ort;
        this.uhrzeit = uhrzeit;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    private List<Termin> termine;



}