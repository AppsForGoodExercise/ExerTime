package com.example.exertime;

/**
 * Created by robertclark on 4/4/18
 */

public class Exercise {
    String title;
    String difficulty;
    private int numberoftimes;
    private  int amountoftime;
    private int calorie;

    public Exercise(String name, String intensity, int reps, int time, int calories){
        title = name;
        difficulty = intensity;
        numberoftimes = reps;
        amountoftime = time;
        calorie = calories;

    }

    /**Gets the name of an exercise
     *
     * @return the title of an exercise
     */
    public String getname(){
        return title;
    }

}
