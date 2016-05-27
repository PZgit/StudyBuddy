package com.example.patrick.studienplaner.model.LerngruppenModels;

/**
 * Created by Patrick on 27.05.2016.
 */
public class LerngruppeInvite extends LerngruppenCardContent {

    public final static int VIEW_TYPE = 1;

    public String name;

    public LerngruppeInvite(String name) {
        this.name = name;
    }

    @Override
    public int getType() {
        return VIEW_TYPE;
    }
}
