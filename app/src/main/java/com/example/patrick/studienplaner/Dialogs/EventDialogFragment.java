package com.example.patrick.studienplaner.Dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.alamkanak.weekview.WeekViewEvent;
import com.example.patrick.studienplaner.R;

import java.util.Calendar;

/**
 * Created by Patrick on 01.06.2016.
 */
public class EventDialogFragment extends android.app.DialogFragment {

    EditText name;
    TimePicker picker;
    EditText time;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_event, null);
        builder.setTitle("Event erstellen");

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("erstellen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        time = (EditText) view.findViewById(R.id.event_dauer);
                        name = (EditText) view.findViewById(R.id.event_name);
                        picker = (TimePicker) view.findViewById(R.id.timePicker1);
                        int startHour = picker.getHour();
                        int startMinute = picker.getMinute();
                        String mName = name.getText().toString();

                        int endHour = Integer.parseInt(time.getText().toString().split(":")[0]);
                        int endMinute = Integer.parseInt(time.getText().toString().split(":")[1]);

                        Calendar startTime = Calendar.getInstance();
                        startTime.set(Calendar.HOUR_OF_DAY, startHour);
                        startTime.set(Calendar.MINUTE, startMinute);
                        startTime.set(Calendar.MONTH, 6);
                        startTime.set(Calendar.YEAR, 2016);
                        Calendar endTime = (Calendar) startTime.clone();
                        endTime.set(Calendar.HOUR, startHour + endHour);
                        endTime.set(Calendar.MONTH, 6);
                        endTime.set(Calendar.MINUTE, endMinute);
                        WeekViewEvent event = new WeekViewEvent(30, mName, startTime, endTime);
                        event.setColor(getResources().getColor(R.color.event_color_01));

                        dismiss();
                    }
                })
                .setNegativeButton("abbrechen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EventDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

}