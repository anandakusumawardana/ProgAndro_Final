package com.example.progandro_final;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            NetworkInfo info = getNetworkInfo(context);
            if (info != null && info.isConnected()){
                //todo when wifi is connected
                System.out.println("Wifi is Connected");
            }
            else{
                //todo when wifi is disconnected
                System.out.println("Wifi is Disconnected");
            }
        }
    };

    private NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    }
    protected void onResume(){
        super.onResume();
        if (!isReceiverRegistered){
            isReceiverRegistered = true;
            registerReceiver(receiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        }
    }

    protected void onPause(){
        super.onPause();
        if(isReceiverRegistered){
            isReceiverRegistered = false;
            unregisterReceiver(receiver);
        }
    }
}
