package com.drarchita.datecalculator.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
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

import java.util.Calendar;

/**
 * Created by Shagun on 05-11-2017.
 */

public class LMPActivity extends AppCompatActivity {

    private EditText lmpDate;
    private TextView lmpResult;
    private DatePickerDialog datePickerDialog;
    private Button submit;

    protected void init() {
        lmpDate = findViewById(R.id.lmp_date);
        lmpResult = findViewById(R.id.lmp_result_text);
        submit = findViewById(R.id.lmp_submit);
    }

    protected void reset() {
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lmp);

        init();
        reset();

        lmpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTime dateTime = new DateTime();
                final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT);
                if(StringUtils.isNotBlank(lmpDate.getText())) {
                    dateTime = dateTimeFormatter.parseDateTime(String.valueOf(lmpDate.getText()));
                }

                datePickerDialog = new DatePickerDialog(LMPActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                lmpDate.setText(day+"/"+(month+1)+"/"+year);
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
                //calculate lmp
                LocalDate edd = DateUtils.addToDate(String.valueOf(lmpDate.getText()),
                        "9", "0", "7");

                DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT);

                int days = DateUtils.betweenDates(String.valueOf(lmpDate.getText()),
                        dateTimeFormatter.print(new DateTime()));

                double pog = days/7.0;
                String result = "Expected Date of Delivery: " + edd.toString();
                if(pog > 40.0) {
                    result = "Wrong dates, POG is " + (days/7) + " weeks, " + (days%7) + " days";
                } else {
                    result = result + ",\nPOG is " + (days/7) + " weeks, " + (days%7) + " days";
                }

                lmpResult.setText(result);
            }
        });

    }
}
