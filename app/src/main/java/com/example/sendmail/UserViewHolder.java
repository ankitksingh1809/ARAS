package com.example.sendmail;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView tvRollNo;
    TextView tvEmail;
    Button btnDelete;
    View view;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        tvRollNo = itemView.findViewById(R.id.tvRollNo);
        tvEmail = itemView.findViewById(R.id.tvEmail);
        btnDelete = itemView.findViewById(R.id.btnDelete);
        view = itemView;
    }


}
