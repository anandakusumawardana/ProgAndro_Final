package com.example.progandro_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button about;
    private EditText email,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        pwd   = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = String.valueOf(email.getText());
                String pwdUser   = String.valueOf(pwd.getText());
                setContentView(R.layout.homepage);
            }
        });


    }
    @Override
    protected void onStart(){
        super.onStart();
    }
}
