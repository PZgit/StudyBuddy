package com.example.patrick.studienplaner.LG_Detail_ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.patrick.studienplaner.model.LerngruppenCardContent;

/**
 * Created by Patrick on 25.05.2016.
 */
public abstract class LGCardContentViewHolder<T extends LerngruppenCardContent> extends RecyclerView.ViewHolder{

    public LGCardContentViewHolder(final View itemView) {
        super(itemView);
    }

    public abstract int getType();
    public abstract void setData(T event);
}
