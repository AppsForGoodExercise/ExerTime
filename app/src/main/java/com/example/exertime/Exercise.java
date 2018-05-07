package com.example.exertime;

/**
 * Created by robertclark on 4/4/18
 */

public class Exercise {
    String title;
    String difficulty;
    private int numberoftimes;
    private  int amountoftime;
    private int caloric;

    public Exercise(String name, String intensity, int reps, int time, int calories){
        title = name;
        difficulty = intensity;
        numberoftimes = reps;
        amountoftime = time;
        caloric = calories;

    }


    public String getname(){
        return title;
    }

}
