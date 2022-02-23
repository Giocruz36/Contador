package com.example.contador;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmento_nivel extends Fragment implements SensorEventListener {
    private NivelPantalla pantalla;
    private SensorManager miManager;
    private Sensor miSensor;
    private int dimenw,dimenh;

    public Fragmento_nivel(){}

    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        miManager=(SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        miSensor=miManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        dimenw = metrics.widthPixels;
        dimenh = metrics.heightPixels;
        pantalla = new NivelPantalla(getActivity(),dimenw,dimenh);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmento = pantalla;
        return fragmento;
    }
    public void onResume(){
        super.onResume();
        miManager.registerListener(this,miSensor,SensorManager.SENSOR_DELAY_GAME);
    }

    public void onPause(){
        super.onPause();
        miManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        pantalla.angulos(event.values);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int acurracy) {

    }
}