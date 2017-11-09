package com.drarchita.datecalculator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.drarchita.datecalculator.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private Button next;
    private Button between;
    private Button lmp;

    @Override
    protected void init() {
        super.init();
        next = findViewById(R.id.next_button);
        lmp = findViewById(R.id.lmp_button);
        between = findViewById(R.id.between_button);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextDateActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        lmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LMPActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        between.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BetweenDatesActivity.class);
                startActivity(intent);
//                finish();
            }
        });

    }
}
