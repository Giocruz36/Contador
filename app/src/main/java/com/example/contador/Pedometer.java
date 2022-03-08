package com.example.contador;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Pedometer extends AppCompatActivity implements SensorEventListener {
    private TextView tv1, tv2;
    private SensorManager sensor;
    private Sensor step, stepD;
    private boolean counter,detector;
    int stepC = 0, stepCD=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasometro);
        Toolbar toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        tv1 = findViewById(R.id.tv01);
        tv2 = findViewById(R.id.tv02);
        sensor = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensor.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            step = sensor.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            counter=true;
        }else{
            tv1.setText("No se presenta un contador de pasos");
            counter=false;
        }

        if (sensor.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null){
            stepD = sensor.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            detector=true;
        }else{
            tv2.setText("No se presenta un detector de pasos");
            detector=false;
        }
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

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor==step){
            stepC = (int) sensorEvent.values[0];
            tv1.setText(String.valueOf(stepC));
        }else if (sensorEvent.sensor==stepD){
            stepCD = (int) sensorEvent.values[0];
            tv2.setText(String.valueOf(stepCD));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensor.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null);
        sensor.registerListener(this,step,SensorManager.SENSOR_DELAY_NORMAL);

        if (sensor.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null)
            sensor.registerListener(this,stepD,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (sensor.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
        sensor.unregisterListener(this,step);

        if (sensor.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null)
            sensor.unregisterListener(this,stepD);
    }

}