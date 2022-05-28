package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLogin2 extends AppCompatActivity {

    private Button btnSendMailAdmin;
    private Button btnSubmit;
    private Boolean authorized = false;
    private EditText etCode;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login2);

        btnSendMailAdmin = findViewById(R.id.btnSendMailAdmin);
        btnSubmit = findViewById(R.id.btnSubmit);
        etCode = findViewById(R.id.etCode);

        btnSendMailAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandom();
                SendMail sm = new SendMail(getApplicationContext(), "ankitksingh1809@gmail.com", "Admin Pass Key", Integer.toString(num));
                sm.execute();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     if(Integer.parseInt(etCode.getText().toString())==num){
                         authorized = true;
                     }
                     if(authorized==true) {
                         authorized=false;
                         etCode.setText("");
                         Intent intent = new Intent(getApplicationContext(), AdminHome2.class);
                         startActivity(intent);
                     }
                 }
             }
        );
    }

    void generateRandom(){
        num =0;
        for(int i=0;i<6;i++){
            num *=10;
            num +=(int)(Math.random()*10);
        }
    }
}