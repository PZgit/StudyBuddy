package com.example.patrick.studienplaner.Lerngruppen_ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.patrick.studienplaner.model.LerngruppenModels.LerngruppenCardContent;

/**
 * Created by Patrick on 27.05.2016.
 */
public abstract class LG_AbstractViewHolder<T extends LerngruppenCardContent> extends RecyclerView.ViewHolder{

    public LG_AbstractViewHolder(final View itemView) {
        super(itemView);
    }

    public abstract int getType();
    public abstract void setData(T event);
}
