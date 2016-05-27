package com.example.patrick.studienplaner;

/**
 * Created by Patrick on 09.05.2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.patrick.studienplaner.model.LG_DetailModels.LG_DetailCardContent;

import java.util.List;

public class LG_DetailActivity extends Activity{

    private List<LG_DetailCardContent> LGDetailList = LG_DetailCardContent.createData();
    private LG_DetailRecyclerViewAdapter adapter;
    private RecyclerView rv_lerngruppen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_lerngruppen);

        rv_lerngruppen=(RecyclerView)findViewById(R.id.rv_lerngruppen);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayout.VERTICAL);
        rv_lerngruppen.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LG_DetailRecyclerViewAdapter(getBaseContext(), LGDetailList);

        rv_lerngruppen.setAdapter(adapter);

    }

}
