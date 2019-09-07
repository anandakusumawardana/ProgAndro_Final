package com.example.progandro_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {
    private Button abt;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        abt = findViewById(R.id.about);
        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tentang = new Intent(Homepage.this,About.class);
                //finish();
                startActivity(tentang);
                //setContentView(R.layout.about);
            }
        });
    }
}
