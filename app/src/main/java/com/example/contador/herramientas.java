package com.example.contador;
import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class herramientas extends AppCompatActivity implements ComunicaMenu, ManejaCamara {
    private Fragment[] misFragmentos;
    private CameraManager Micamara;
    private String idCamara;
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas);
        misFragmentos=new Fragment[3];
        misFragmentos[0]= new Fragmento_linterna();
        misFragmentos[1]= new Fragmento_musica();
        misFragmentos[2]= new Fragmento_nivel();
        Micamara=(CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            idCamara=Micamara.getCameraIdList()[0];
        }catch (Exception e){
            e.printStackTrace();
        }
}

    @Override
    public void EnciendeApaga(boolean estadoFlash) {
        try{
            if (estadoFlash) {
                Toast.makeText(this, "Flash inactivo", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Micamara.setTorchMode(idCamara,false);
                }

            } else {
                Toast.makeText(this, "Flash activo", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Micamara.setTorchMode(idCamara,true);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
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

}
