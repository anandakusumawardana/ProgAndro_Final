package com.example.progandro_final;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {
    private Button abt,login;
    private boolean isReceiverRegistered = false;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        abt = findViewById(R.id.about);
        login = findViewById(R.id.loginButton);
        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fragment = new Intent(Homepage.this,SimpleFragment.class);
                startActivity(fragment);
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
