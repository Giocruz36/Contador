package com.example.contador;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class juego2 extends AppCompatActivity implements View.OnClickListener{
    boolean ganaP1, ganaP2;
    int[] matriz = new int[9];
    int random=0, tiradas=0,jugador=1;
    ImageView unoj,dosj,tresj,cuatroj,cincoj,seisj,sietej,ochoj,nuevej;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2juego);

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

    }

    @Override
    public void onClick(View view) {
        boolean tiro =false;
        switch (view.getId()){
            case R.id.uno:
                if (matriz[0]==0&&jugador==1){
                    unoj.setImageResource(R.drawable.circulo);
                    matriz[0]=1;
                    tiro=true;
                }
                if (matriz[0]==0&&jugador==2){
                    unoj.setImageResource(R.drawable.aspa);
                    matriz[0]=2;
                    tiro=true;}
                break;
            case R.id.dos:
                if (matriz[1]==0&&jugador==1){
                    dosj.setImageResource(R.drawable.circulo);
                    matriz[1]=1;
                    tiro=true;
                }
                if (matriz[1]==0&&jugador==2){
                    dosj.setImageResource(R.drawable.aspa);
                    matriz[1]=2;
                    tiro=true;
                }
                break;
            case R.id.tres:
                if (matriz[2]==0&&jugador==1){
                    tresj.setImageResource(R.drawable.circulo);
                    matriz[2]=1;
                    tiro=true;
                }
                if (matriz[2]==0&&jugador==2){
                    tresj.setImageResource(R.drawable.aspa);
                    matriz[2]=2;
                    tiro=true;}
                break;
            case R.id.cuatro:
                if (matriz[3]==0&&jugador==1){
                    cuatroj.setImageResource(R.drawable.circulo);
                    matriz[3]=1;
                    tiro=true;
                }
                if (matriz[3]==0&&jugador==2){
                    cuatroj.setImageResource(R.drawable.aspa);
                    matriz[3]=2;
                    tiro=true;
                }
                break;
            case R.id.cinco:
                if (matriz[4]==0&&jugador==1){
                    cincoj.setImageResource(R.drawable.circulo);
                    matriz[4]=1;
                    tiro=true;
                }
                if (matriz[4]==0&&jugador==2){
                    cincoj.setImageResource(R.drawable.aspa);
                    matriz[4]=2;
                    tiro=true;
                }
                break;
            case R.id.seis:
                if (matriz[5]==0&&jugador==1){
                    seisj.setImageResource(R.drawable.circulo);
                    matriz[5]=1;
                    tiro=true;
                }
                if (matriz[5]==0&&jugador==2){
                    seisj.setImageResource(R.drawable.aspa);
                    matriz[5]=2;
                    tiro=true;
                }
                break;
            case R.id.siete:
                if (matriz[6]==0&&jugador==1){
                    sietej.setImageResource(R.drawable.circulo);
                    matriz[6]=1;
                    tiro=true;
                }
                if (matriz[6]==0&&jugador==2){
                    sietej.setImageResource(R.drawable.aspa);
                    matriz[6]=2;
                    tiro=true;
                }
                break;
            case R.id.ocho:
                if (matriz[7]==0&&jugador==1){
                    ochoj.setImageResource(R.drawable.circulo);
                    matriz[7]=1;
                    tiro=true;
                }
                if (matriz[7]==0&&jugador==2){
                    ochoj.setImageResource(R.drawable.aspa);
                    matriz[7]=2;
                    tiro=true;
                }
                break;
            case R.id.nueve:
                if (matriz[8]==0&&jugador==1){
                    nuevej.setImageResource(R.drawable.circulo);
                    matriz[8]=1;
                    tiro=true;
                }
                if (matriz[8]==0&&jugador==2){
                    nuevej.setImageResource(R.drawable.aspa);
                    matriz[8]=2;
                    tiro=true;
                }
                break;
        }
        if (tiro==true){
            if (jugador==1){
                jugador=2;
            }else {
                jugador=1;
            }
        }
        tiradas++;
        ganador();
        ganador2();
        check();
    }//fin del tiradas

    public void ganador(){
        //gana jugador
        if (matriz[0]==1&&matriz[1]==1&&matriz[2]==1){
            ganaP1=true;
        }
        if (matriz[3]==1&&matriz[4]==1&&matriz[5]==1){
            ganaP1=true;
        }
        if (matriz[6]==1&&matriz[7]==1&&matriz[8]==1){
            ganaP1=true;
        }
        if (matriz[0]==1&&matriz[3]==1&&matriz[6]==1){
            ganaP1=true;
        }
        if (matriz[1]==1&&matriz[4]==1&&matriz[7]==1){
            ganaP1=true;
        }
        if (matriz[2]==1&&matriz[5]==1&&matriz[8]==1){
            ganaP1=true;
        }
        if (matriz[0]==1&&matriz[4]==1&&matriz[8]==1){
            ganaP1=true;
        }
        if (matriz[2]==1&&matriz[4]==1&&matriz[6]==1){
            ganaP1=true;
        }
        //gana IA
        if (matriz[0]==2&&matriz[1]==2&&matriz[2]==2){
            ganaP2=true;
        }
        if (matriz[3]==2&&matriz[4]==2&&matriz[5]==2){
            ganaP2=true;
        }
        if (matriz[6]==2&&matriz[7]==2&&matriz[8]==2){
            ganaP2=true;
        }
        if (matriz[0]==2&&matriz[3]==2&&matriz[6]==2){
            ganaP2=true;
        }
        if (matriz[1]==2&&matriz[4]==2&&matriz[7]==2){
            ganaP2=true;
        }
        if (matriz[2]==2&&matriz[5]==1&&matriz[8]==1){
            ganaP2=true;
        }
        if (matriz[0]==2&&matriz[4]==2&&matriz[8]==2){
            ganaP2=true;
        }
        if (matriz[2]==2&&matriz[4]==2&&matriz[6]==2) {
            ganaP2 = true;
        }
    }//fin del ganador1

    public void ganador2(){
        //gana jugador
        if (matriz[2]==1&&matriz[1]==1&&matriz[0]==1){
            ganaP1=true;
        }
        if (matriz[5]==1&&matriz[4]==1&&matriz[3]==1){
            ganaP1=true;
        }
        if (matriz[8]==1&&matriz[7]==1&&matriz[6]==1){
            ganaP1=true;
        }
        if (matriz[6]==1&&matriz[3]==1&&matriz[0]==1){
            ganaP1=true;
        }
        if (matriz[7]==1&&matriz[4]==1&&matriz[1]==1){
            ganaP1=true;
        }
        if (matriz[8]==1&&matriz[5]==1&&matriz[2]==1){
            ganaP1=true;
        }
        if (matriz[8]==1&&matriz[4]==1&&matriz[0]==1){
            ganaP1=true;
        }
        if (matriz[6]==1&&matriz[4]==1&&matriz[2]==1){
            ganaP1=true;
        }
        //gana IA
        if (matriz[2]==2&&matriz[1]==2&&matriz[0]==2){
            ganaP2=true;
        }
        if (matriz[5]==2&&matriz[4]==2&&matriz[3]==2){
            ganaP2=true;
        }
        if (matriz[8]==2&&matriz[7]==2&&matriz[6]==2){
            ganaP2=true;
        }
        if (matriz[6]==2&&matriz[3]==2&&matriz[0]==2){
            ganaP2=true;
        }
        if (matriz[7]==2&&matriz[4]==2&&matriz[1]==2){
            ganaP2=true;
        }
        if (matriz[8]==2&&matriz[5]==2&&matriz[2]==2){
            ganaP2=true;
        }
        if (matriz[8]==2&&matriz[4]==2&&matriz[0]==2){
            ganaP2=true;
        }
        if (matriz[6]==2&&matriz[4]==2&&matriz[2]==2){
            ganaP2=true;
        }
    }//fin del ganador2

    public void check(){
        if (ganaP1==true){
            Toast msj = Toast.makeText(this,"Ha Ganado Player 1",Toast.LENGTH_LONG);
            msj.show();
            reinicarActivity(this);
        }

        if (ganaP2==true){
            Toast msj = Toast.makeText(this,"Ha Ganado Player 2",Toast.LENGTH_LONG);
            msj.show();
            reinicarActivity(this);
        }

        if (tiradas==9&&ganaP1==false&&ganaP2==false){
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

    public void reset1 (View view){
        unoj.setImageDrawable(null);
        dosj.setImageDrawable(null);
        tresj.setImageDrawable(null);
        cuatroj.setImageDrawable(null);
        cincoj.setImageDrawable(null);
        seisj.setImageDrawable(null);
        sietej.setImageDrawable(null);
        ochoj.setImageDrawable(null);
        nuevej.setImageDrawable(null);
    }

    public void cerrar_player (View view){
        finishAndRemoveTask();
    }
}
