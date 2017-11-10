package com.drarchita.datecalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.drarchita.datecalculator.R;

public class MainCardActivity extends BaseActivity {

    private static final String TAG = "MainCardActivity";
    private CardView next;
    private CardView between;
    private CardView lmp;

    @Override
    protected void init() {
        super.init();
        next = findViewById(R.id.card_nd);
        lmp = findViewById(R.id.card_lmp);
        between = findViewById(R.id.card_bd);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_main);
        init();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainCardActivity.this, NextDateActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        lmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainCardActivity.this, LMPActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        between.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainCardActivity.this, BetweenDatesActivity.class);
                startActivity(intent);
//                finish();
            }
        });

    }
}
