package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminHome2 extends AppCompatActivity {

    private Button btnAddUsers;
    private Button btnViewDeleteUsers;
    private Button btnDeleteAllUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home2);

        btnAddUsers = findViewById(R.id.btnAddUsers);
        btnViewDeleteUsers = findViewById(R.id.btnViewDeleteUsers);
        btnDeleteAllUsers = findViewById(R.id.btnDeleteAllUsers);
        DBHelper usersDb = new DBHelper(this);

        btnAddUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddUserAdmin2.class);
                startActivity(intent);
            }
        });

        btnViewDeleteUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewDeleteUserAdmin2.class);
                startActivity(intent);
            }
        });

        btnDeleteAllUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usersDb.deleteAllUsers();
                Toast toast = Toast.makeText(getApplicationContext(), "Users details deleted successfully.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}