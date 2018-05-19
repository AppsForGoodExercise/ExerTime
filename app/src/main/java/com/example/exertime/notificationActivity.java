package com.example.exertime;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class notificationActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.notification);

        button = (Button) findViewById(R.id.notifyButton);

        /*on the click of the button, return a notification saying
         * "Exert!me" "Time to exercise" with the launcher icon (round)
         */
        button.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {


                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(notificationActivity.this)
                        .setSmallIcon(android.R.drawable.stat_notify_error)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))
                        .setVibrate(new long[]{android.app.Notification.DEFAULT_VIBRATE})
                        .setPriority(android.app.Notification.PRIORITY_MAX)
                        .setContentTitle("ExerT!me")
                        .setContentText("Time to exercise!");

                notificationBuilder.setDefaults(android.app.Notification.DEFAULT_SOUND | android.app.Notification.DEFAULT_LIGHTS | android.app.Notification.DEFAULT_VIBRATE);
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(notificationActivity.this);
                notificationManager.notify(1, notificationBuilder.build());


            }
        });
    }
}
