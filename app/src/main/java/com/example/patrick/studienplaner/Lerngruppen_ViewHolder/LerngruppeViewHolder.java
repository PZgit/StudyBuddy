package com.example.patrick.studienplaner.Lerngruppen_ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.patrick.studienplaner.R;
import com.example.patrick.studienplaner.model.LerngruppenModels.Lerngruppe;
import com.example.patrick.studienplaner.model.LerngruppenModels.LerngruppenCardContent;

/**
 * Created by Patrick on 27.05.2016.
 */
public class LerngruppeViewHolder <T extends LerngruppenCardContent> extends LG_AbstractViewHolder<Lerngruppe> {
    private final Context context;
    private final TextView name;

    public LerngruppeViewHolder(final Context context, final View view) {
        super(view);
        this.context = context;
        this.name= (TextView) view.findViewById(R.id.name);

    }

    @Override
    public int getType() {
        return Lerngruppe.VIEW_TYPE;
    }

    public void setData(Lerngruppe lerngruppe) {
        this.name.setText(lerngruppe.name);

    }
}
