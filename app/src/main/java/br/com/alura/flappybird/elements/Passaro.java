package br.com.alura.flappybird.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.flappybird.graphic.Cores;
import br.com.alura.flappybird.graphic.Tela;

public class Passaro {

    private float altura;
    private final Tela tela;
    public static final  float X = 100;
    public static final float RAIO = 75;
    public static final Paint COR = Cores.getCorDoPassaro();

    public Passaro(Tela tela) {
        this.altura = 100;
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(X, altura, RAIO, COR);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if(!chegouNoChao){
            this.altura += 5;
        }
    }

    public void pula() {
        if(altura - RAIO > 0){
            this.altura -= 100;
        }
    }

    public float getAltura() {
        return altura;
    }
}
