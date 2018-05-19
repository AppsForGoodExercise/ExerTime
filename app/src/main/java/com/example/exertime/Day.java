package com.example.exertime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by robertclark on 3/28/18.
 */

public class Day {
    public List<OurEvent> events;
    public int date;
    public List<fifteenminutezone> fifteens = new ArrayList<fifteenminutezone>();
    List<ExerciseEvent> daysexerices = new ArrayList<ExerciseEvent>();

    /**
     *  Empty day constructor (default)
     */
    public Day() {

    }

    /**
     * Creates a day object.
     * @param date
     * @param listofevents
     * @param listofexercisess
     */
    public Day( int date, ArrayList<OurEvent> listofevents,ExerciseMasterList listofexercisess) {

        events = new ArrayList<OurEvent>();
        events = listofevents;

        Random randy = new Random();

        for (int p = 0; p < 96; p++) {
            fifteenminutezone fifteener = new fifteenminutezone(p * 15, false, false, null);
            fifteens.add(fifteener);
        }

        int u;
        int m;
        int q;
        int lengthofevent;
        int checker=0;
        int yep=0;
        if(listofevents!=null) {
            for (int h = 0; h < listofevents.size(); h++) {
                //Convert to minutes
                u = listofevents.get(h).getstarttime();
                m = u % 100;
                q = (u / 100) * 60 + m;


                for (int v = 0; v <= 15; v--) {
                    if ((q - v) % 15 == 0) {
                        fifteens.get((q - v) / 15).setevent(true);
                        System.out.print("WAZZUP");
                        checker = q - v;
                        break;
                    }
                }
                lengthofevent = listofevents.get(h).getlengthoftime() / 15;
                System.out.println(lengthofevent);
                for (yep = 0; yep <= lengthofevent+1; yep++) {
                    fifteens.get((checker) / 15 + yep).setevent(true);
                }
            }
        }






        int x = randy.nextInt(listofexercisess.getmasterlist().size());
        int y = randy.nextInt(64);
        fifteenminutezone teen;
        for (int k = 0; k <= 4; k++) {
            y = randy.nextInt(38) + 40;//NOTE THIS IS WEHRE WE CAN ADD AN ADJUSTMENT
            //System.out.println("Exercise set");
             x = randy.nextInt(listofexercisess.getmasterlist().size());
            if (!fifteens.get(y).isthereanevent() && !fifteens.get(y).isthereanexercisehere()) {
                //System.out.println("Setting an exercise");
                fifteens.get(y).exercisepresent(true);
                teen = fifteens.get(y);
                teen.setexercise(listofexercisess.getexercixe(x));
                System.out.println(listofexercisess.getexercixe(x).getname());
            }else k--;

        }

    }

    /**
     * This makes the exercise list.
     * Exercises are added to an exercise list "daysexercises" as ExerciseEvents.
     * Added with the time as a string giving the 12 hour time.
     */
    public void makeExerciseList(){
        for (int r =0; r<fifteens.size();r++){
            if(fifteens.get(r).isthereanexercisehere()){

                int zone = r%4;

                String hr = Integer.toString((r/4)%12);
                if(hr.equals("0"))
                    hr = "12";

                String min;
                String ampm = "";
                switch (zone) {
                    case 0:
                        min = "00";
                        break;
                    case 1:
                        min = "15";
                        break;
                    case 2:
                        min = "30";
                        break;
                    case 3:
                        min = "45";
                        break;
                    default:
                        min = "00";
                        break;
                }

                if ((r/4)>=0 && (r/4)<12)
                    ampm = "AM";
                else
                    ampm = "PM";

                ExerciseEvent exerEvent = new ExerciseEvent(fifteens.get(r).getExercise().getname(), (hr+":"+min+" "+ampm));
                daysexerices.add(exerEvent);

            }
        }
    }

    /** getexercises
     * return an arraylist of exercises
     * @return arraylist of ExerciseEvents
     */
    public List<ExerciseEvent> getExerciseList() {
        return daysexerices;
    }

    public OurEvent geteventstartime(int timeofbeginning){
        boolean checker;
        OurEvent nevent=null;
        for( int i = 0; i<=events.size(); i++ ) {
            if(timeofbeginning == events.get(i).getstarttime()){
                checker = true;
                nevent = events.get(i);
                break;
            }

        }

        return nevent;
    }


    /** geteventstoptime
     *  Gets an event bystop time.
     * @param timeofbeginning
     * @returnan Ourevent object
     */
    public OurEvent geteventstoptime(int timeofbeginning){
        boolean checker;
        OurEvent nevent=null;
        for( int i = 0; i<=events.size(); i++ ) {
            if(timeofbeginning == events.get(i).gettimeofeventstop()){
                checker = true;
                nevent = events.get(i);
                break;
            }

        }

        return nevent;
    }

    /**
     * getalltheexercises
     * Gets a stirng that is a list of all the exercises
     * @return a list of all the exercises
     */
    public String getalltheexercises(){
        String list="";


        for(int p =0; p<96;p++){

            //This line does not work
            if(fifteens.get(p).isthereanexercisehere()){
                list = list+""+fifteens.get(p).getExercise().getname();
            }

        }
        return list;
    }

    /**
     * getnextexercise
     * @param time
     * @return the name of the exercise
     */
    public String getnextexercise(int time) {
        System.out.println("Getting the next Exercise");

        for (int i = 0; i < 360; i++) {
            for (int x = 0; x < fifteens.size(); x++) {
                if (i % 15 == 0) {
                    if (fifteens.get(x).isthereanexercisehere()) {
                        return fifteens.get(x).getExercise().getname();

                    } else return "None";
                }
            }

        }
        return "None";
    }



    /**
     *  addevent adds an event
     * @param titleofevent
     * @param starttime
     * @param endtime
     */
    public void addevent(String titleofevent,int starttime, int endtime){
        OurEvent addevent= new OurEvent(starttime,endtime);
        events.add(addevent);
    }

    public boolean eventat(int starttime, int stoptime) {
        boolean checker=false;
        for(int i = 0;i<=events.size();i++){
            if(events.get(i).getstarttime()>=starttime||events.get(i).gettimeofeventstop()<=stoptime) {
                checker=true;
                break;

            }
            else if(events.get(i).gettimeofeventstop()<=stoptime&&events.get(i).gettimeofeventstop()>=starttime) {
                checker=true;
                break;

            }
            else checker = false;}

        return checker;

    }



    /**Get Date
     * Gets the date of the project and tof the day object
     *
     * @return date in integer form
     */
    public int getDate(){
        return date;
    }

    /**
     * timebetweenevents
     * @param j an event
     * @return the time between events
     */
    public int timebetweenevents(int j){
        if(events.size()!=0){

            return  (events.get(j+1).getstarttime()-events.get(j).gettimeofeventstop());}
        return 1440;
    }

}

