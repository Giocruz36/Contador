package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragmento_menu extends Fragment {
    private final int[] BOTONESMENU = {R.id.b_linterna, R.id.b_nivel,R.id.b_musica, R.id.b_salir};
    private Button botonmenu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mimenu = inflater.inflate(R.layout.fragment_fragmento_menu, container, false);
        for (int i = 0; i < BOTONESMENU.length; i++) {
            botonmenu = (Button) mimenu.findViewById(BOTONESMENU[i]);
            final int queBoton = i;
            botonmenu.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    Activity estaActividad = getActivity();
                ((ComunicaMenu) estaActividad).menu(queBoton);}});
            }
        return mimenu;
    }
}