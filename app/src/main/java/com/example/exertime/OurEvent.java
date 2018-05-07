package com.example.exertime;

/**
 * Created by snowk on 5/4/2018.
 */

public class OurEvent {
    private  int timeofeventstart;
    private int timeofeventstop;
    //private int eventdate;

    public OurEvent(int timestart, int timestop) {
        timeofeventstart = timestart;
        timeofeventstop = timestop;
    }
    public OurEvent() {
        timeofeventstart = 0;
        timeofeventstop = 0;
    }


    public int getstarttime(){
        return timeofeventstart;
    }

    public int gettimeofeventstop(){
        return timeofeventstop;
    }
    public int getlengthoftime(){
        return timeofeventstop-timeofeventstart;
    }

}

