package com.example.googlelerning.myapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import android.widget.TextView;
import com.example.googlelerning.myapp.R;
import com.example.googlelerning.myapp.SecondActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Objects;

public class ListCityFragment extends Fragment {
    private static final String LOG_TAG = "ListCityFragment";
    private CheckBox tempCheckBox, windCheckBox, humCheckBox;
    private Button viewWatherBtn;
    private boolean isCheckedTempCheckBox, isCheckedWindCheckBox, isCheckedHumCheckBox;
    private TextInputEditText inputCity;
    private OnFragmentInteractionListener mListener;
    private Integer indexCity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Выполнен onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_city, container, false);
        initView(view);
        tempCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedTempCheckBox = isChecked;
            }
        });

        windCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedWindCheckBox = isChecked;
            }
        });

        humCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedHumCheckBox = isChecked;
            }
        });

        inputCity.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)){
                    TextView tv = (TextView) v;
                    indexCity=checkCity(tv);
                    return true;
                }
                return false;
            }
        });
        viewWatherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //intent.putExtra("spinnerItemPosition", spinnerItemPosition);
                intent.putExtra("city", indexCity);
                intent.putExtra("isCheckedHumCheckBox", isCheckedHumCheckBox);
                intent.putExtra("isCheckedWindCheckBox", isCheckedWindCheckBox);
                intent.putExtra("isCheckedTempCheckBox", isCheckedTempCheckBox);
                intent.setClass(Objects.requireNonNull(getActivity()), SecondActivity.class);
                startActivity(intent);
            }
        });
        Log.d(LOG_TAG, "Выполнен onCreateView()");
        return view;
    }

    private Integer checkCity(TextView tv) {
        String city = tv.getText().toString();
        String[] arrayCity = getResources().getStringArray(R.array.cityList);
        for (int i = 0; i < arrayCity.length; i++) {
            if (city.equalsIgnoreCase(arrayCity[i])) {
                Snackbar.make(tv, "Was chosen city "+arrayCity[i], Snackbar.LENGTH_LONG).show();
                return i;
            }
        }
        return -1;
    }


    private void initView(View view){
        tempCheckBox=view.findViewById(R.id.tempCb);
        windCheckBox=view.findViewById(R.id.windCb);
        humCheckBox=view.findViewById(R.id.humidityCb);
        viewWatherBtn=view.findViewById(R.id.viewWatherBtn);
        inputCity=view.findViewById(R.id.inputCity);

    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(LOG_TAG,"Выполнен onAttach()");
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG,"Выполнен onDetach()");
        mListener = null;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"Выполнен onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"Выполнен onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"Выполнен onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"Выполнен onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG,"Выполнен onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"Выполнен onDestroy()");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        Log.d(LOG_TAG,"Выполнен onViewCreated()");
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Intent intent);
    }
}
