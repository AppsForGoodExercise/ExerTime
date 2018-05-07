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


    public Day(){

    }

    public Day( int date, ArrayList<OurEvent> listofevents,ExerciseMasterList listofexercisess) {

        events = new ArrayList<OurEvent>();
        events = listofevents;
        List<ExerciseEvent> daysexerices = new ArrayList<ExerciseEvent>();

        Random randy = new Random();


        /**if(titlesoe.length==starttimes.length) {
         for(int p = 0;p<stoptimes.length;p++)
         for(int i=0;i<=titlesoe.length-1;i++) {
         Event newevent = new Event(titlesoe[i],starttimes[p],stoptimes[i]);
         events.add(newevent);

         }
         }

         //Exercise Generator of list
         List <Integer> timebetween = new ArrayList<Integer>();
         if(listofevents.size()==0){
         timebetween.add(1440);
         }else if
         for(int j = 0;j<listofevents.size()-1;j++){
         timebetween.add(this.timebetweenevents(j));
         }
         Random randy = new Random(1);

         for(int j = 0;j<timebetween.size();j++){
         if(timebetween.get(j)<=15){
         int x = randy.nextInt(masterlist.size());
         ExerciseEvent eve = new ExerciseEvent(masterlist.get(x),1400,1400);
         daysexerices.add(eve);

         }
         else if(timebetween.get(j)<=15){
         int x = randy.nextInt(masterlist.size());
         ExerciseEvent eve = new ExerciseEvent(masterlist.get(x),1400,1400);
         daysexerices.add(eve);

         }
         else if(timebetween.get(j)<=15){
         int x = randy.nextInt(masterlist.size());
         ExerciseEvent eve = new ExerciseEvent(masterlist.get(x),1400,1400);
         daysexerices.add(eve);

         }
         else if(timebetween.get(j)<=15){
         int x = randy.nextInt(masterlist.size());
         ExerciseEvent eve = new ExerciseEvent(masterlist.get(x),1400,1400);
         daysexerices.add(eve);

         }


         if(timebetween.get(j)<=15){
         int x = randy.nextInt(masterlist.size());
         daysexerices.add(masterlist.get(x));

         }
         }**/

        for (int p = 0; p <= 96; p++) {
            fifteenminutezone fifteener = new fifteenminutezone(p * 15, false, false, null);
            fifteens.add(fifteener);
        }
        int x = randy.nextInt(listofexercisess.getmasterlist().size());
        int y = randy.nextInt(64);
        for (int k = 0; k <= 4; k++) {
            y = randy.nextInt(38) + 40;//NOTE THIS IS WEHRE WE CAN ADD AN ADJUSTMENT
            if (fifteens.get(y).isthereanevent() || fifteens.get(y).isthereanexercisehere()) {
                fifteens.get(y).exercisepresent(true);
                fifteens.get(y).exercisechange(masterlist.get(x));
            }

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

    public String getnextexercise(int time){

        for(int i=time; i<1440; i++) {
            for(int x = 0; x<fifteens.size();x++){
                if(i%15==0){
                    if(fifteens.get(x).isthereanexercisehere()){
                        return fifteens.get(x).getExercise().getname();
                    }
                }
            }

        }
        return "None";

    }






   /* public OurEvent geteventtitle(String titleofevent){
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
    }*/

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

    public int getDate(){
        return date;
    }

    public int timebetweenevents(int j){
        if(events.size()!=0){

            return  (events.get(j+1).getstarttime()-events.get(j).gettimeofeventstop());}
        return 1440;
    }

}
