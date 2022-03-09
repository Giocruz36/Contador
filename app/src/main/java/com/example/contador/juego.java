package com.example.contador;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class juego extends AppCompatActivity implements View.OnClickListener{

    boolean pl1 = false, pl2=false, running;
    TextView jugador1,jugador2;
    int[] player2 = new int[9];
    int random;
    ImageView unoj,dosj,tresj,cuatroj,cincoj,seisj,sietej,ochoj,nuevej;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        unoj = (ImageView) findViewById(R.id.uno);
        unoj.setOnClickListener(this);
        dosj = (ImageView) findViewById(R.id.dos);
        dosj.setOnClickListener(this);
        tresj = (ImageView) findViewById(R.id.tres);
        tresj.setOnClickListener(this);
        cuatroj = (ImageView) findViewById(R.id.cuatro);
        cuatroj.setOnClickListener(this);
        cincoj = (ImageView) findViewById(R.id.cinco);
        cincoj.setOnClickListener(this);
        seisj = (ImageView) findViewById(R.id.seis);
        seisj.setOnClickListener(this);
        sietej = (ImageView) findViewById(R.id.siete);
        sietej.setOnClickListener(this);
        ochoj = (ImageView) findViewById(R.id.ocho);
        ochoj.setOnClickListener(this);
        nuevej = (ImageView) findViewById(R.id.nueve);
        nuevej.setOnClickListener(this);

        jugador1 = (TextView) findViewById(R.id.player1);
        jugador2 = (TextView) findViewById(R.id.player2);

    }

    @Override
    public void onClick(View view) {

    }
    public void inicar (View i){
        if (!running){
            running =true;
            jugador2.setText("Perros");
            jugador1.setText("Gatos");
        }
    }
    public void cerrar_juego2 (View view){
        finishAndRemoveTask();
    }
}
