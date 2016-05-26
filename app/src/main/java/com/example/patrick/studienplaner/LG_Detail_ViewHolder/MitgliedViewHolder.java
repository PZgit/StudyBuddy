package com.example.patrick.studienplaner.LG_Detail_ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.patrick.studienplaner.R;
import com.example.patrick.studienplaner.model.LerngruppenCardContent;
import com.example.patrick.studienplaner.model.Mitglied;

/**
 * Created by Patrick on 25.05.2016.
 */
public class MitgliedViewHolder<T extends LerngruppenCardContent> extends LGCardContentViewHolder<Mitglied>{
    private final Context context;
    private final TextView name;

    public MitgliedViewHolder(final Context context, final View view) {
        super(view);
        this.context = context;
        this.name= (TextView) view.findViewById(R.id.member_name);

    }

    @Override
    public int getType() {
        return Mitglied.VIEW_TYPE;
    }

    public void setData(Mitglied mitglied) {
        this.name.setText(mitglied.name);

    }
}
