package com.example.gor.myhomies1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "MAinActivity onCreate");
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "MAinActivity onCreate2");


    }


}
