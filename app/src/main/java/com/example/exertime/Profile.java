package com.example.exertime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.widget.EditText;

public class Profile extends AppCompatActivity {
    private static final String FILE_NAME_1 = "name.txt";
    private static final String FILE_NAME_2 = "goal.txt";

    EditText mName;
    EditText mGoal;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button = (Button) findViewById(R.id.profileButton);
        mName = findViewById(R.id.enterName);
        mGoal = findViewById(R.id.enterGoal);

    }

    public void save(View v) {

        String Nametext = mName.getText().toString();
        String Goaltext = mGoal.getText().toString();

        FileOutputStream fileout = null;

        try {
            fileout = openFileOutput(FILE_NAME_1, MODE_PRIVATE);
            fileout.write(Nametext.getBytes());
            fileout = openFileOutput(FILE_NAME_2, MODE_PRIVATE);
            fileout.write(Goaltext.getBytes());

            mName.getText().clear();
            mGoal.getText().clear();

            Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();

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


    public void load(View v) {

        FileInputStream filein_1 = null;
        FileInputStream filein_2 = null;

        try {
            filein_1 = openFileInput(FILE_NAME_1);
            InputStreamReader reader = new InputStreamReader(filein_1);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder sbuilder = new StringBuilder();
            String text;

            while ((text = buffer.readLine()) != null) {
                sbuilder.append(text).append("\n");
            }

            mName.setText(sbuilder.toString());

            filein_2 = openFileInput(FILE_NAME_2);
            reader = new InputStreamReader(filein_2);
            buffer = new BufferedReader(reader);
            sbuilder = new StringBuilder();

            while ((text = buffer.readLine()) != null) {
                sbuilder.append(text).append("\n");
            }

            mGoal.setText(sbuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveInfo(View v){
        EditText nameText = findViewById(R.id.enterName);
        String nameString = nameText.toString();

        EditText goalText = findViewById(R.id.enterName);
        String goalString = goalText.toString();

        //Now, this stuff needs to be saved

    }
}