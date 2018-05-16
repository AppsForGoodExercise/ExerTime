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
                .setContentTitle("ExerT!me")  //sets the title
                .setContentText("Time to update your schedule!") //message
                .setSmallIcon(R.mipmap.ic_launcher) //sets the icon
                .setAutoCancel(true)
                .setSmallIcon(android.R.drawable.stat_notify_error)
                .setVibrate(new long[]{Notification.DEFAULT_VIBRATE}) //default settings
                .setPriority(Notification.PRIORITY_MAX); //sets the importance of notifications

        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE); //notification default settings
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build()); //builds the notification

    }


}
