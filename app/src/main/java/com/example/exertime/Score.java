package com.example.exertime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Integer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Score extends AppCompatActivity {

    Button button;
    private int scoreVal=0;

    private static final String FILE_NAME_S = "score.txt";
    FileInputStream filein_s = null;

    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreText = findViewById(R.id.returnScore);
        //save();
        //load();

    }

    public void addScore(View v){
        scoreVal++;
        scoreText.setText("My Streak: " + scoreVal);
        save();

    }

   public void save() {

       String scoreT = Integer.toString(scoreVal);

        FileOutputStream fileout = null;

        try {
            fileout = openFileOutput(FILE_NAME_S, MODE_PRIVATE);
            fileout.write(scoreT.getBytes());

            //Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileout != null) {
                try {
                    fileout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void load() {

        FileInputStream filein_1 = null;

        try {
            filein_1 = openFileInput(FILE_NAME_S);
            InputStreamReader reader = new InputStreamReader(filein_1);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder sbuilder = new StringBuilder();
            String text;

            while ((text = buffer.readLine()) != null) {
                sbuilder.append(text).append("\n");
            }

            scoreText.setText("My Streak: " + sbuilder.toString());
            scoreVal = Integer.parseInt(sbuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
