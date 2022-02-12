package com.example.contador;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int contador, num1, num2;
    static SharedPreferences datos;
    static SharedPreferences.Editor miEditor;
    String msg = "Android: ";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(msg, "The onCreate() event");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        Toolbar toolbar = (Toolbar) findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_main);
        Bundle datos = getIntent().getExtras();
        num1= datos.getInt("d1");
        contador=num1;
        mostrarResultado();
        Eventoteclado teclado=new Eventoteclado();
        EditText n_reseteo =(EditText)findViewById(R.id.valorReseteo);
        n_reseteo.setOnEditorActionListener(teclado);
    }
    class Eventoteclado implements  TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId== EditorInfo.IME_ACTION_DONE){
                reseteo(null);
            }
            return false;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();
        if (id == R.id.contador_menu) {
            ejecutarContador(null);
            return true;
        }
        if (id == R.id.calculadora_menu) {
            ejecutaCalculadora(null);
            return true;
        }
        if (id == R.id.volver_inicio) {
            ejecutarprincipal(null);
            return true;
        }
        return super.onOptionsItemSelected(opcion_menu);
    }
    public void ejecutarContador(View v){
        Intent i =new Intent(this , MainActivity.class);
        startActivity(i);
    }
    public void ejecutarprincipal(View view){
        Intent i = new Intent(this,Pagina_principal.class);
        startActivity(i);
    }
    public void ejecutaCalculadora(View view) {
        Intent i = new Intent(this, calculadora.class);
        startActivity(i);
    }
    public void sumar (View j){
        contador=contador+1;
        mostrarResultado();
    }

    public void reseteo (View v) {
        EditText numero_reseteo=(EditText)findViewById(R.id.valorReseteo);
        try {
            contador=Integer.parseInt(numero_reseteo.getText().toString());
        }catch(Exception e){
            contador=0;
        }
        mostrarResultado();
        numero_reseteo.setText("");
        InputMethodManager teclado=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        teclado.hideSoftInputFromWindow(numero_reseteo.getWindowToken(),0);
    }

    public void restar (View c){
        contador=contador-1;
        if (contador<0){
            CheckBox negativos=(CheckBox)findViewById(R.id.negativos);
            if (!negativos.isChecked()){
        contador=0;
            }
        }
        mostrarResultado();
    }

    public void mostrarResultado(){
        TextView resultado=(TextView) findViewById(R.id.valorContador);
        resultado.setText("" + contador);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(msg,"The onStart() event");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(msg,"The onPause() event");
        datos = PreferenceManager.getDefaultSharedPreferences(this);
        //para decirle que queremos editar
        miEditor = datos.edit();
        miEditor.putInt("cuenta",contador);
        miEditor.putInt("numvuelta",num2);
        miEditor.apply();
    }

        @Override
        public void onResume(){
            super.onResume();
            Log.d(msg,"The onResume() event");
            SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
            int num3=datos.getInt("cuenta",0);
            if(num2==0){
                contador=num1;
            }else{
                contador=num3;
            }
            num2++;
            contador = datos.getInt("cuenta",num1);
            mostrarResultado();
        }

        @Override
        public void onStop(){
            super.onStop();
            Log.d(msg,"The onStop() event");
        }

        @Override
        public void onDestroy(){
            super.onDestroy();
            datos.edit().remove("cuenta").commit();
            datos.edit().remove("numvuelta").commit();
            miEditor.clear();
            miEditor.commit();
            Log.d(msg,"The onDestroy() event");
        }

}