package com.example.patrick.studienplaner.model.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 24.05.2016.
 */
public class Lecture {
    private int number;
    private String label;
    private String year;
    private String program;
    private int session;
    private List<Lecturers> lecturers = new ArrayList<>();
    private List<Event> events = new ArrayList<>();

    public Lecture(int number, String label, String year, String program, int session, List<Lecturers> lecturers, List<Event> events) {
        this.number = number;
        this.label = label;
        this.year = year;
        this.program = program;
        this.session = session;
        this.lecturers = lecturers;
        this.events = events;
    }

    public Lecture(){};

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public List<Lecturers> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturers> lecturers) {
        this.lecturers = lecturers;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "number=" + number +
                ", label='" + label + '\'' +
                ", year='" + year + '\'' +
                ", program='" + program + '\'' +
                ", session=" + session +
                ", lecturers=" + lecturers +
                ", events=" + events +
                '}';
    }
}
