package com.example.exertime;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Home extends AppCompatActivity {

    public Day day = new Day();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Date g = Calendar.getInstance().getTime();
        System.out.println("Current time => " + g);

        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date

        int x = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        calendar.get(Calendar.HOUR);        // gets hour in 12h format
        String p = calendar.get(Calendar.DAY_OF_MONTH)+""+calendar.get(Calendar.MONTH)+""+calendar.get(Calendar.YEAR);
        int y = calendar.get(Calendar.MINUTE);
        int numberday = Integer.parseInt(p);
        //Robert's Code
        InputStream is = (InputStream) getResources().openRawResource(R.raw.exerciselist);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = "";
        ExerciseMasterList masterlists = new ExerciseMasterList();

        //sets the time of the notification
        startNotification(8,30);


        try {

            while ((line = reader.readLine()) != null) {
                //Split line by ","

                String[] fields = line.split(",");
                Exercise exercise = new Exercise(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]), Integer.parseInt(fields[4]));
                masterlists.addexercise(exercise);
            }
        } catch (IOException e) {
            Log.e("MainActivity", "Error reading data from file on line " + line);
        }
        for (int r =0; r<masterlists.getmasterlist().size();r++){
            System.out.println(masterlists.getexercixe(r).getname());
        }


        day = new Day(numberday, null, masterlists);




        //profile button
        Button butprofile = findViewById(R.id.profileButton);
        butprofile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                profile();
            }
        });

        //today's score button
        Button scorebut = findViewById(R.id.scoreBut);
        scorebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todayscore();
            }
        });

        //next exercise button
        Button nextEx = findViewById(R.id.dateButton);
        nextEx.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                nextExercise();
            }
        });


       // exercise List button
        Button exerList = findViewById(R.id.exerciseList);
        exerList.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                exerciseList();
            }
        });
    }



    //connecting profile button
    public void profile() {
        Intent pro = new Intent(this, Profile.class);
        startActivity(pro); //connects pages

    }

    //next exercise
    public void nextExercise() {
        Intent exer = new Intent(this, MainActivity.class);
        Log.d("MainActivity", "hi " );

        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        int x = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        calendar.get(Calendar.HOUR);        // gets hour in 12h format
        calendar.get(Calendar.MONTH);
        int y = calendar.get(Calendar.MINUTE);

        int time = x*60+y;

        Log.d("Home", "before answer string");
        //problem:
        String  answer = ""+day.getalltheexercises()+"";
        Log.d("Home", "after answer string");

        exer.putExtra("NameofExercise", answer);

        startActivity(exer);
    }

    public void todayscore() {
        Intent tod = new Intent(this, Score.class);
        startActivity(tod); //connects with two pages
    }

    public void exerciseList() {
        Intent exerList= new Intent(this, exercisecompleteList.class);
        startActivity(exerList); //connects the pages
    }



    public void hamburger (View V){
        Log.e("MainActivity", "hi " );

        System.out.println("HEYYEAG");
        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date



        int x = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        calendar.get(Calendar.HOUR);        // gets hour in 12h format
        calendar.get(Calendar.MONTH);
        int y = calendar.get(Calendar.MINUTE);

        int time = x*60+y;

        String  answer = ""+day.getalltheexercises()+"";


        Intent intent = new Intent(this, NewExerciseActivity.class);

        intent.putExtra("Hi", answer);
        startActivity(intent);

    }


//notification code
  public void startNotification(int startHour, int startMinute){
      Calendar c = Calendar.getInstance(); //gets date
      long rightNow = c.getTimeInMillis(); //gets the time
      Log.d("noti",String.valueOf(rightNow)); //real time

      AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
      c.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH),startHour,startMinute,0);
      long timeToNotify = c.getTimeInMillis(); //gets the real time
      Intent intent = new Intent (this, AlarmReceiver.class); //connects the classes
      PendingIntent broadcast = PendingIntent.getBroadcast(this,0,intent,0);
      alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),AlarmManager.INTERVAL_DAY,broadcast); //repeats the notification daily

  }

}