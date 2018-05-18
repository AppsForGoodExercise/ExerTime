package com.example.exertime;

/**
 * Created by snowk on 5/4/2018.
 */

public class OurEvent {
    private  int timeofeventstart;
    private int timeofeventstop;
    //private int eventdate;

    /**
     * Creates an ourevent object
     * @param timestart
     * @param timestop
     */
    public OurEvent(int timestart, int timestop) {
        timeofeventstart = timestart;
        timeofeventstop = timestop;
    }

    /** An empty constructor
     *
     */
    public OurEvent() {
        timeofeventstart = 0;
        timeofeventstop = 0;
    }

    /**
     * getstarttime
     * @return timeofeventstart
     */
    public int getstarttime(){
        return timeofeventstart;
    }

    /**gettimeofevenstop
     * gets the time an event ends
     * @return
     */
    public int gettimeofeventstop(){
        return timeofeventstop;
    }

    /**getlengthoftime
     * find the length of time of an event
     *
     * @return stoptime-starttime
     */
    public int getlengthoftime(){
        int timestartinteger= (timeofeventstart%100)+timeofeventstart/100*60;
        int timestopinteger = (timeofeventstop%100)+timeofeventstop/100*60;

        return timestopinteger-timestartinteger;
    }

}

