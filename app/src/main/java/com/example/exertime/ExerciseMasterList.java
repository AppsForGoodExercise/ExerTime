package com.example.exertime;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertclark on 4/4/18.
 */

public class ExerciseMasterList {

    ArrayList<Exercise> masterlist;

    /** Exercise Master List constructor.
     *
     */
    public ExerciseMasterList(){

        masterlist = new ArrayList<Exercise>();


    }

    /**
     * adds an exercise to the masterlist
     * @param e
     */
    public void addexercise (Exercise e){
        masterlist.add(e);

    }

    /**getmasterlist
     * returns the masterlist of exercises
     * @return masterlist
     */
    public ArrayList getmasterlist (){
        return masterlist;

    }

    /**getexercixe
     * returns an exercise
     * @param p
     * @return the exercise form the masterlist
     */
    public Exercise getexercixe (int p){
        return masterlist.get(p);

    }


}

