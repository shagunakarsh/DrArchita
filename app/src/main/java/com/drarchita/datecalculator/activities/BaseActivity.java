package com.drarchita.datecalculator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.drarchita.datecalculator.R;

/**
 * Created by Shagun on 10-11-2017.
 */

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;

    protected void init() {
        toolbar = findViewById(R.id.base_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);

        return true;
    }
}
