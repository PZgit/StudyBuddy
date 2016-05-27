package com.example.patrick.studienplaner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.patrick.studienplaner.LG_Detail_ViewHolder.LGCardContentViewHolder;
import com.example.patrick.studienplaner.LG_Detail_ViewHolder.MitgliedViewHolder;
import com.example.patrick.studienplaner.LG_Detail_ViewHolder.TerminInviteViewHolder;
import com.example.patrick.studienplaner.LG_Detail_ViewHolder.TerminViewHolder;
import com.example.patrick.studienplaner.model.LG_DetailModels.LG_DetailCardContent;
import com.example.patrick.studienplaner.model.LG_DetailModels.Mitglied;
import com.example.patrick.studienplaner.model.LG_DetailModels.Termin;
import com.example.patrick.studienplaner.model.LG_DetailModels.TerminInvite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 10.05.2016.
 */
public class LG_DetailRecyclerViewAdapter extends RecyclerView.Adapter<LGCardContentViewHolder<LG_DetailCardContent>>{

    public final Context context;
    private List<LG_DetailCardContent> LGDetailList;

    public LG_DetailRecyclerViewAdapter(final Context context, final List<LG_DetailCardContent> LGDetailList){
        this.context = context;
        this.LGDetailList = new ArrayList<>(LGDetailList);
    }


    @Override
    public int getItemCount() {

        return LGDetailList.size();
    }

    @Override
    public LGCardContentViewHolder<LG_DetailCardContent> onCreateViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = null;

        switch (viewType) {
            case Termin.VIEW_TYPE:
                view = inflater.inflate(R.layout.cv_termine, parent, false);
                return new TerminViewHolder(context, view);
            case TerminInvite.VIEW_TYPE:
                view = inflater.inflate(R.layout.cv_termine_invite, parent, false);
                return new TerminInviteViewHolder(context, view);
            case Mitglied.VIEW_TYPE:
                view = inflater.inflate(R.layout.cv_mitglieder, parent, false);
                return new MitgliedViewHolder(context, view);
            default:
                throw new IllegalArgumentException("The viewType " + viewType + " is unknown");
        }
    }
    @Override
    public void onBindViewHolder(final LGCardContentViewHolder<LG_DetailCardContent> holder, final int position) {
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
