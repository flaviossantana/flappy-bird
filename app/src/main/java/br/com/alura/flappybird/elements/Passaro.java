package br.com.alura.flappybird.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.flappybird.graphic.Cores;
import br.com.alura.flappybird.graphic.Tela;

public class Passaro {

    public static final float RAIO = 75;
    public static final  float x = 100;
    public static final Paint COR = Cores.getCorDoPassaro();
    private final Tela tela;
    private float altura;

    public Passaro(Tela tela) {
        this.altura = 100;
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(x, altura, RAIO, COR);
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
}
