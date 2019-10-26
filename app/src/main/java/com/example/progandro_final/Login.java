package com.example.progandro_final;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText email,pwd;
    SharedPreferences sharedPreferences;
    public static final String MYPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        pwd   = findViewById(R.id.password);
        TextView daftar = findViewById(R.id.signUp);
        final Button login = findViewById(R.id.loginButton);

        sharedPreferences = getSharedPreferences(MYPREFERENCES, MODE_PRIVATE);

        if (sharedPreferences.contains("email") && sharedPreferences.contains("password")){
            startActivity(new Intent(Login.this,HomePageActivity.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginCheck();
            }
        });
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(Login.this,SignUp.class);
                finish();
                startActivity(signUp);
            }
        });
    }
    public void loginCheck() {
        //check username and password are correct and then add them to SharedPreferences
        if (email.getText().toString().equals("ananda@gmail.com") && pwd.getText().toString().equals("123")) {
            SharedPreferences.Editor e = sharedPreferences.edit();
            e.putString("email", "ananda@gmail.com");
            e.putString("password", "123");
            e.apply();

            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG).show();

            startActivity(new Intent(Login.this, HomePageActivity.class));
            finish();
        } else {
            Toast.makeText(Login.this, "Incorrect Login Details", Toast.LENGTH_LONG).show();
        }
    }
}
