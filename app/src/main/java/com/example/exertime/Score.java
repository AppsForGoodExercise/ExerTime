package com.example.exertime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }

    private int scoreVal = 0;

    public void addScore(View v){
        scoreVal++;
        TextView scoreText = findViewById(R.id.returnScore);
        scoreText.setText("Your Score: " + scoreVal);

    }

}
