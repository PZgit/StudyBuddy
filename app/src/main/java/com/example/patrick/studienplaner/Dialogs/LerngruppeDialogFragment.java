package com.example.patrick.studienplaner.Dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.patrick.studienplaner.R;

/**
 * Created by Patrick on 01.06.2016.
 */
public class LerngruppeDialogFragment extends android.app.DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setTitle("Lerngruppe erstellen");

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_lerngruppe, null))
                // Add action buttons
                .setPositiveButton("erstellen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        dismiss();
                    }
                })
                .setNegativeButton("abbrechen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LerngruppeDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

}
