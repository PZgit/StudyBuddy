package com.example.patrick.studienplaner.model.data;

import java.util.List;

/**
 * Created by Julian on 24.05.2016.
 */
public class Lectures {
    private int session;
    private String label;
    private List<String> lectures;

    public Lectures(){}

    public Lectures(int session, String label, List<String> lectures) {
        this.session = session;
        this.label = label;
        this.lectures = lectures;
    }

}
