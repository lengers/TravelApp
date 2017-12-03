package com.example.octavian.travelapp;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by octavian on 01.12.17.
 */

public class ItemSelectedListener implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String selected = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}