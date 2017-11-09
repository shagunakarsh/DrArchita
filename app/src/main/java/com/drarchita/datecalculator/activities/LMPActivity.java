package com.drarchita.datecalculator.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
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

/**
 * Created by Shagun on 05-11-2017.
 */

public class LMPActivity extends BaseActivity {

    private static final double POG_THRESHOLD = 40.0;
    private EditText lmpDate;
    private TextView lmpResult;
    private DatePickerDialog datePickerDialog;
    private Button submit;

    @Override
    protected void init() {
        super.init();
        lmpDate = findViewById(R.id.lmp_date);
        lmpResult = findViewById(R.id.lmp_result_text);
        submit = findViewById(R.id.lmp_submit);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lmp);
        init();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(Constants.DATE_FORMAT);

        lmpDate.setShowSoftInputOnFocus(false);
        lmpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateTime dateTime = new DateTime();
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
                String lmpDateText = String.valueOf(lmpDate.getText());
                if(StringUtils.isBlank(lmpDateText)) {
                    lmpDateText = dateTimeFormatter.print(new DateTime());
                }
                LocalDate edd = DateUtils.addToDate(lmpDateText,
                        "9", "0", "7");

                int days = DateUtils.betweenDates(lmpDateText,
                        dateTimeFormatter.print(new DateTime()));

                double pog = days/7.0;
                String result = "Expected Date of Delivery: " + edd.toString();
                if(pog > POG_THRESHOLD) {
                    result = "Wrong dates, POG is " + (days/7) + " weeks, " + (days%7) + " days";
                } else {
                    result = result + ",\nPOG is " + (days/7) + " weeks, " + (days%7) + " days";
                }

                lmpResult.setText(result);
            }
        });

    }
}
