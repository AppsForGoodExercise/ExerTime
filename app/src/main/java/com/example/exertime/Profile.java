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

public class Profile extends AppCompatActivity {
    //files to save to
    private static final String FILE_NAME_1 = "name.txt";
    private static final String FILE_NAME_2 = "goal.txt";

    //edit text boxes (user input)
    EditText mName;
    EditText mGoal;

    //Button (for save)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //find text boxes and button in xml and assign to variables
        button = (Button) findViewById(R.id.profileButton);
        mName = findViewById(R.id.enterName);
        mGoal = findViewById(R.id.enterGoal);

        //load profile information from file
        load();

    }

    //saves profile information
    public void save(View v) {

        String Nametext = mName.getText().toString();
        String Goaltext = mGoal.getText().toString();

        FileOutputStream fileout = null;

        try {
            fileout = openFileOutput(FILE_NAME_1, MODE_PRIVATE);
            fileout.write(Nametext.getBytes());
            fileout = openFileOutput(FILE_NAME_2, MODE_PRIVATE);
            fileout.write(Goaltext.getBytes());

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

    //returns information from file and sets the edit text boxes to that information
    public void load() {

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
}



