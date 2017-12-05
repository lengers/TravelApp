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
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    String arrivalDate, departureDate, country, quote, email;
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
        final EditText emailEditText = findViewById(R.id.emailEditText);

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
                if (emailEditText.getText().toString().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
                    email = emailEditText.getText().toString();
                    Intent intent = new Intent(Main2Activity.this, SummaryActivity.class);
                    intent.putExtra("EMAIL", email);
                    intent.putExtra("ARRIVALDATE", arrivalDate);
                    intent.putExtra("DEPARTUREDATE", departureDate);
                    intent.putExtra("COUNTRY", country);
                    intent.putExtra("QUOTE", quote);
                    intent.putExtra("PETSNUMBER", petsNumber);
                    intent.putExtra("CHILDRENNUMBER", childrenNumber);
                    intent.putExtra("ADULTSNUMBER", adultsNumber);
                    startActivity(intent);
                } else {
                    Toast.makeText(Main2Activity.this, "Your email address is invalid.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
