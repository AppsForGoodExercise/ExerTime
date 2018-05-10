package com.example.exertime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by robertclark on 3/28/18.
 */

public class Day {
    public List<OurEvent> events;
    public int size;
    public int date;
    public List<Exercise> masterlist;
    public List<fifteenminutezone> fifteens = new ArrayList<fifteenminutezone>();

    public Day() {

    }

    public Day( int date, ArrayList<OurEvent> listofevents,ExerciseMasterList listofexercisess) {

        events = new ArrayList<OurEvent>();
        events = listofevents;
        List<ExerciseEvent> daysexerices = new ArrayList<ExerciseEvent>();

        Random randy = new Random();





        for (int p = 0; p <= 96; p++) {
            fifteenminutezone fifteener = new fifteenminutezone(p * 15, false, false, null);
            fifteens.add(fifteener);
        }
        int u;
        int m;
        int q;
        int lengthofevent;
        int checker=0;
        int yep=0;
        for (int h = 0; h <= listofevents.size(); h++){
            //Convert to minutes
             u=listofevents.get(h).getstarttime();
             m=u%60;
             q=(u/100)*60+m;




             for(int v = 0; v<=15;v--){
                 if((q-v)%15==0){
                        fifteens.get((q-v)/15).setevent(true);

                        checker = q-v;
                        break;
                 }
             }
            lengthofevent=listofevents.get(h).getlengthoftime()/15;

            for(yep=0;yep<=lengthofevent;yep++){
                fifteens.get((checker)/15+yep).setevent(true);
            }


        }






        int x = randy.nextInt(listofexercisess.getmasterlist().size());
        int y = randy.nextInt(64);
        fifteenminutezone teen;
        for (int k = 0; k <= 4; k++) {
            y = randy.nextInt(38) + 40;//NOTE THIS IS WEHRE WE CAN ADD AN ADJUSTMENT
            System.out.println("Exercise set");
             x = randy.nextInt(listofexercisess.getmasterlist().size());
            if (!fifteens.get(y).isthereanevent() || !fifteens.get(y).isthereanexercisehere()) {
                System.out.println("Setting an exercise");
                fifteens.get(y).exercisepresent(true);
                teen = fifteens.get(y);
                teen.setexercise(listofexercisess.getexercixe(x));
                System.out.println(listofexercisess.getexercixe(x).getname());
            }else k--;

        }

        for (int r =0; r<fifteens.size();r++){
            if(fifteens.get(r).isthereanexercisehere()){
        System.out.println(fifteens.get(r).getExercise().getname());}
        }



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
    public String getalltheexercises(){
        String list="";
        for(int p =0; p<96;p++){
            if(fifteens.get(p).isthereanexercisehere()){
                System.out.println("Hi");
                list = list+""+fifteens.get(p).getExercise().getname();
            }

        }return list;
    }
    public String getnextexercise(int time) {
        System.out.println("Getting the next Exercise");

        for (int i = 0; i < 360; i++) {
            for (int x = 0; x < fifteens.size(); x++) {
                if (i % 15 == 0) {
                    if (fifteens.get(x).isthereanexercisehere()) {
                        System.out.println("I am working");
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

