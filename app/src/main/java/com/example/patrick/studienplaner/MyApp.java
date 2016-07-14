package com.example.patrick.studienplaner;

import android.app.Application;
import android.content.Context;

/**
 * Created by Julian on 14.07.2016.
 */
public class MyApp extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApp.context;
    }
}

