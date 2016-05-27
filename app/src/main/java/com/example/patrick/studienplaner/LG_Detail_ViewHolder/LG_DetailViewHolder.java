package com.example.patrick.studienplaner.LG_Detail_ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.patrick.studienplaner.model.LG_DetailModels.LG_DetailCardContent;

/**
 * Created by Patrick on 25.05.2016.
 */
public abstract class LG_DetailViewHolder<T extends LG_DetailCardContent> extends RecyclerView.ViewHolder{

    public LG_DetailViewHolder(final View itemView) {
        super(itemView);
    }

    public abstract int getType();
    public abstract void setData(T event);
}
