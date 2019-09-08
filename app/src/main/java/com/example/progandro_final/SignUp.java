package com.example.progandro_final;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private Button daftar;
    private EditText emailUser,pwd,pwd2;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        emailUser = findViewById(R.id.emailUser);
        pwd = findViewById(R.id.pwd);
        pwd2 = findViewById(R.id.pwd2);
        daftar = findViewById(R.id.daftarBaru);
        daftar.setOnClickListener(new View.OnClickListener() {
            //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (checking(String.valueOf(pwd.getText()),String.valueOf(pwd2.getText()),String.valueOf(emailUser.getText()))){
                    Intent homepage = new Intent(SignUp.this,Homepage.class);
                    finish();
                    startActivity(homepage);
                }
            }
        });
    }
    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean checking(String pass1, String pass2, String email){
        if (pass1.isEmpty() == false && email.isEmpty() == false && pass2.equals(pass1)){
            Toast.makeText(this,"Field Must Not Empty", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (pass1.isEmpty() || pass2.isEmpty() || email.isEmpty()){
            Toast.makeText(this,"Must Fill The Form", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (pass1.equals(pass2) == false){
            Toast.makeText(this,"Your Password Does Not Match", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return false;
        }
    }
}
