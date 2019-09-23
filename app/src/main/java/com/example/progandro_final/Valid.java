package com.example.progandro_final;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Valid {
    protected boolean isValid(String username, String pwd){
        return username.equals("kimJisoo@gmail.com") && pwd.equals("blackpink") ||
                username.equals("ananda@gmail.com") && pwd.equals("123");
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
