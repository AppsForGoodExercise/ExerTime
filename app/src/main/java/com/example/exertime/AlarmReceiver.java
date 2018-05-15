package com.example.exertime;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//add this import
import android.content.Context;
import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){

        //code for popup--> https://www.youtube.com/watch?v=-mW45toHZpg
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle("ExerT!me")
                .setContentText("Time to update your schedule!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.stat_notify_error)
                .setVibrate(new long[]{Notification.DEFAULT_VIBRATE})
                .setPriority(Notification.PRIORITY_MAX);

        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());

    }

    //These next two methods are for getting the times for notifications

    /*private Context context;
    private static final String FILE_NAME_T = "times.txt";

    ArrayList<Integer> hrInts = new ArrayList<>();
    ArrayList<Integer> minInts = new ArrayList<>();

    public void load() {

        FileInputStream filein_1 = null;

        try {
            filein_1 = context.openFileInput(FILE_NAME_T);
            InputStreamReader reader = new InputStreamReader(filein_1);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuilder sbuilder = new StringBuilder();
            String text;

            while ((text = buffer.readLine()) != null) {
                sbuilder.append(text).append("\n");
            }

            getTimes(sbuilder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //parm wil be sBuilder.to String
    //return an arraylist
    public void getTimes(String timeStr){
        ArrayList<String> timeStrings = new ArrayList<>();
        String temp = "0000";
        for(int z=0; z<(timeStr.length()/4); z++){
            temp = timeStr.substring(z*4,(z*4)+4);
            timeStrings.add(temp);
        }

        ArrayList<Integer> hrIntsTemp = new ArrayList<>();
        ArrayList<Integer> minIntsTemp = new ArrayList<>();

        for (int x=0; x<timeStrings.size(); x++){
            int hr = Integer.parseInt(timeStrings.get(x).substring(0,2));
            hrIntsTemp.add(hr);
            int min = Integer.parseInt(timeStrings.get(x).substring(2,4));
            minIntsTemp.add(min);
        }

        for(int y=0; y<hrIntsTemp.size(); y++){
            hrInts.add(y,hrIntsTemp.get(y));
            minInts.add(y,minIntsTemp.get(y));
        }

    }*/
}
