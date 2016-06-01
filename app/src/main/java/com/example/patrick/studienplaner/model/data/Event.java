package com.example.patrick.studienplaner.model.data;

import java.util.Date;

/**
 * Created by Julian on 18.05.2016.
 */
public class Event {
    private String id;
    private boolean status;
    private String summary;
    private Date start;
    private Date end;

    public Event(String id, boolean status, String summary, Date start, Date end) {
        this.id = id;
        this.status = status;
        this.summary = summary;
        this.start = start;
        this.end = end;
    }

    public Event(){}

    public String getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getStarttime() {
        return start;
    }

    public void setStarttime(Date start) {
        this.start = start;
    }

    public Date getEndtime() {
        return end;
    }

    public void setEndtime(Date end) {
        this.end = end;
    }
}
