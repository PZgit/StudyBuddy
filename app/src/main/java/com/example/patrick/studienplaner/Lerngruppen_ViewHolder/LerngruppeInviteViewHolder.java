package com.example.patrick.studienplaner.Lerngruppen_ViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.patrick.studienplaner.R;
import com.example.patrick.studienplaner.model.LerngruppenModels.LerngruppeInvite;
import com.example.patrick.studienplaner.model.LerngruppenModels.LerngruppenCardContent;

/**
 * Created by Patrick on 27.05.2016.
 */
public class LerngruppeInviteViewHolder <T extends LerngruppenCardContent> extends LG_AbstractViewHolder<LerngruppeInvite> {
    private final Context context;
    private final TextView name;

    public LerngruppeInviteViewHolder(final Context context, final View view) {
        super(view);
        this.context = context;
        this.name= (TextView) view.findViewById(R.id.member_name);

    }

    @Override
    public int getType() {
        return LerngruppeInvite.VIEW_TYPE;
    }

    public void setData(LerngruppeInvite lerngruppeInvite) {
        this.name.setText(lerngruppeInvite.name);

    }
}