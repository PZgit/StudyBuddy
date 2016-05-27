package com.example.patrick.studienplaner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.patrick.studienplaner.Lerngruppen_ViewHolder.LG_AbstractViewHolder;
import com.example.patrick.studienplaner.Lerngruppen_ViewHolder.LerngruppeInviteViewHolder;
import com.example.patrick.studienplaner.Lerngruppen_ViewHolder.LerngruppeViewHolder;
import com.example.patrick.studienplaner.model.LerngruppenModels.Lerngruppe;
import com.example.patrick.studienplaner.model.LerngruppenModels.LerngruppeInvite;
import com.example.patrick.studienplaner.model.LerngruppenModels.LerngruppenCardContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 27.05.2016.
 */
public class LerngruppenAdapter extends RecyclerView.Adapter<LG_AbstractViewHolder<LerngruppenCardContent>>{

    public final Context context;
    private List<LerngruppenCardContent> LerngruppenList;

    public LerngruppenAdapter(final Context context, final List<LerngruppenCardContent> lerngruppenList){
        this.context = context;
        this.LerngruppenList = new ArrayList<>(lerngruppenList);
    }


    @Override
    public int getItemCount() {

        return LerngruppenList.size();
    }

    @Override
    public LG_AbstractViewHolder<LerngruppenCardContent> onCreateViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = null;

        switch (viewType) {
            case Lerngruppe.VIEW_TYPE:
                view = inflater.inflate(R.layout.cv_lerngruppe, parent, false);
                return new LerngruppeViewHolder(context, view);
            case LerngruppeInvite.VIEW_TYPE:
                view = inflater.inflate(R.layout.cv_lerngruppe_invite, parent, false);
                return new LerngruppeInviteViewHolder(context, view);
            default:
                throw new IllegalArgumentException("The viewType " + viewType + " is unknown");
        }
    }
    @Override
    public void onBindViewHolder(final LG_AbstractViewHolder<LerngruppenCardContent> holder, final int position) {
        holder.setData(LerngruppenList.get(position));
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(final int position) {
        return LerngruppenList.get(position).getType();
    }

}

