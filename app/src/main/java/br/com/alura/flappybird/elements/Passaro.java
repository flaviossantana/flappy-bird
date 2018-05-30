package br.com.alura.flappybird.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.flappybird.graphic.Cores;

public class Passaro {

    public static final float RAIO = 50;
    public static final float x = 100;
    public static final Paint COR = Cores.getCorDoPassaro();
    private float altura;

    public Passaro() {
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(x, altura, RAIO, COR);
    }

    public void cai() {
        this.altura += 5;
    }
}
