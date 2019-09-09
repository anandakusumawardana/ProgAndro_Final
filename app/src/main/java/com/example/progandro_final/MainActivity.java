package com.example.progandro_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button about;
    private EditText email,pwd;
    private TextView daftar;
    Valid validation = new Valid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        pwd   = findViewById(R.id.password);
        daftar = findViewById(R.id.signUp);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailUser = String.valueOf(email.getText());
                String pwdUser   = String.valueOf(pwd.getText());
                if (validation.isValid(emailUser,pwdUser)) {
                    //setContentView(R.layout.homepage);
                    //login.setEnabled();
                    Intent intent = new Intent(MainActivity.this,Homepage.class);
                    //finish();
                    startActivity(intent);
                }
            }
        });
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainActivity.this,SignUp.class);
                startActivity(signUp);
            }
        });
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
}
