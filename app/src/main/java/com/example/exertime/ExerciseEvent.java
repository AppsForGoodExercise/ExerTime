package com.example.exertime;

import android.util.Log;


/**
 * Created by robertclark on 4/3/18.
 */

public class ExerciseEvent {

    private String titleofexercise;
    private int timeofexercisestart;
    private String startTimeString;
    private int timeofexercisestop;
    Exercise Eventexercise;
    private int dateandtime;

    /**
     * Exercise event constructor
     * @param date
     * @param e
     * @param timestart
     * @param timestop
     */
    public ExerciseEvent(int date, Exercise e, int timestart, int timestop) {
        Eventexercise = e;
        timeofexercisestart = timestart;
        timeofexercisestop = timestop;
        dateandtime = date;
    }

    /**
     * Other exercise Event constructor
     * @param exerName
     * @param timestart
     */
    public ExerciseEvent(String exerName, String timestart){
        startTimeString = timestart;
        titleofexercise = exerName;

    }

    /**
     * returns the title of an exercise
     * @return titleofexercise
     */
    public String getTitleofExercise() {
        return titleofexercise;
    }

    /**
     * getStartTimeString
     * return the starttime of an event.
     * @return
     */

    public String getStartTimeString() { return startTimeString; }
}