package com.example.exertime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class nextExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_next_exercise);
       // String ans = bundle.getString("NameofExercise");

        //TextView upcoingtet = findViewById(R.id.upcomingexercise);
        //upcoingtet.setText(ans);
    }
}
