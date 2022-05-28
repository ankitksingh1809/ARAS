package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserAdmin2 extends AppCompatActivity {

    private Button btnSubmitAddUsers;
    private EditText etUserIds;
    private DBHelper usersDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_admin2);
        usersDb = new DBHelper(this);

        btnSubmitAddUsers = findViewById(R.id.btnSubmitAddUsers);
        etUserIds = findViewById(R.id.etUserIds);

        btnSubmitAddUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserIds = etUserIds.getText().toString();
                String UserId[] = UserIds.split("\n");
                for(String user : UserId){
                    String details[] = user.split(" ");
                    usersDb.insertUser(details[0], details[1], false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
                    Toast toast = Toast.makeText(getApplicationContext(), "Users added successfully", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}