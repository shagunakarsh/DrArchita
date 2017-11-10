package com.drarchita.datecalculator.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.drarchita.datecalculator.R;
import com.drarchita.datecalculator.adapters.RecyclerViewAdapter;

/**
 * Created by Shagun on 11-11-2017.
 */

public class RecyclerActivity extends BaseActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void init() {
        super.init();
        recyclerView = findViewById(R.id.main_recycler_view);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);
        init();

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(new String[]{"hello", "world"});
        recyclerView.setAdapter(adapter);
    }
}
