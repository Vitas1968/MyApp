package com.example.googlelerning.myapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.googlelerning.myapp.fragments.ListCityFragment;

public class MainActivity extends AppCompatActivity implements ListCityFragment.OnFragmentInteractionListener {
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode());
    }
    private Switch dayNightMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dayNightMode=findViewById(R.id.dayNightMode);
        dayNightMode.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }

    @Override
    public void onFragmentInteraction(Intent intent) {
    }


}
