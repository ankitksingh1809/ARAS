package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewDeleteUserAdmin2 extends AppCompatActivity {

    private UserViewAdapter adapter;
    private RecyclerView recyclerView;
    private DBHelper userDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_delete_user_admin2);

        userDb = new DBHelper(getApplicationContext());
        List<UserData> userDataList = new ArrayList<>();
        userDataList = userDb.getUsers();

        recyclerView = findViewById(R.id.rvUser);
        adapter = new UserViewAdapter(userDataList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewDeleteUserAdmin2.this));
    }
}