package com.example.patrick.studienplaner;

/**
 * Created by Patrick on 09.05.2016.
 */
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Lerngruppen_Activity extends Activity{

    private List<Termin> termine;
    private RecyclerView rv_lerngruppen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        setContentView(R.layout.rv_lerngruppen);

        rv_lerngruppen=(RecyclerView)findViewById(R.id.rv_lerngruppen);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv_lerngruppen.setLayoutManager(llm);
        rv_lerngruppen.setHasFixedSize(true);

        initializeDataTermin();
        initializeAdapter();
    }

    private void initializeDataTermin() {
        termine = new ArrayList<>();
        termine.add(new Termin("Lerntermin111", "12Uhr", "SHL H.1.1"));
        termine.add(new Termin("Lerntermin222", "4Uhr", "Münzstr. 15"));
        termine.add(new Termin("Lerntermin333", "51Uhr", "Daheim"));
    }
    private void initializeAdapter(){
        LerngruppenRecyclerViewAdapter adapter = new LerngruppenRecyclerViewAdapter(termine);
        rv_lerngruppen.setAdapter(adapter);
    }
}
