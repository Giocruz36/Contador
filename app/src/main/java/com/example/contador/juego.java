package com.example.contador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class juego extends AppCompatActivity implements View.OnClickListener{

    boolean gana, ganaIA;
    int[] ia = new int[9];
    int random=0, tiradas=0;
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
        for (int i = 0 ;i<=8; i++) {
            ia[i] = 0;
        }
        random = (int) (8*Math.random()+1);
    }

    @Override
    public void onClick(View view) {
        boolean tiro =false;
        switch (view.getId()){
            case R.id.uno:
                if (ia[0] == 0) {unoj.setImageResource(R.drawable.aspa);ia[0] = 1;tiradas++;tiro=true;}break;
            case  R.id.dos:
                if (ia[1] == 0) {dosj.setImageResource(R.drawable.aspa);ia[1] = 1; tiradas++;tiro=true;}break;
            case  R.id.tres:
                if (ia[2] == 0) {tresj.setImageResource(R.drawable.aspa);ia[2] = 1; tiradas++;tiro=true;}break;
            case  R.id.cuatro:
                if (ia[3] == 0) {cuatroj.setImageResource(R.drawable.aspa);ia[3] = 1; tiradas++;tiro=true;}break;
            case  R.id.cinco:
                if (ia[4] == 0) {cincoj.setImageResource(R.drawable.aspa);ia[4] = 1; tiradas++;tiro=true;}break;
            case  R.id.seis:
                if (ia[5] == 0) {seisj.setImageResource(R.drawable.aspa);ia[5] = 1; tiradas++;tiro=true;}break;
            case  R.id.siete:
                if (ia[6] == 0) {sietej.setImageResource(R.drawable.aspa);ia[6] = 1; tiradas++;tiro=true;}break;
            case  R.id.ocho:
                if (ia[7] == 0) {ochoj.setImageResource(R.drawable.aspa);ia[7] = 1; tiradas++;tiro=true;}break;
            case  R.id.nueve:
                if (ia[8] == 0) {nuevej.setImageResource(R.drawable.aspa);ia[8] = 1; tiradas++;tiro=true;}break;
        }if (tiro==true){
            ganador();
            if (tiradas<5&&gana==false&&ganaIA==false){
                tiraIA();
            }
            ganador();
            ganador2();
            check();
        }
    }

    public void reiniciar1 (View r){
        gana=false;
        ganaIA=false;
        tiradas=0;
        unoj.setImageDrawable(null);
        dosj.setImageDrawable(null);
        tresj.setImageDrawable(null);
        cuatroj.setImageDrawable(null);
        cincoj.setImageDrawable(null);
        seisj.setImageDrawable(null);
        sietej.setImageDrawable(null);
        ochoj.setImageDrawable(null);
        nuevej.setImageDrawable(null);
        for (int i = 0 ;i<=8; i++) {
            ia[i] = 0;
        }
        random = (int) (8*Math.random()+1);
    }

    public void tiraIA(){
        random = (int) (8*Math.random()+1);
        if (ia[random]==0){
            ia[random] = 2;
            switch (random){
                case 0: unoj.setImageResource(R.drawable.circulo);break;
                case 1: dosj.setImageResource(R.drawable.circulo);break;
                case 2: tresj.setImageResource(R.drawable.circulo);break;
                case 3: cuatroj.setImageResource(R.drawable.circulo);break;
                case 4: cincoj.setImageResource(R.drawable.circulo);break;
                case 5: seisj.setImageResource(R.drawable.circulo);break;
                case 6: sietej.setImageResource(R.drawable.circulo);break;
                case 7: ochoj.setImageResource(R.drawable.circulo);break;
                case 8: nuevej.setImageResource(R.drawable.circulo);break;
                default:break;
            }
        }else {
            tiraIA();
        }
    }//fin del tiraIA

    public void check(){
        if (gana==true){
            Toast msj = Toast.makeText(this,"Has Ganado",Toast.LENGTH_LONG);
            msj.show();
            reinicarActivity(this);
        }

        if (ganaIA==true){
            Toast msj = Toast.makeText(this,"Ha Ganado la IA",Toast.LENGTH_LONG);
            msj.show();
            reinicarActivity(this);
        }

        if (tiradas==5&&gana==false&&ganaIA==false){
            Toast msj = Toast.makeText(this,"Hay un Empate",Toast.LENGTH_LONG);
            msj.show();
            reinicarActivity(this);
        }
    }//fin del check

    public static void reinicarActivity(Activity activity){
        Intent i =  new Intent();
        i.setClass(activity,activity.getClass());
        activity.startActivity(i);
        activity.finish();
    }//fin del reinicioactivity

    public void ganador(){
        //gana jugador
        if (ia[0]==1&&ia[1]==1&&ia[2]==1){
            gana=true;
        }
        if (ia[3]==1&&ia[4]==1&&ia[5]==1){
            gana=true;
        }
        if (ia[6]==1&&ia[7]==1&&ia[8]==1){
            gana=true;
        }
        if (ia[0]==1&&ia[3]==1&&ia[6]==1){
            gana=true;
        }
        if (ia[1]==1&&ia[4]==1&&ia[7]==1){
            gana=true;
        }
        if (ia[2]==1&&ia[5]==1&&ia[8]==1){
            gana=true;
        }
        if (ia[0]==1&&ia[4]==1&&ia[8]==1){
            gana=true;
        }
        if (ia[2]==1&&ia[4]==1&&ia[6]==1){
            gana=true;
        }
        //gana IA
        if (ia[0]==2&&ia[1]==2&&ia[2]==2){
            ganaIA=true;
        }
        if (ia[3]==2&&ia[4]==2&&ia[5]==2){
            ganaIA=true;
        }
        if (ia[6]==2&&ia[7]==2&&ia[8]==2){
            ganaIA=true;
        }
        if (ia[0]==2&&ia[3]==2&&ia[6]==2){
            ganaIA=true;
        }
        if (ia[1]==2&&ia[4]==2&&ia[7]==2){
            ganaIA=true;
        }
        if (ia[2]==2&&ia[5]==1&&ia[8]==1){
            ganaIA=true;
        }
        if (ia[0]==2&&ia[4]==2&&ia[8]==2){
            ganaIA=true;
        }
        if (ia[2]==2&&ia[4]==2&&ia[6]==2) {
            ganaIA = true;
        }
    }//fin del ganador1

    public void ganador2(){
        //gana jugador
        if (ia[2]==1&&ia[1]==1&&ia[0]==1){
            gana=true;
        }
        if (ia[5]==1&&ia[4]==1&&ia[3]==1){
            gana=true;
        }
        if (ia[8]==1&&ia[7]==1&&ia[6]==1){
            gana=true;
        }
        if (ia[6]==1&&ia[3]==1&&ia[0]==1){
            gana=true;
        }
        if (ia[7]==1&&ia[4]==1&&ia[1]==1){
            gana=true;
        }
        if (ia[8]==1&&ia[5]==1&&ia[2]==1){
            gana=true;
        }
        if (ia[8]==1&&ia[4]==1&&ia[0]==1){
            gana=true;
        }
        if (ia[6]==1&&ia[4]==1&&ia[2]==1){
            gana=true;
        }
        //gana IA
        if (ia[2]==2&&ia[1]==2&&ia[0]==2){
            ganaIA=true;
        }
        if (ia[5]==2&&ia[4]==2&&ia[3]==2){
            ganaIA=true;
        }
        if (ia[8]==2&&ia[7]==2&&ia[6]==2){
            ganaIA=true;
        }
        if (ia[6]==2&&ia[3]==2&&ia[0]==2){
            ganaIA=true;
        }
        if (ia[7]==2&&ia[4]==2&&ia[1]==2){
            ganaIA=true;
        }
        if (ia[8]==2&&ia[5]==2&&ia[2]==2){
            ganaIA=true;
        }
        if (ia[8]==2&&ia[4]==2&&ia[0]==2){
            ganaIA=true;
        }
        if (ia[6]==2&&ia[4]==2&&ia[2]==2){
            ganaIA=true;
        }
    }//fin del ganador2

    public void cerrar_juego1 (View view){
        finishAndRemoveTask();
    }
}
