package com.example.contador;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;

public class NivelPantalla extends AppCompatImageView {
    int posLeft,posTop,posXY,dimenw,dimenh,radio;


    /*public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(new NivelPantalla(this));
    }*/

    public NivelPantalla(Context contexto) {
        super(contexto);
        posLeft=100;
        posTop=75;
        posXY=500;
        radio=dimenw/200-posLeft;
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        dimenw=metrics.widthPixels;
        dimenh=metrics.heightPixels;
    }

    private WindowManager getWindowManager() {
     return null;
    }

    protected void onDraw(Canvas canvas){
        Paint lapiz = new Paint();
        lapiz.setColor(Color.GRAY);
        lapiz.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,dimenw,dimenh,lapiz);
        lapiz.setColor(Color.RED);
        lapiz.setStrokeWidth(15);
        lapiz.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(dimenw/2,dimenw/2,radio,lapiz);
        lapiz.setColor(Color.BLACK);
        lapiz.setStyle(Paint.Style.FILL);
        canvas.drawCircle(dimenw/2,dimenw/2,radio,lapiz);
        lapiz.setColor(Color.RED);
        lapiz.setStyle(Paint.Style.FILL);
        canvas.drawCircle(dimenw/2,dimenw/2,radio/4,lapiz);
        canvas.drawLine(posLeft,dimenh/2,radio+dimenw/2,dimenh/2,lapiz);
        canvas.drawLine(dimenw/2,dimenh/2-radio,dimenw/2,dimenh/2+radio,lapiz);
        Path miTrazo = new Path();
        miTrazo.addCircle(dimenw/2,dimenh/2,radio,Path.Direction.CCW);
        canvas.drawPath(miTrazo,lapiz);
        lapiz.setStyle(Paint.Style.FILL);
        lapiz.setStrokeWidth(5);
        lapiz.setTextSize(100);
        lapiz.setTypeface(Typeface.SANS_SERIF);
        canvas.drawTextOnPath("Nuestro nivel",miTrazo,dimenh,100,lapiz);
    }
}
