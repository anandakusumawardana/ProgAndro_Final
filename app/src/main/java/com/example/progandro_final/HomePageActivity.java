package com.example.progandro_final;

import android.app.Notification;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import static com.example.progandro_final.WiFiCheck.CHANNEL_1;
import static com.example.progandro_final.WiFiCheck.CHANNEL_2;

public class HomePageActivity extends AppCompatActivity {
    private TextView textView;
    private View view;
    private WifiManager wifiManager;
    private NotificationManagerCompat notificationManagerCompat;
    private static final String TAG = "Activities";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0);
        tabLayout.getTabAt(1);

        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            if (wifiState == WifiManager.WIFI_STATE_ENABLED){
                wifiOn(view);
            }
            else if (wifiState == WifiManager.WIFI_STATE_DISABLED){
                wifiOff(view);
            }
        }
    };

    protected void onStart(){
        super.onStart();
        registerReceiver(broadcastReceiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
    }

    protected void onStop(){
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    private void wifiOn(View view){
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_1)
                .setSmallIcon(R.drawable.ic_wifi_black)
                .setContentTitle("WiFi Connection")
                .setContentText("Your WiFi is On")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);
    }

    private void wifiOff(View view){
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_2)
                .setSmallIcon(R.drawable.ic_signal_wifi_off)
                .setContentTitle("WiFi Connection")
                .setContentText("Your WiFi is Off")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2,notification);
    }

    private void jobSchedule(View view){
        ComponentName componentName = new ComponentName(this, MyJobService.class);
        JobInfo jobInfo = new JobInfo.Builder(123, componentName)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int result = jobScheduler.schedule(jobInfo);
        if (result == JobScheduler.RESULT_SUCCESS){
            Log.d(TAG, "Job Scheduled");
        }
        else {
            Log.d(TAG, "Job Scheduling Failed");
        }
    }
}
