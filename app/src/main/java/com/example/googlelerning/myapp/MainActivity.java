package com.example.googlelerning.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.googlelerning.myapp.fragments.ListCityFragment;

public class MainActivity extends AppCompatActivity implements ListCityFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Intent intent) {
        intent.setClass(this,SecondActivity.class);
        startActivity(intent);
    }


}
