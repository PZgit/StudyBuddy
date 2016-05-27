package com.example.patrick.studienplaner.LG_Detail_ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.patrick.studienplaner.R;
import com.example.patrick.studienplaner.model.LG_DetailModels.LG_DetailCardContent;
import com.example.patrick.studienplaner.model.LG_DetailModels.Mitglied;

/**
 * Created by Patrick on 25.05.2016.
 */
public class MitgliedViewHolder<T extends LG_DetailCardContent> extends LG_DetailViewHolder<Mitglied> {
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
