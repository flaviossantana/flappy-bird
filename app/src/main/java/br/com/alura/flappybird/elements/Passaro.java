package br.com.alura.flappybird.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.alura.flappy_bird.R;
import br.com.alura.flappybird.graphic.Cores;
import br.com.alura.flappybird.graphic.Tela;

public class Passaro {

    private float altura;
    private final Tela tela;
    public static final  float X = 100;
    public static final int RAIO = 75;
    public static final Paint COR = Cores.getCorDoPassaro();
    private final Bitmap passaro;

    public Passaro(Tela tela, Context context) {
        this.altura = 100;
        this.tela = tela;

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_app);
        this.passaro = Bitmap.createScaledBitmap(bitmap, RAIO * 2, RAIO * 2, false);

    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(X, altura, RAIO, COR);
        canvas.drawBitmap(this.passaro, X - RAIO, altura - RAIO, null);
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
