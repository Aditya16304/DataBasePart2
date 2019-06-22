package com.example.databasepart2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button logINBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.emailLogIn);
        pass=findViewById(R.id.passLogIn);
        logINBtn=findViewById(R.id.login_btn);
        logINBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogIn();
            }
        });
    }

    private void LogIn() {
        String emailText=email.getText().toString();
        String passText=pass.getText().toString();
        if (emailText.equals("E")&&(passText.equals("12345"))){
            startActivity(new Intent(MainActivity.this,Electrician.class));
            finish();
        }
        else {
            Toast.makeText(MainActivity.this, "LogIn Not Successful", Toast.LENGTH_SHORT).show();
        }
    }
}
