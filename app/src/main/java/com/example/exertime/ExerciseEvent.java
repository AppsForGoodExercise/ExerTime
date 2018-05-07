package com.example.exertime;

import android.util.Log;


/**
 * Created by robertclark on 4/3/18.
 */

public class ExerciseEvent {

    private String titleofexercise;
    private int timeofexercisestart;
    private int timeofexercisestop;
    Exercise Eventexercise;
    private int dateandtime;

    public ExerciseEvent(int date, Exercise e, int timestart, int timestop) {
        Eventexercise = e;
        timeofexercisestart = timestart;
        timeofexercisestop = timestop;
        dateandtime = date;

    }

    public String getTitleofExercise() {
        return titleofexercise;
    }

    public int getsexercisestarttime() {
        return timeofexercisestart;
    }

    public int gettimeofexercisestop() {

        return timeofexercisestop;
    }
}