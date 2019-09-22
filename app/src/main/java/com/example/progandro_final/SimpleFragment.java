package com.example.progandro_final;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.progandro_final.ui.main.SectionsPagerAdapter;

public class SimpleFragment extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        btn = findViewById(R.id.about);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(SimpleFragment.this,About.class);
                startActivity(about);
            }
        });
    }
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);
            if (wifiState == WifiManager.WIFI_STATE_ENABLED){
                Toast.makeText(getApplicationContext(),"WiFi is On",Toast.LENGTH_SHORT).show();
            }
            else if (wifiState == WifiManager.WIFI_STATE_DISABLED){
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
}