package com.example.patrick.studienplaner.LG_Detail_ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.patrick.studienplaner.R;
import com.example.patrick.studienplaner.model.LG_DetailModels.LG_DetailCardContent;
import com.example.patrick.studienplaner.model.LG_DetailModels.TerminInvite;

/**
 * Created by Patrick on 25.05.2016.
 */
public class TerminInviteViewHolder<T extends LG_DetailCardContent> extends LG_DetailViewHolder<TerminInvite> {
    private final Context context;
    private final TextView titel, uhrzeit, ort;

    public TerminInviteViewHolder(final Context context, final View view) {
        super(view);
        this.context = context;
        titel = (TextView) view.findViewById(R.id.titel);
        uhrzeit = (TextView) view.findViewById(R.id.uhrzeit);
        ort = (TextView) view.findViewById(R.id.ort);
    }

    @Override
    public int getType() {
        return TerminInvite.VIEW_TYPE;
    }

    public void setData(TerminInvite terminInvite) {
        this.titel.setText(terminInvite.titel);
        this.uhrzeit.setText(terminInvite.uhrzeit);
        this.ort.setText(terminInvite.ort);
    }


}