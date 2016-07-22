package com.example.patrick.studienplaner;

import com.alamkanak.weekview.WeekViewEvent;
import com.alamkanak.weekview.WeekView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Patrick on 21.07.2016.
 */
public class WeekViewEventDatabase {

    public static WeekViewEventDatabase instance;

    public ArrayList<WeekViewEvent> events;

    public static WeekViewEventDatabase getInstance(){
        if (instance==null)
        {
            instance=new WeekViewEventDatabase();
        }
        return instance;
    }

    private WeekViewEventDatabase() {
        events = new ArrayList<WeekViewEvent>();

    }

    public void save(WeekViewEvent event){

        events.add(event);

    }

    public ArrayList<WeekViewEvent> load(){

        return events;
    }
}
