package com.example.contador;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.*;
import androidx.appcompat.widget.Toolbar;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

import java.nio.channels.InterruptedByTimeoutException;

public class Pagina_principal extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        toolbar=(Toolbar)findViewById(R.id.menu_toolbar);
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
        if (id == R.id.contador_menu) {
            ejecutarContador(null);
            return true;
        }
        if (id == R.id.calculadora_menu) {
            ejecutaCalculadora(null);
            return true;
        }
        if (id == R.id.volver_inicio) {
            ejecutarprincipal(null);
            return true;
        }
        if (id == R.id.salir) {
            ejecutarCerrar(null);
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }

    public void ejecutarCerrar(View v) {
        finish();
    }

    public void ejecutarContador(View v){
        Intent i = new Intent(this, MainActivity.class);
        EditText v1 = (EditText)findViewById(R.id.valorinicial);
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
}