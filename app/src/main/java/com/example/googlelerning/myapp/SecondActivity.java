package com.example.googlelerning.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.example.googlelerning.myapp.fragments.ShowWeatherFragment;
import com.example.googlelerning.myapp.weather_processing.WeatherDataLoader;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Locale;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity implements ShowWeatherFragment.OnFragmentInteractionListener {

    private TextView cityTv;
    private TextView tempTv;
    private TextView windTv;
    private TextView humidityTv;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Fragment showWeather = getSupportFragmentManager().findFragmentById(R.id.weather);
        initView(Objects.requireNonNull(showWeather));
    }

    private void initView(Fragment fr) {
        Intent intent = getIntent();
        cityTv= Objects.requireNonNull(fr.getView()).findViewById(R.id.myCityTv);
        tempTv=fr.getView().findViewById(R.id.myTempTv);
        windTv=fr.getView().findViewById(R.id.windTv);
        humidityTv=fr.getView().findViewById(R.id.humidityTv);
        String city = intent.getStringExtra("city");
        updateWeatherData(city);
    }

    private void updateWeatherData(final String city) {
        new Thread() {
            @Override
            public void run() {
                final JSONObject jsonObject = WeatherDataLoader.getJSONData(city);
                if(jsonObject == null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            showActivityError();
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            renderWeather(jsonObject);
                        }
                    });
                }
            }
        }.start();
    }

    private void renderWeather(JSONObject jsonObject) {
        try {
            JSONObject main = jsonObject.getJSONObject("main");
            setPlaceName(jsonObject);
            outHumidity(main);
            setCurrentTemp(main);
            outWind(jsonObject);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private void setPlaceName(JSONObject jsonObject) throws JSONException {
        String cityText = jsonObject.getString("name").toUpperCase() + ", "
                + jsonObject.getJSONObject("sys").getString("country");
        cityTv.setText(cityText);
    }

    private void outHumidity( JSONObject main) throws JSONException {
        String outHumidity = "Humidity: " + main.getString("humidity") + "%";
        humidityTv.setText(outHumidity);
    }

    private void setCurrentTemp(JSONObject main) throws JSONException {
        String currentTextText = String.format(Locale.getDefault(), "%.1f",
                main.getDouble("temp")) + "\u2103";
        tempTv.setText(currentTextText);
    }

    private void outWind(JSONObject jsonObject)throws JSONException {
        JSONObject js_wind=jsonObject.getJSONObject("wind");
        int speed_wind = js_wind.getInt("speed");
        String wind = speed_wind + " m/s";
        windTv.setText(wind);

    }
    private void showActivityError(){
        Intent intent=new Intent();
        String notFound=getResources().getString(R.string.place_not_found);
        intent.putExtra("notFound",notFound);
        intent.setClass(Objects.requireNonNull(getApplicationContext()), ErrorActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
