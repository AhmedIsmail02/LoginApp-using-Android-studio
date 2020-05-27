package com.example.ahmedmagdy.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static Button button;
    private static EditText user_edit;
    private static EditText pass_edit;
    private static TextView attemps_no;
    int attemps_counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }
    public void LoginButton()
    {
        button=(Button)findViewById(R.id.buttonID);
        user_edit=(EditText)findViewById(R.id.user_editID);
        pass_edit=(EditText)findViewById(R.id.pass_editID);
        attemps_no=(TextView)findViewById(R.id.attemps_noID);
        attemps_no.setText(String.valueOf(attemps_counter));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_edit.getText().toString().equals("ahmed") && pass_edit.getText().toString().equals("1234")){
                    Toast.makeText(Login.this,"Correct username and password",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.example.ahmedmagdy.loginapp.UserActivity");
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this,"Wrong username or password",Toast.LENGTH_SHORT).show();
                    attemps_counter--;
                    attemps_no.setText(String.valueOf(attemps_counter));
                    if(attemps_counter==0){
                        button.setEnabled(false);
                    }

                }

            }
        });
    }
}
