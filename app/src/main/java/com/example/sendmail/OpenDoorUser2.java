package com.example.sendmail;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class OpenDoorUser2 extends AppCompatActivity {

    private EditText etRollNo2;
    private EditText etEmail2;
    private Button btnOpenDoor;
    private DBHelper usersDb;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_door_user2);

        etRollNo2 = findViewById(R.id.etRollNo2);
        etEmail2 = findViewById(R.id.etEmail2);
        btnOpenDoor = findViewById(R.id.btnOpenDoor3);

        usersDb = new DBHelper(this);

        DayOfWeek dayNow = DayOfWeek.from(LocalDate.now());
        int dayFlag=dayNow.getValue();
        int timeFlag;
        LocalTime timeNow = LocalTime.now();
        if((timeNow.compareTo(LocalTime.of(10,00,00))<=0) && (timeNow.compareTo(LocalTime.of(9,00,00))>=0)){
            timeFlag=1;
        }else if(timeNow.compareTo(LocalTime.of(11,00,00))<=0){
            timeFlag=2;
        }else if(timeNow.compareTo(LocalTime.of(12,00,00))<=0){
            timeFlag=3;
        }else if(timeNow.compareTo(LocalTime.of(13,00,00))<=0){
            timeFlag=4;
        }else if(timeNow.compareTo(LocalTime.of(14,00,00))<=0){
            timeFlag=5;
        }else if(timeNow.compareTo(LocalTime.of(15,00,00))<=0){
            timeFlag=6;
        }else if(timeNow.compareTo(LocalTime.of(16,00,00))<=0){
            timeFlag=7;
        }else if(timeNow.compareTo(LocalTime.of(17,00,00))<=0){
            timeFlag=8;
        }else {
            timeFlag=9;
        }

        btnOpenDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> dayTimeFlag = usersDb.getUserDetail(etRollNo2.getText().toString(), etEmail2.getText().toString());
                for(int i=0;i < 15;i++) {
                    Log.d("dayTimeFLAG", dayTimeFlag.get(i).toString());
                }
                if((dayTimeFlag.get(dayFlag-1) == 1) && (dayTimeFlag.get(6 + timeFlag) == 1)){
                    Toast.makeText(getApplicationContext(), "Door Opening", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}