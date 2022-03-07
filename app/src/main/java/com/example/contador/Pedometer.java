package com.example.contador;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Pedometer extends AppCompatActivity implements SensorEventListener {
    private Toolbar toolbar;
    private SensorManager mSensorManager;
    private TextView tv01,tv02;
    public float mDetector;
    public float mCounter;
    private static final int sensorTypeD = Sensor.TYPE_STEP_DETECTOR;
    private static final int sensorTypeC = Sensor.TYPE_STEP_COUNTER;
    private Sensor stepCounter;
    private Sensor stepDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasometro);
        toolbar=(Toolbar)findViewById(R.id.menu_toolbar);
        // encuentra el control
        tv01 = (TextView) findViewById(R.id.tv01);
        tv02 = (TextView) findViewById(R.id.tv02);
        // Obtenga SensorManager
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // Obtén el tipo de sensor que necesitamos
        Sensor stepCounter = mSensorManager.getDefaultSensor(sensorTypeC);
        Sensor stepDetector = mSensorManager.getDefaultSensor(sensorTypeD);
        // Registra el oyente
        mSensorManager.registerListener(this, stepCounter,SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, stepDetector,SensorManager.SENSOR_DELAY_FASTEST);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();

        if (id == R.id.calculadora_menu) {
            ejecutaCalculadora(null);
            return true;
        }
        if (id == R.id.volver_inicio) {
            ejecutarprincipal(null);
            return true;
        }
        if (id == R.id.juegos_menu) {
            ejecutarjuegos(null);
            return true;
        }
        if (id == R.id.herramientas_menu) {
            ejecutartools(null);
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }

    public void ejecutaCalculadora(View view) {
        Intent i = new Intent(this, calculadora.class);
        startActivity(i);
    }

    public void ejecutarprincipal(View view){
        Intent i = new Intent(this,Pagina_principal.class);
        startActivity(i);
    }
    public void ejecutartools(View view){
        Intent i = new Intent(this,herramientas.class);
        startActivity(i);
    }
    public void ejecutarjuegos(View view){
        Intent i = new Intent(this, menu_juego.class);
        startActivity(i);
    }
    public void ejecutarpodometro(View view){
        Intent i = new Intent(this, Pedometer.class);
        startActivity(i);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == sensorTypeC) {
            mCounter = event.values[0];
            tv01.setText (mCounter + "Paso");

        }
        if (event.sensor.getType() == sensorTypeD) {
            if (event.values[0] == 1.0) {
                mDetector++;
                tv02.setText (mDetector + "Paso");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}