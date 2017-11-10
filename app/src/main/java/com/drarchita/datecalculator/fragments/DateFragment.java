package com.drarchita.datecalculator.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drarchita.datecalculator.R;

/**
 * Created by Shagun on 11-11-2017.
 * Sample fragment
 */

public class DateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        return layoutInflater.inflate(R.layout.date_fragment, viewGroup, false);
    }
}
