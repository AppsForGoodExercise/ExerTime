package com.example.exertime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button = (Button) findViewById(R.id.profileButton);
    }

    public void saveInfo(View v){
        EditText nameText = findViewById(R.id.enterName);
        String nameString = nameText.toString();

        EditText goalText = findViewById(R.id.enterName);
        String goalString = goalText.toString();

        //Now, this stuff needs to be saved

    }
}