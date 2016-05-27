package com.example.patrick.studienplaner.model.LG_DetailModels;

/**
 * Created by Patrick on 24.05.2016.
 */
public class TerminInvite extends LG_DetailCardContent {


    public final static int VIEW_TYPE = 1;
    public String titel, uhrzeit, ort;

    public TerminInvite(String titel, String ort, String uhrzeit) {
        this.titel = titel;
        this.ort = ort;
        this.uhrzeit = uhrzeit;
    }

    @Override
    public int getType() {
        return VIEW_TYPE;
    }
}
