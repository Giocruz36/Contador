package com.example.contador;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragmento_musica extends Fragment {

    private boolean encendida;
    private ImageView botonMusica;
    public Fragmento_musica() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void Apagamusica(){
        botonMusica.setImageResource(R.drawable.musica);
        Intent miReproductor=new Intent(getActivity(),Servicios.class);
        getActivity().stopService(miReproductor);
        encendida=!encendida;
    }
    public void Enciendemusica(){
        botonMusica.setImageResource(R.drawable.musica2);
        Intent miReproductor=new Intent(getActivity(),Servicios.class);
        getActivity().startService(miReproductor);
        encendida=!encendida;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmento= inflater.inflate(R.layout.fragment_fragmento_musica, container, false);
        botonMusica=(ImageView)fragmento.findViewById(R.id.muscia);
        if(encendida){
        botonMusica.setImageResource(R.drawable.musica2);         }
        botonMusica.setOnClickListener(new View.OnClickListener(){
            public void onClick(View vista){
                if (encendida){
                    Apagamusica();
                }else{
                    Enciendemusica();
        }
            }
        });
        return fragmento;
    }
}