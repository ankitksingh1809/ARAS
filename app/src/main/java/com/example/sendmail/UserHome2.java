
package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHome2 extends AppCompatActivity {

    private Button btnRegistrationUpdate;
    private Button btnOpenDoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home2);

        btnRegistrationUpdate = findViewById(R.id.btnRegistrationUpdate);
        btnOpenDoor = findViewById(R.id.btnOpenDoor);

        btnRegistrationUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationUpdateUser2.class);
                startActivity(intent);
            }
        });

        btnOpenDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OpenDoorUser2.class);
                startActivity(intent);
            }
        });
    }
}