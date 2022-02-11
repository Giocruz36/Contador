package com.example.contador;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class menu_juego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitity_juego_principal);
    }

    public void ejecutarinicio(View view){
        Intent i = new Intent(this, Pagina_principal.class);
        startActivity(i);
    }
}
