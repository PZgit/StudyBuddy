package com.example.patrick.studienplaner;

/**
 * Created by Patrick on 09.05.2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import com.example.patrick.studienplaner.model.LerngruppenCardContent;
import com.example.patrick.studienplaner.model.Termin;

import java.util.ArrayList;
import java.util.List;

public class LerngruppenDetailActivity extends Activity{

    private List<LerngruppenCardContent> LGDetailList = LerngruppenCardContent.createData();
    private LerngruppenRecyclerViewAdapter adapter;
    private RecyclerView rv_lerngruppen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_lerngruppen);

        rv_lerngruppen=(RecyclerView)findViewById(R.id.rv_lerngruppen);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayout.VERTICAL);
        rv_lerngruppen.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LerngruppenRecyclerViewAdapter(getBaseContext(), LGDetailList);

        rv_lerngruppen.setAdapter(adapter);

    }

}
