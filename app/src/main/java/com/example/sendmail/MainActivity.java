package com.example.sendmail;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity{

    private Button btnAdmin;
    private Button btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdmin = findViewById(R.id.btnAdmin);
        btnUser = findViewById(R.id.btnUser);

        btnAdmin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AdminLogin2.class);
            startActivity(intent);
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserHome2.class);
                startActivity(intent);
            }
        });
    }
}
