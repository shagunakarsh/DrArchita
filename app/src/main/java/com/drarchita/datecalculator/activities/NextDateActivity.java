package com.drarchita.datecalculator.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

/**
 * Created by Shagun on 05-11-2017.
 */

public class NextDateActivity extends AppCompatActivity {

    private EditText ndDate;
    private EditText ndDays;
    private EditText ndWeeks;
    private TextView ndResult;
    private DatePickerDialog datePickerDialog;
    private Button submit;
    private Toolbar toolbar;

    protected void init() {

        ndDate = findViewById(R.id.nd_date);
        ndWeeks = findViewById(R.id.nd_weeks);
        ndDays = findViewById(R.id.nd_days);
        ndResult = findViewById(R.id.nd_result_text);
        submit = findViewById(R.id.nd_submit);
        toolbar = findViewById(R.id.nd_toolbar);
    }


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nd);

        init();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT);

        ndDate.setShowSoftInputOnFocus(false);
        ndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTime dateTime = new DateTime();
                if(StringUtils.isNotBlank(ndDate.getText())) {
                    dateTime = dateTimeFormatter.parseDateTime(String.valueOf(ndDate.getText()));
                }
                datePickerDialog = new DatePickerDialog(NextDateActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                ndDate.setText(day+"/"+(month+1)+"/"+year);
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

                String ndDateText = String.valueOf(ndDate.getText());
                if(StringUtils.isBlank(ndDateText)) {
                    ndDateText = dateTimeFormatter.print(new DateTime());
                }
                String ndWeeksText = String.valueOf(ndWeeks.getText());
                if(StringUtils.isBlank(ndWeeks.getText())) {
                    ndWeeksText = "0";
                }
                String ndDaysText = String.valueOf(ndDays.getText());
                if(StringUtils.isBlank(ndDaysText)) {
                    ndDaysText = "0";
                }
                LocalDate nextDate = DateUtils.addToDate(ndDateText, "0",
                        ndWeeksText, ndDaysText);
                String ndDayOfWeek = nextDate.dayOfWeek().getAsText(Locale.US);
                ndResult.setText("Next Date: " + dateTimeFormatter.print(nextDate) + " (" + ndDayOfWeek + ")");
            }
        });
    }
}
