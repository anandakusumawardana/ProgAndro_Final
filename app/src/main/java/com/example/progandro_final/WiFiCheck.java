package com.example.progandro_final;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class WiFiCheck extends Application {
    public static final String CHANNEL_1 = "WiFi is ON";
    public static final String CHANNEL_2 = "WiFi is OFF";

    public void onCreate(){
        super.onCreate();
        createNotification();
    }

    private void createNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel on = new NotificationChannel(
                    CHANNEL_1,
                    "WIFI ON",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationChannel off = new NotificationChannel(
                    CHANNEL_2,
                    "WIFI OFF",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager =  getSystemService(NotificationManager.class);
            manager.createNotificationChannel(on);
            manager.createNotificationChannel(off);
        }
    }
    public static class Notification extends Application {
        public static final String onWiFi = "WiFi is On";
        public static final String offWiFi = "WiFi is Off";
        @Override
        public void onCreate(){
            super.onCreate();
            createNotification();
        }

        private void createNotification() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                NotificationChannel on = new NotificationChannel(
                        onWiFi,
                        "WiFi is On",
                        NotificationManager.IMPORTANCE_HIGH);
                on.setDescription("WiFi is On");

                NotificationChannel off = new NotificationChannel(
                        offWiFi,
                        "WiFi is Off",
                        NotificationManager.IMPORTANCE_LOW);
                off.setDescription("WiFi is Off");

                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(on);
                manager.createNotificationChannel(off);
            }
        }
    }
}
