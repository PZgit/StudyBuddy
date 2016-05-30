package com.example.patrick.studienplaner.model.data;

/**
 * Created by Julian on 24.05.2016.
 */
public class Lecturers {
    private String label;
    private String url;

    public Lecturers() {
    }

    public Lecturers(String url, String label) {
        this.url = url;
        this.label = label;
    }
}
