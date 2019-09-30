package com.example.googlelerning.myapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

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
        initView();
        outCity();
        outTemp();
        outWind();
        outHumidity();
    }

    private void initView() {
        intent=getIntent();
        cityTv=findViewById(R.id.myCityTv);
        tempTv=findViewById(R.id.myTempTv);
        windTv=findViewById(R.id.windTv);
        humidityTv=findViewById(R.id.humidityTv);
        resources=getResources();
        indexCity=intent.getIntExtra("citySelected", -1);
    }

    private void outCity(){
        String []cityList=resources.getStringArray(R.array.cityList);
        String city = cityList[indexCity];
        cityTv.setText(city);
    }

    private void outTemp(){
        boolean checked =intent.getBooleanExtra("temp",false);
        if (checked) {
        String []tempList = resources.getStringArray(R.array.tempList);
            String tmp =resources.getString(R.string.tempNameCheckBox)
                                                    +" : "
                                                    + tempList[indexCity];
            tempTv.setText(tmp);}
    }

    private void outWind(){
        boolean checked =intent.getBooleanExtra("wind",false);
        if (checked) {
        String [] windList = resources.getStringArray(R.array.windList);
        String win =getResources().getString(R.string.windNameCheckBox)
                                                     +" : "
                                                     +windList[indexCity];
        windTv.setText(win);
        }
    }

    private void outHumidity(){
        boolean checked =intent.getBooleanExtra("humidity",false);
        if (checked) {
            String [] humidityList = resources.getStringArray(R.array.humidityList);
                String hum =getResources().getString(R.string.humidityNameCheckBox)
                                                            +" : "
                                                            + humidityList[indexCity];
                humidityTv.setText(hum);
        }
    }
}
