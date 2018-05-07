package com.example.exertime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by robertclark on 4/26/18.
 */

public class NewExerciseActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_next_exercise);


        //Get the Intent that started this activity and extract the data
        Bundle bundle = getIntent().getExtras();

        String ans = bundle.getString("Hi");

        TextView upcoingtet = findViewById(R.id.upcomingexercise);
        upcoingtet.setText("Hi");
    }
}
