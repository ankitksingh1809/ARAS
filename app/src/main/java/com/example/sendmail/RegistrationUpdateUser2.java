package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationUpdateUser2 extends AppCompatActivity {

    private Button btnNextStep;
    private EditText etRollNo;
    private EditText etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_update_user2);

        etRollNo = findViewById(R.id.etRollNo);
        etEmail = findViewById(R.id.etEmail);
        btnNextStep = findViewById(R.id.btnNextStep);

        btnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DayTimeFlag.class);
                intent.putExtra("RollNo", etRollNo.getText().toString());
                intent.putExtra("Email", etEmail.getText().toString());
                startActivity(intent);
            }
        });
    }
}