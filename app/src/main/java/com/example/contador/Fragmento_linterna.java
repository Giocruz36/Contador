package com.example.contador;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragmento_linterna extends Fragment {
    private boolean encendida;
    private ImageView botonCamara;
    public Fragmento_linterna() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void botonEnciendaFlash(){
        botonCamara.setImageResource(R.drawable.linterna);
        Activity estaActividad = getActivity();
        ((ManejaCamara) estaActividad).EnciendeApaga(encendida);
    }
    public void botonApagaFlash(){
        botonCamara.setImageResource(R.drawable.linterna2);
        Activity estaActividad = getActivity();
        ((ManejaCamara) estaActividad).EnciendeApaga(encendida);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View fragmento= inflater.inflate(R.layout.fragment_fragmento_linterna, container, false);
        botonCamara= (ImageView) fragmento.findViewById(R.id.linterna_ini);
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
}