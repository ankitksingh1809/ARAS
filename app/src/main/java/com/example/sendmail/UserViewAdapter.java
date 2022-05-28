package com.example.sendmail;

import android.annotation.SuppressLint;
import android.content.Context;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewHolder> {

    List<UserData> listUsers = Collections.emptyList();
    Context context;
    DBHelper userDb;

    public UserViewAdapter(List<UserData> users, Context context){
        this.listUsers = users;
        this.context = context;
        this.userDb = new DBHelper(context);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View userView = inflater.inflate(R.layout.user_card, parent, false);
        UserViewHolder ViewHolder = new UserViewHolder(userView);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder ViewHolder, @SuppressLint("RecyclerView") int position) {
        ViewHolder.tvRollNo.setText(listUsers.get(position).RollNo);
        ViewHolder.tvEmail.setText(listUsers.get(position).Email);
        ViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDb.deleteUser(listUsers.get(position).RollNo, listUsers.get(position).Email);
                ViewHolder.view.setBackgroundColor(Color.rgb(252,90,3));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
