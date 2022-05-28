package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class DayTimeFlag extends AppCompatActivity {

    private CheckBox cbD[] = new CheckBox[8];
    private CheckBox cbT[] = new CheckBox[8];
    private DBHelper usersDb;
    private Button btnRegisterUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_time_flag);

        Bundle Extras = getIntent().getExtras();
        String RollNo = Extras.getString("RollNo");
        String Email = Extras.getString("Email");

        btnRegisterUpdate = findViewById(R.id.btnRegisterUpdate);
        cbD[0] = findViewById(R.id.cbAllDay);
        cbD[1] = findViewById(R.id.cbMonDay);
        cbD[2] = findViewById(R.id.cbTuesday);
        cbD[3] = findViewById(R.id.cbWednesday);
        cbD[4] = findViewById(R.id.cbThursday);
        cbD[5] = findViewById(R.id.cbFriday);
        cbD[6] = findViewById(R.id.cbSaturday);
        cbD[7] = findViewById(R.id.cbSunday);

        cbT[0] = findViewById(R.id.cbNineAM);
        cbT[1] = findViewById(R.id.cbTenAM);
        cbT[2] = findViewById(R.id.cbElevenAM);
        cbT[3] = findViewById(R.id.cbTwelvePM);
        cbT[4] = findViewById(R.id.cbOnePM);
        cbT[5] = findViewById(R.id.cbTwoPM);
        cbT[6] = findViewById(R.id.cbThreePM);
        cbT[7] = findViewById(R.id.cbFourPM);

        boolean bD[] = new boolean[8];
        boolean bT[] = new boolean[8];
        usersDb = new DBHelper(getApplicationContext());



        btnRegisterUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<=7;i++){
                    if(cbD[i].isChecked()){
                        bD[i] = true;
                    }else{
                        bD[i] = false;
                    }
                    Log.d("Update", String.valueOf(bD[i]));

                    if(cbT[i].isChecked()){
                        bT[i] = true;
                    }else{
                        bT[i] = false;
                    }
                }

                if(bD[0]==true){
                    for(int i=0;i<=7;i++){
                        bD[i] = true;
                    }
                }
                Log.d("Update", String.valueOf(bD[1]));
                int bb = usersDb.updateUser(RollNo, Email, bD[1], bD[2], bD[3], bD[4], bD[5], bD[6], bD[7], bT[0], bT[1], bT[2], bT[3], bT[4], bT[5], bT[6], bT[7], false);
                if(bb != 0) {
                    Toast.makeText(getApplicationContext(), RollNo + " Updation successful", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), RollNo + " Updation failed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}