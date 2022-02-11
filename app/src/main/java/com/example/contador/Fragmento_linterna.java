package com.example.contador;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Fragmento_linterna extends Fragment {
    private ImageView botonCamara;
    private boolean encendida;
    public Fragmento_linterna() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View fragmento= inflater.inflate(R.layout.fragment_fragmento_linterna, container, false);
        botonCamara= (ImageView) fragmento.findViewById(R.id.linterna2);
        if (encendida){
            botonCamara.setImageResource(R.drawable.linterna2);
        }
        botonCamara.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if(encendida){
                botonApagaFlash();
                encendida=false;
                }else{
                    botonEnciendaFlash();
                    encendida=true;
                }
            }
        });
        return fragmento;
    }
    public void botonEnciendaFlash(){
        botonCamara.setImageResource(R.drawable.linterna2);
    }
    public void botonApagaFlash(){
        botonCamara.setImageResource(R.drawable.linterna);
    }
}