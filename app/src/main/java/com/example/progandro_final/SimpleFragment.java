package com.example.progandro_final;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.progandro_final.ui.main.SectionsPagerAdapter;

import static com.example.progandro_final.Valid.Notification.offWiFi;
import static com.example.progandro_final.Valid.Notification.onWiFi;

public class SimpleFragment extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private View view;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        Button btn = findViewById(R.id.about);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(SimpleFragment.this,About.class);
                startActivity(about);
            }
        });
    }
    //broadcast receiver for wifi is on or off
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);
            if (wifiState == WifiManager.WIFI_STATE_ENABLED){
                wifiOn(view);
                Toast.makeText(getApplicationContext(),"WiFi is On",Toast.LENGTH_SHORT).show();
            }
            else if (wifiState == WifiManager.WIFI_STATE_DISABLED){
                wifiOff(view);
                Toast.makeText(getApplicationContext(),"WiFi is Off",Toast.LENGTH_SHORT).show();
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
    public void wifiOn(View view){
        String title = "Apps";
        String message = "WiFi is On";
        android.app.Notification notification = new NotificationCompat.Builder(this,onWiFi)
                .setSmallIcon(R.drawable.ic_wifi_black)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentTitle(title)
                .setContentText(message)
                .build();

        notificationManagerCompat.notify(1,notification);
    }

    public void wifiOff(View view){
        String title = "Apps";
        String message = "WiFi is Off";
        android.app.Notification notification = new NotificationCompat.Builder(this,offWiFi)
                .setSmallIcon(R.drawable.ic_wifi_black)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setContentTitle(title)
                .setContentText(message)
                .build();

        notificationManagerCompat.notify(2,notification);
    }

    public void scheduleJob(View view){
        ComponentName componentName = new ComponentName(this,MyJobService.class);
        JobInfo jobInfo = new JobInfo.Builder(123,componentName)
//                .setRequiresCharging(true)
//                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000) //set every 15 minutes
                .build();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = jobScheduler.schedule(jobInfo);
        if (resultCode == JobScheduler.RESULT_SUCCESS){
            Log.d(TAG,"Job scheduled");
        }
        else {
            Log.d(TAG,"Job scheduling failed");
        }
    }
    public void cancelJob(View view){
        JobScheduler scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        scheduler.cancel(123);
        Log.d(TAG, "Job cancelled");
    }
}