package com.example.contador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class menu_juego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitity_juego_principal);
    }
    public void ejecutarjuego(View view){
        Intent i = new Intent(this, juego.class);
        startActivity(i);
    }

    public void ejecutarjuego2(View view){
        Intent i = new Intent(this, juego2.class);
        startActivity(i);
    }

    public void cerrar_juego(View view){
      finishAndRemoveTask();
    }
}
