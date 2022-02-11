package com.example.contador;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class herramientas extends AppCompatActivity implements ComunicaMenu, ManejaCamara {
    private Fragment[] misFragmentos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas);
        misFragmentos=new Fragment[3];
        misFragmentos[0]= new Fragment();
        misFragmentos[1]= new Fragmento_musica();
        misFragmentos[2]= new Fragmento_nivel();
}
    public void menu(int queboton){
    if (queboton == 3) {
        finish();
    } else {
        FragmentManager miManejador = getSupportFragmentManager();
        FragmentTransaction miTransaccion = miManejador.beginTransaction();
        miTransaccion.replace(R.id.cont_herramientas, misFragmentos[queboton]);
        miTransaccion.commit();
    }
    }

    @Override
    public void EnciendeApaga(boolean estadoFlash) {
        if (estadoFlash) {
            Toast.makeText(this, "Flash inactivo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Flash activo", Toast.LENGTH_SHORT).show();
        }
    }
}
