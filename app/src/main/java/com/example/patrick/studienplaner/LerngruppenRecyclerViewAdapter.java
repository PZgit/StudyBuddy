package com.example.patrick.studienplaner;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.patrick.studienplaner.LG_Detail_ViewHolder.LGCardContentViewHolder;
import com.example.patrick.studienplaner.LG_Detail_ViewHolder.MitgliedViewHolder;
import com.example.patrick.studienplaner.LG_Detail_ViewHolder.TerminInviteViewHolder;
import com.example.patrick.studienplaner.LG_Detail_ViewHolder.TerminViewHolder;
import com.example.patrick.studienplaner.model.LerngruppenCardContent;
import com.example.patrick.studienplaner.model.Mitglied;
import com.example.patrick.studienplaner.model.Termin;
import com.example.patrick.studienplaner.model.TerminInvite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 10.05.2016.
 */
public class LerngruppenRecyclerViewAdapter extends RecyclerView.Adapter<LGCardContentViewHolder<LerngruppenCardContent>>{

    public final Context context;
    private List<LerngruppenCardContent> LGDetailList;

    public LerngruppenRecyclerViewAdapter(final Context context, final List<LerngruppenCardContent> LGDetailList){
        this.context = context;
        this.LGDetailList = new ArrayList<>(LGDetailList);
    }


    @Override
    public int getItemCount() {

        return LGDetailList.size();
    }

    @Override
    public LGCardContentViewHolder<LerngruppenCardContent> onCreateViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = null;

        switch (viewType) {
            case Termin.VIEW_TYPE:
                view = inflater.inflate(R.layout.cv_termine, null);
                return new TerminViewHolder(context, view);
            case TerminInvite.VIEW_TYPE:
                view = inflater.inflate(R.layout.cv_termine_invite, null);
                return new TerminInviteViewHolder(context, view);
            case Mitglied.VIEW_TYPE:
                view = inflater.inflate(R.layout.cv_mitglieder, null);
                return new MitgliedViewHolder(context, view);
            default:
                throw new IllegalArgumentException("The viewType " + viewType + " is unknown");
        }
    }
    @Override
    public void onBindViewHolder(final LGCardContentViewHolder<LerngruppenCardContent> holder, final int position) {
            holder.setData(LGDetailList.get(position));
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(final int position) {
        return LGDetailList.get(position).getType();
    }

}
