package com.example.googlelerning.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    
    private TextView cityTv;
    private TextView tempTv;
    private TextView windTv;
    private TextView humidityTv;
    private Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        outCity(intent);
        outTemp(intent);
        outWind(intent);
        outHumidity(intent);

    }


        private void initView() {
        intent=getIntent();
       cityTv=findViewById(R.id.myCityTv);
       tempTv=findViewById(R.id.myTempTv);
       windTv=findViewById(R.id.windTv);
       humidityTv=findViewById(R.id.humidityTv);

    }

    private void outCity(Intent intent){
        String city="You don't input city";
        if(intent.getStringExtra("city_name")!=null)
            city=intent.getStringExtra("city_name");
        cityTv.setText(city);
    }
    private void outTemp(Intent intent){
        boolean checked =intent.getBooleanExtra("temp",false);
        if (checked) {
            String tmp =getResources().getString(R.string.temperature)+
                    " : "+getResources().getString(R.string.temp);
            tempTv.setText(tmp);}
    }
    private void outWind(Intent intent){
        boolean checked =intent.getBooleanExtra("wind",false);
        if (checked)
        {
            String win =getResources().getString(R.string.winCb)+
                    " : "+getResources().getString(R.string.wind);
            windTv.setText(win);
        }
        }
//         if (intent.getBooleanExtra("wind",false))
//            windTv.setText(R.string.wind);

    private void outHumidity(Intent intent){
        boolean checked =intent.getBooleanExtra("humidity",false);

        if (checked)
        {
            String hum =getResources().getString(R.string.humidityCb)+
                    " : "+getResources().getString(R.string.humidity);
            humidityTv.setText(hum);
        }

        }
//         if (intent.getBooleanExtra("humidity",false))
//            humidityTv.setText(R.string.humidity);


}
