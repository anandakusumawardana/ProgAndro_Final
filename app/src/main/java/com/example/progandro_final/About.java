package com.example.progandro_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {
    Button btn;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        btn = findViewById(R.id.spotify);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent spotify = getPackageManager().getLaunchIntentForPackage("com.spotify.music");
                if (spotify != null){
                    startActivity(spotify);
                }
            }
        });
    }
}
