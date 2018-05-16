package com.example.exertime;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;
import static android.widget.Toast.*;
import android.content.Context;

/**
 * Created by robertclark on 3/28/18.
 */

public class Day {
    public List<OurEvent> events;
    public int size;
    public int date;
    public List<Exercise> masterlist;
    public List<fifteenminutezone> fifteens = new ArrayList<fifteenminutezone>();
    List<ExerciseEvent> daysexerices = new ArrayList<ExerciseEvent>();

    private Context context;
    private static final String FILE_NAME_T = "times.txt";

    /**
     *  Empty day constructor
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
     * this makes the exercise list.
     */
    public void makeExerciseList(){
        for (int r =0; r<fifteens.size();r++){
            if(fifteens.get(r).isthereanexercisehere()){

                int zone = r%4;
                String hrMlt = Integer.toString(r/4);
                if(r/4>=0 && r/4<=9)
                    hrMlt = "0"+hrMlt;

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

              ArrayList<String> listForNoti = new ArrayList<>();
                listForNoti.add(hrMlt+min);

                FileOutputStream fileout = null;

                try {
                    fileout = context.openFileOutput(FILE_NAME_T, MODE_PRIVATE);
                    for(int j=0; j<listForNoti.size(); j++) {
                        fileout.write(listForNoti.get(j).getBytes());
                    }


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
        }
    }

    /** getexercises
     * return an arraylist of exercises
     * @return
     */
    public List<ExerciseEvent> getExerciseList() {
        return daysexerices;
    }

    public OurEvent geteventlocation(int location){
        return events.get(location);
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
     *
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








    /**public OurEvent geteventtitle(String titleofevent){
        boolean checker;
        OurEvent nevent=null;
        for( int i = 0; i<=events.size(); i++ ) {
            if(titleofevent.equals(events.get(i).getTitleofEvent())){
                checker = true;
                nevent = events.get(i);
                break;
            }

        }

        return nevent;
    }**/

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

    public void fifteenminutefixers(int start, int end){

    }

    public int getDate(){
        return date;
    }

    public int timebetweenevents(int j){
        if(events.size()!=0){

            return  (events.get(j+1).getstarttime()-events.get(j).gettimeofeventstop());}
        return 1440;
    }

}

