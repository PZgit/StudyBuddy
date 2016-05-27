package com.example.patrick.studienplaner;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.patrick.studienplaner.model.LerngruppenModels.LerngruppenCardContent;

import java.util.List;

/**
 * Created by Patrick on 27.05.2016.
 */
public class LerngruppenActivity extends Activity {

    private List<LerngruppenCardContent> LerngruppenList = LerngruppenCardContent.createData();
    private LerngruppenAdapter adapter;
    private RecyclerView rv_lerngruppen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_lerngruppen);

        rv_lerngruppen=(RecyclerView)findViewById(R.id.rv_lerngruppen);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayout.VERTICAL);
        rv_lerngruppen.setLayoutManager(llm);

        adapter = new LerngruppenAdapter(getBaseContext(), LerngruppenList);

        rv_lerngruppen.setAdapter(adapter);

    }

}
