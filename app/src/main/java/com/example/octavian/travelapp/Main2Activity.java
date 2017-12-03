package com.example.octavian.travelapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    String arrivalDate, departureDate, country, quote;
    int petsNumber = 0;
    int childrenNumber = 0;
    int adultsNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Bundle bin = intent.getExtras();
        arrivalDate = (String) bin.get("ARRIVALDATE");
        departureDate = (String) bin.get("DEPARTUREDATE");
        country = (String) bin.get("COUNTRY");
        quote = (String) bin.get("QUOTE");

        final EditText childrenEditText = findViewById(R.id.childrenEditText);
        final EditText petsEditText =  findViewById(R.id.petsEditText);
        final EditText adultsEditText = findViewById(R.id.adultsEditText);

        ((CheckBox) findViewById(R.id.checkBox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    petsEditText.setEnabled(false);
                    petsNumber = Integer.parseInt(childrenEditText.getText().toString());
                    petsEditText.setText(String.valueOf(petsNumber));
                } else {
                    petsEditText.setEnabled(true);
                    petsNumber = Integer.parseInt(petsEditText.getText().toString());
                }
            }
        });

        ((Button) findViewById(R.id.summaryButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adultsNumber = Integer.parseInt(adultsEditText.getText().toString());
                childrenNumber = Integer.parseInt(childrenEditText.getText().toString());

                Intent intent = new Intent(Main2Activity.this, SummaryActivity.class);
                intent.putExtra("ARRIVALDATE", arrivalDate);
                intent.putExtra("DEPARTUREDATE", departureDate);
                intent.putExtra("COUNTRY", country);
                intent.putExtra("QUOTE", quote);
                intent.putExtra("PETSNUMBER", petsNumber);
                intent.putExtra("CHILDRENNUMBER", childrenNumber);
                intent.putExtra("ADULTSNUMBER", adultsNumber);
                startActivity(intent);
            }
        });
    }
}
