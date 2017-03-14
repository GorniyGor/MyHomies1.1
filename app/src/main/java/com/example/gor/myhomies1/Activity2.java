package com.example.gor.myhomies1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView name;
    private TextView surname;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        name = (TextView) findViewById(R.id.Name);
        surname = (TextView) findViewById(R.id.Surname);
        date = (TextView) findViewById(R.id.Date);

        name.setText(getIntent().getStringExtra("name"));
        surname.setText(getIntent().getStringExtra("surname"));
        date.setText(getIntent().getStringExtra("date"));


    }
}
