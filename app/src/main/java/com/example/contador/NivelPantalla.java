package com.example.contador;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

public class NivelPantalla extends AppCompatImageView {
    int posLeft,posTop,posXY,dimenw,dimenh,radio;
    float[] angulos;
    Bitmap fondo, burbuja;

    public NivelPantalla(Context contexto, int dw, int dh) {
        super(contexto);
        dimenh=dh;
        dimenw=dw;
        posLeft=100;
        posTop=75;
        posXY=100;
        radio=dimenh/2-posLeft;
        fondo = iniciaFondo();
        angulos=new float[2];
        angulos[0]=0;
        angulos[1]=0;
        BitmapDrawable bola = (BitmapDrawable) ContextCompat.getDrawable(contexto,R.drawable.burbuja);
        burbuja = bola.getBitmap();
        burbuja=Bitmap.createScaledBitmap(burbuja,radio/4,radio/4,true);
    }
    public void angulos(float[]angulos){
        this.angulos=angulos;
        invalidate();
    }
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(dimenw, dimenh);
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(fondo,0,0,null);
        int posX = radio+(int)(angulos[0]/10*radio)+posLeft/2;
        int posY = radio-(int)(angulos[1]/10*radio)+(dimenh/4);
        canvas.drawBitmap(burbuja,posX,posY,null);
    }

    private Bitmap iniciaFondo() {
        Bitmap.Config conf = Bitmap.Config.ARGB_4444;
        Bitmap fondo = Bitmap.createBitmap(dimenw,dimenh,conf);
        Canvas canvas = new Canvas(fondo);
        Paint lapiz = new Paint();
        lapiz.setColor(Color.GRAY);
        lapiz.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, dimenw, dimenh, lapiz);
        lapiz.setColor(Color.RED);
        lapiz.setStrokeWidth(15);
        lapiz.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(dimenw/2, dimenh/2, radio, lapiz);
        Path miTrazo =new Path();
        miTrazo.addCircle(dimenw/2,dimenh/2,radio,Path.Direction.CCW);
        canvas.drawPath(miTrazo,lapiz);
        lapiz.setStyle(Paint.Style.FILL);
        lapiz.setStrokeWidth(5);
        lapiz.setTextSize(100);
        lapiz.setTypeface(Typeface.SANS_SERIF);
        canvas.drawTextOnPath("Nuestro nivel",miTrazo,dimenh,100,lapiz);
        lapiz.setColor(Color.BLACK);
        lapiz.setStyle(Paint.Style.FILL);
        canvas.drawCircle(dimenw/2, dimenh/2, radio, lapiz);
        lapiz.setColor(Color.RED);
        lapiz.setStyle(Paint.Style.FILL);
        canvas.drawCircle(dimenw/2, dimenh/2, radio/4, lapiz);
        canvas.drawLine(posLeft,dimenh/2, radio+dimenw/2, dimenh/2, lapiz);
        canvas.drawLine(dimenw/2,dimenh/2-radio, dimenw/2, dimenh/2+radio, lapiz);
        return fondo;
    }
}
