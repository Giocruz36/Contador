package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.*;
import android.view.*;
import android.widget.*;

public class calculadora extends AppCompatActivity {

    Double numero1,numero2,resultado;
    String operador,aux;
    TextView tv,tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        Toolbar toolbar = (Toolbar) findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);
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

    public void onClickIgual(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero);
         tv1 = (TextView)findViewById(R.id.mostrar);
         numero2 = Double.parseDouble(tv.getText().toString());

        if(operador.equals("+"))
            resultado = numero1 + numero2;
        else if(operador.equals("-"))
        {
            resultado= numero1-numero2;
        }
        else if(operador.equals("*"))
        {
            resultado= numero1*numero2;
        }
        else if(operador.equals("/"))
        {
            resultado= numero1/numero2;
        }
        tv.setText(resultado.toString());
        tv1.setText(numero1.toString()+operador+numero2.toString()+"=");
    }

    public void onClickSuma(View miView)
    {
        operador="+";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickResta(View miView)
    {
        operador="-";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickMultiplicacion(View miView)
    {
        operador="*";
        onClickOperacionCapturaNumero1(miView);
    }
    public void onClickDivision(View miView)
    {
        operador="/";
        onClickOperacionCapturaNumero1(miView);
    }

    public void onClickOperacionCapturaNumero1(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero);
        numero1 = Double.parseDouble(tv.getText().toString());
        tv.setText("");
    }
    public void onClickLimpia(View miView)
    {
        numero1=0.0;
        numero2=0.0;
         tv = (TextView) findViewById(R.id.txtNumero);
         tv1=(TextView)findViewById(R.id.mostrar);
         tv.setText("");
         tv1.setText("");
    }

    public void onClickBtn1(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "1");
    }
    public void onClickBtn2(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "2");
    }
    public void onClickBtn3(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "3");
    }
    public void onClickBtn4(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "4");
    }
    public void onClickBtn5(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero);
        tv.setText(tv.getText() + "5");
    }
    public void onClickBtn6(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero) ;
        tv.setText(tv.getText() + "6");
    }
    public void onClickBtn7(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero) ;
        tv.setText(tv.getText() + "7");
    }
    public void onClickBtn8(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero) ;
        tv.setText(tv.getText() + "8");
    }
    public void onClickBtn9(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero) ;
        tv.setText(tv.getText() + "9");
    }
    public void onClickBtn0(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero) ;
        tv.setText(tv.getText() + "0");
    }
    public void onClickBtnPunto(View miView)
    {
         tv = (TextView) findViewById(R.id.txtNumero) ;
        tv.setText(tv.getText() + ".");
    }

    public void onClickBtnBorra(View miView){
         tv = (TextView)findViewById(R.id.txtNumero);
        aux = tv.getText().toString();
        int input = aux.length();
        if (input > 0){
            tv.setText(aux.substring(0, input-1));
        }
    }
}