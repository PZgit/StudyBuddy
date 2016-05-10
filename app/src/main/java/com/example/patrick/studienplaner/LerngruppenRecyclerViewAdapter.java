package com.example.patrick.studienplaner;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Patrick on 10.05.2016.
 */
public class LerngruppenRecyclerViewAdapter extends RecyclerView.Adapter<LerngruppenRecyclerViewAdapter.TermineViewHolder>{

    List<Termin> termine;

    LerngruppenRecyclerViewAdapter(List<Termin> termine){
        this.termine = termine;
    }

    public static class TermineViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView titel;
        TextView uhrzeit;
        TextView ort;

        TermineViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            titel = (TextView)itemView.findViewById(R.id.titel);
            uhrzeit = (TextView)itemView.findViewById(R.id.uhrzeit);
            ort = (TextView)itemView.findViewById(R.id.ort);
        }
    }
    @Override
    public int getItemCount() {
        return termine.size();
    }
    @Override
    public TermineViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lerngruppen_card, viewGroup, false);
        TermineViewHolder tvh = new TermineViewHolder(v);
        return tvh;
    }
    @Override
    public void onBindViewHolder(TermineViewHolder termineViewHolder, int i) {
        termineViewHolder.titel.setText(termine.get(i).titel);
        termineViewHolder.uhrzeit.setText(termine.get(i).uhrzeit);
        termineViewHolder.ort.setText(termine.get(i).ort);
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
