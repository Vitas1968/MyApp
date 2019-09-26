package com.example.googlelerning.myapp;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static  final String LOG_TAG ="LOG_TAG";

    private EditText inputCityEt;
//    private CheckBox tempCb;
// private Button viewWeatherBtn;
//    private CheckBox windCb;
//    private CheckBox humidityCb;
    private static Intent intent;
    private String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        inputCity();
        Log.d(LOG_TAG,"Выполнен onCreate()");

    }
    private void initView(){
        intent=new Intent(this,SecondActivity.class);

        inputCityEt=findViewById(R.id.inputCityEt);
        inputCityEt.requestFocus();
//        tempCb=findViewById(R.id.tempCb);
//        viewWeatherBtn=findViewById(R.id.viewWatherBtn);
//        windCb=findViewById(R.id.windCb);
//        humidityCb=findViewById(R.id.humidityCb);
        Log.d(LOG_TAG,"Выполнен initView()");
    }

    private void inputCity(){
        inputCityEt.setOnKeyListener(new View.OnKeyListener() {
           public boolean onKey(View v, int keyCode, KeyEvent event) {
             if(event.getAction() == KeyEvent.ACTION_DOWN &&
                (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // сохраняем текст, введенный до нажатия Enter в переменную
                 city = inputCityEt.getText().toString();
                  Toast toast= Toast.makeText(getApplicationContext(),
                                              city,
                                               Toast.LENGTH_LONG);
                                               toast.setGravity(Gravity.CENTER, 0, 0);
                                               toast.show();
              return true;
             }
              return false;
             }
             }
        );
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"Выполнен onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"Выполнен onRestart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"Выполнен onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"Выполнен onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"Выполнен onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"Выполнен onPause()");
    }

    public void onClick(View view) {
        inputCityEt.getText().clear();
        //intent=new Intent(this,SecondActivity.class);
        intent.putExtra("city_name",city);
        Log.d(LOG_TAG,"Вызван onClick()");
        startActivity(intent);
    }

    public void onClickTempCb(View view) {
        CheckBox checkBox = (CheckBox) view;
        Boolean checked= checkBox.isChecked();
        Log.d(LOG_TAG,checked.toString());
        intent.putExtra("temp",checked);

    }
    public void onClickWindCb(View view) {
        CheckBox checkBox = (CheckBox) view;
        boolean checked= checkBox.isChecked();

            intent.putExtra("wind",checked);

    }
    public void onClickhumidityCb(View view) {
        CheckBox checkBox = (CheckBox) view;
        boolean checked= checkBox.isChecked();
            intent.putExtra("humidity",checked);


    }
}
