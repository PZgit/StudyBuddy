package com.example.patrick.studienplaner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class BaseEventDialog extends AppCompatActivity {

    long eId = 0;
    EditText eName;
    EditText eLocation;
    Button setStart;
    Button setEnd;
    Button setDate;
    Button accept;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_event_dialog);
    }
}
