package com.example.googlelerning.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        TextView errorTv = findViewById(R.id.errorTv);
        Intent intent=getIntent();
        errorTv.setText(intent.getStringExtra("notFound"));
    }
}
