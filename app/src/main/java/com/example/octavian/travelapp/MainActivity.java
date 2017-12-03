package com.example.octavian.travelapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public String arrivalDate, departureDate;
    public String country, quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String test;

        final DatePickerDialog arrivalDatePickerDialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.e("DEBUG", "arrival");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                arrivalDate = df.format(new GregorianCalendar(year, month-1, dayOfMonth).getTime());
                ((TextView) findViewById(R.id.arrivalDateShow)).setText(arrivalDate);
            }
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        final DatePickerDialog departureDatePickerDialog = new DatePickerDialog(
                this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.e("DEBUG", "departure");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                departureDate = df.format(new GregorianCalendar(year, month-1, dayOfMonth).getTime());
                ((TextView) findViewById(R.id.departureDateShow)).setText(departureDate);
            }
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));


        ((Button) findViewById(R.id.arrivalDateButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrivalDatePickerDialog.show();
            }
        });
        ((Button) findViewById(R.id.departureDateButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                departureDatePickerDialog.show();
            }
        });

        Spinner countrySpinner = (Spinner) findViewById(R.id.countrySpinner);
        Locale[] locales = Locale.getAvailableLocales();
        final ArrayList<String> countries = new ArrayList<String>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length()>0 && !countries.contains(country)) {
                countries.add(country);
            }
        }
        Collections.sort(countries);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries);
        countrySpinner.setAdapter(adapter);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ((Button) findViewById(R.id.nextButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quote = ((EditText) findViewById(R.id.quoteEdit)).getText().toString();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("ARRIVALDATE", arrivalDate);
                intent.putExtra("DEPARTUREDATE", departureDate);
                intent.putExtra("COUNTRY", country);
                intent.putExtra("QUOTE", quote);
                startActivity(intent);
            }
        });
    }


}
