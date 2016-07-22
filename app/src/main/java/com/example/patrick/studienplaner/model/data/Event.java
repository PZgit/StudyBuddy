package com.example.patrick.studienplaner.model.data;

import android.annotation.SuppressLint;
import android.graphics.Color;

import com.alamkanak.weekview.WeekViewEvent;
import com.google.android.gms.search.SearchAuth;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Event {
    @Expose @SerializedName("id")
    private String id;
    @Expose @SerializedName("title")
    private String mName;
    @Expose @SerializedName("dayOfMonth")
    private int mDayOfMonth;
    @Expose @SerializedName("start")
    private String mStartTime;
    @Expose @SerializedName("end")
    private String mEndTime;
    @Expose @SerializedName("color")
    private String mColor;
    @Expose @SerializedName("lecturer")
    private String mLecturer;
    @Expose @SerializedName("type")
    private String mType;
    @Expose @SerializedName("building")
    private String mBuilding;
    @Expose @SerializedName("room")
    private String mRoom;

    public Event(String mStartTime, String mEndTime, String mBuilding, String mRoom, String mName) {
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mBuilding = mBuilding;
        this.mRoom = mRoom;
        this.mName = mName;
    }

    public String getmRoom() {
        return mRoom;
    }

    public void setmRoom(String mRoom) {
        this.mRoom = mRoom;
    }

    public String getmBuilding() {
        return mBuilding;
    }

    public void setmBuilding(String mBuilding) {
        this.mBuilding = mBuilding;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmLecturer() {
        return mLecturer;
    }

    public void setmLecturer(String mLecturer) {
        this.mLecturer = mLecturer;
    }



    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getDayOfMonth() {
        return mDayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.mDayOfMonth = dayOfMonth;
    }

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        this.mStartTime = startTime;
    }

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        this.mEndTime = endTime;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        this.mColor = color;
    }

    @SuppressLint("SimpleDateFormat")
    public WeekViewEvent toWeekViewEvent(){

        // Parse time.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date start = new Date();
        Date end = new Date();
        try {
            start = sdf.parse(getStartTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            end = sdf.parse(getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Initialize start and end time.
        Calendar now = Calendar.getInstance();
        Calendar startTime = (Calendar) now.clone();
        startTime.setTimeInMillis(start.getTime());
        startTime.set(Calendar.YEAR, now.get(Calendar.YEAR));
        startTime.set(Calendar.MONTH, now.get(Calendar.MONTH));
        startTime.set(Calendar.DAY_OF_MONTH, getDayOfMonth());
        Calendar endTime = (Calendar) startTime.clone();
        endTime.setTimeInMillis(end.getTime());
        endTime.set(Calendar.YEAR, startTime.get(Calendar.YEAR));
        endTime.set(Calendar.MONTH, startTime.get(Calendar.MONTH));
        endTime.set(Calendar.DAY_OF_MONTH, startTime.get(Calendar.DAY_OF_MONTH));

        // Create an week view event.
        WeekViewEvent weekViewEvent = new WeekViewEvent();
        weekViewEvent.setName(getName());
        weekViewEvent.setStartTime(startTime);
        weekViewEvent.setEndTime(endTime);
        weekViewEvent.setColor(Color.parseColor(getColor()));

        return weekViewEvent;
    }

}
