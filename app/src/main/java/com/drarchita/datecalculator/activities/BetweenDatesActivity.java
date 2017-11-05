package com.drarchita.datecalculator.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.drarchita.datecalculator.R;
import com.drarchita.datecalculator.utils.Constants;
import com.drarchita.datecalculator.utils.DateUtils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by Shagun on 05-11-2017.
 */

public class BetweenDatesActivity extends AppCompatActivity {

    private EditText startDate;
    private EditText endDate;
    private DatePickerDialog datePickerDialog;
    private Button submit;
    private TextView resultsView;

    protected void init() {
        startDate = findViewById(R.id.start_date);
        endDate = findViewById(R.id.end_date);
        submit = findViewById(R.id.bd_submit);
        resultsView = findViewById(R.id.bd_result_text);
    }

    protected void reset() {

    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd);

        init();
        reset();

        final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTime dateTime = new DateTime();
                if(StringUtils.isNotBlank(endDate.getText())) {
                    dateTime = dateTimeFormatter.parseDateTime(String.valueOf(endDate.getText()));
                }
                datePickerDialog = new DatePickerDialog(BetweenDatesActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                startDate.setText(day+"/"+month+"/"+year);
                            }
                        }, dateTime.getYear(),
                        dateTime.getMonthOfYear()-1,
                        dateTime.getDayOfMonth());
                datePickerDialog.show();
            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTime dateTime = new DateTime();
                if(StringUtils.isNotBlank(endDate.getText())) {
                    dateTime = dateTimeFormatter.parseDateTime(String.valueOf(endDate.getText()));
                }
                datePickerDialog = new DatePickerDialog(BetweenDatesActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                endDate.setText(day+"/"+(month+1)+"/"+year);
                            }
                        }, dateTime.getYear(),
                        dateTime.getMonthOfYear()-1,
                        dateTime.getDayOfMonth());
                datePickerDialog.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String startDateText = String.valueOf(startDate.getText());
                String endDateText = String.valueOf(endDate.getText());

                if(StringUtils.isBlank(startDateText)) {
                    startDateText = dateTimeFormatter.print(new DateTime());
                }
                if(StringUtils.isBlank(endDateText)) {
                    endDateText = dateTimeFormatter.print(new DateTime());
                }

                int days = DateUtils.betweenDates(startDateText, endDateText);
                resultsView.setText("Duration: " + (days/7) + " weeks, " + (days%7) + " days");

            }
        });
    }
}
