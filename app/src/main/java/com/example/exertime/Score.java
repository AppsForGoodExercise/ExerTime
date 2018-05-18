package com.example.exertime;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    Button button;
    public static String globalScoreName = "com.exer.score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        SharedPreferences.Editor editor = getSharedPreferences(globalScoreName, MODE_PRIVATE).edit();
        SharedPreferences sharedPreferences = getSharedPreferences(this.globalScoreName, MODE_PRIVATE);
        TextView scoreText = findViewById(R.id.returnScore);

        scoreVal = sharedPreferences.getInt("high_score", 0);
        scoreText.setText("My Score: " + scoreVal);
    }

    private int scoreVal = 0;

    // added by Rahul on 05/10/2018

    /*
     * returns the current streak from a file, increments it by one, returns, and saves that number to the file
     */
    public void addScore(View v){
        SharedPreferences.Editor editor = getSharedPreferences(globalScoreName, MODE_PRIVATE).edit();
        SharedPreferences sharedPreferences = getSharedPreferences(this.globalScoreName, MODE_PRIVATE);

        scoreVal = sharedPreferences.getInt("high_score", 0);
        scoreVal++;
        TextView scoreText = findViewById(R.id.returnScore);
        scoreText.setText("My Score: " + scoreVal);
        editor.putInt("high_score", scoreVal);
        editor.commit();

    }

}
