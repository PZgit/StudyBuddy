package com.example.patrick.studienplaner.LG_Detail_ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.patrick.studienplaner.*;
import com.example.patrick.studienplaner.model.LG_DetailModels.LG_DetailCardContent;
import com.example.patrick.studienplaner.model.LG_DetailModels.Termin;

/**
 * Created by Patrick on 25.05.2016.
 */
public class TerminViewHolder<T extends LG_DetailCardContent> extends LG_DetailViewHolder<Termin> {

    private final Context context;
    private final TextView titel, uhrzeit, ort;

    public TerminViewHolder(final Context context, final View view) {
        super(view);
        this.context = context;
        titel = (TextView) view.findViewById(R.id.titel);
        uhrzeit = (TextView) view.findViewById(R.id.uhrzeit);
        ort = (TextView) view.findViewById(R.id.ort);
    }

    @Override
    public int getType() {
        return Termin.VIEW_TYPE;
    }

    public void setData(Termin termin) {
        this.titel.setText(termin.titel);
        this.uhrzeit.setText(termin.uhrzeit);
        this.ort.setText(termin.ort);
    }



}
