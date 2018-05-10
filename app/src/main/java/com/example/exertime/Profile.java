package com.example.exertime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
public class Profile extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button = (Button) findViewById(R.id.profileButton);
    }
}