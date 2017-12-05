package com.example.octavian.travelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class SummaryActivity extends AppCompatActivity {

    String arrivalDate, departureDate, country, quote, email;
    int petsNumber, childrenNumber, adultsNumber, cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intent = getIntent();
        Bundle bin = intent.getExtras();
        arrivalDate = (String) bin.get("ARRIVALDATE");
        departureDate = (String) bin.get("DEPARTUREDATE");
        country = (String) bin.get("COUNTRY");
        quote = (String) bin.get("QUOTE");
        petsNumber = (int) bin.get("PETSNUMBER");
        childrenNumber = (int) bin.get("CHILDRENNUMBER");
        adultsNumber = (int) bin.get("ADULTSNUMBER");
        email = (String) bin.get("EMAIL");

        cost = new Random().nextInt(Integer.parseInt(quote));
        System.out.println(cost);

        ((TextView) findViewById(R.id.countryTextView)).setText(country);
        ((TextView) findViewById(R.id.adultsTextView)).setText(String.valueOf(adultsNumber));
        ((TextView) findViewById(R.id.childrenTextView)).setText(String.valueOf(childrenNumber));
        ((TextView) findViewById(R.id.petsViewText)).setText(String.valueOf(petsNumber));
        ((TextView) findViewById(R.id.arrivalDateTextView)).setText(arrivalDate);
        ((TextView) findViewById(R.id.departureDateTextView)).setText(departureDate);
        ((TextView) findViewById(R.id.costTextView)).setText(String.valueOf(cost));
        ((TextView) findViewById(R.id.emailTextView)).setText(email);

    }
}
