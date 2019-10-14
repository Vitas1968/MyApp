package com.example.googlelerning.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import com.example.googlelerning.myapp.fragments.ShowWeatherFragment;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity implements ShowWeatherFragment.OnFragmentInteractionListener {

    private TextView cityTv;
    private TextView tempTv;
    private TextView windTv;
    private TextView humidityTv;
    private Intent intent;
    private Resources resources;
    private int indexCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Fragment showWeather = getSupportFragmentManager().findFragmentById(R.id.weather);
        initView(Objects.requireNonNull(showWeather));
        outCity();
        outTemp();
        outWind();
        outHumidity();
    }

    private void initView(Fragment fr) {
        intent=getIntent();
        cityTv= Objects.requireNonNull(fr.getView()).findViewById(R.id.myCityTv);
        tempTv=fr.getView().findViewById(R.id.myTempTv);
        windTv=fr.getView().findViewById(R.id.windTv);
        humidityTv=fr.getView().findViewById(R.id.humidityTv);
        resources=getResources();
        indexCity=intent.getIntExtra("city", -1);
    }

    private void outCity(){
        String []cityList=resources.getStringArray(R.array.cityList);

        if (indexCity!=-1) {
            String city = cityList[indexCity];
            cityTv.setText(city);
        } else { cityTv.setText("No city");
        }
    }

    private void outTemp(){
        boolean checked =intent.getBooleanExtra("isCheckedTempCheckBox",false);
        if (checked && indexCity!=-1) {
          String []tempList = resources.getStringArray(R.array.tempList);
            String tmp =resources.getString(R.string.tempNameCheckBox)
                                                    +" : "
                                                    + tempList[indexCity];
            tempTv.setText(tmp);
        } else tempTv.setText(resources.getString(R.string.no_data));
    }

    private void outWind(){
        boolean checked =intent.getBooleanExtra("isCheckedWindCheckBox",false);
        if (checked && indexCity!=-1) {
        String [] windList = resources.getStringArray(R.array.windList);
        String win =getResources().getString(R.string.windNameCheckBox)
                                                     +" : "
                                                     +windList[indexCity];
        windTv.setText(win);
        } else windTv.setText(resources.getString(R.string.no_data));
    }

    private void outHumidity(){
        boolean checked =intent.getBooleanExtra("isCheckedHumCheckBox",false);
        if (checked && indexCity!=-1) {
            String [] humidityList = resources.getStringArray(R.array.humidityList);
                String hum =getResources().getString(R.string.humidityNameCheckBox)
                                                            +" : "
                                                            + humidityList[indexCity];
                humidityTv.setText(hum);
        } else humidityTv.setText(resources.getString(R.string.no_data));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
