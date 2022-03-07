package com.example.contador;

import androidx.appcompat.app.*;
import androidx.appcompat.widget.Toolbar;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Pagina_principal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        Toolbar toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);
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
        if (id == R.id.herramientas_menu) {
            ejecutartools(null);
            return true;
        }
        if (id == R.id.juegos_menu) {
            ejecutarjuegos(null);
            return true;
        }
        if (id == R.id.b_salir) {
            ejecutarCerrar(null);
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }

    public void ejecutarCerrar(View v) {
        finishAndRemoveTask();
    }

    public void ejecutarContador(View v){
        Intent i = new Intent(this, MainActivity.class);
        EditText v1 = findViewById(R.id.valorinicial);
        int v2 = Integer.parseInt(v1.getText().toString());
        i.putExtra("d1",v2);
        startActivity(i);
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
}